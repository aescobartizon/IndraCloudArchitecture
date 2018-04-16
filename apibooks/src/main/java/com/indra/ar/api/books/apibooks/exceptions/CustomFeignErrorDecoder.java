package com.indra.ar.api.books.apibooks.exceptions;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class CustomFeignErrorDecoder implements ErrorDecoder {

    private ErrorDecoder delegate = new ErrorDecoder.Default();

    private ObjectMapper mapper = new ObjectMapper();
    
    private final String OBJECT_NOT_FOUND = "Not founded : ";
    
    @Override
    public Exception decode(String methodKey, Response response) {

        log.trace("An exception has been caught in {}, trying to parse the playload.", methodKey);

        if (response.body() == null) {
            log.error("Failed to parse the playload: Response has no body.");
            return getDelegate().decode(methodKey, response);
        }
        
        
        Map<String, String> map;
        
		try {
			final String body = Util.toString(response.body().asReader());
			map = getMapper().readValue(body, new TypeReference<Map<String, String>>() {});
		} catch (IOException e) {
			log.trace("Failed to parse the playload. The format of the message does not correspond with the predefined for ambar.",e);
			return delegate.decode(methodKey, response);
		}
		
		final HttpStatus status = HttpStatus.valueOf(response.status());

		final String message = map.get("message");
		
		log.trace("Throwing proper exception with this message \"{}\" ", message);

		if (status == HttpStatus.FORBIDDEN || status == HttpStatus.UNAUTHORIZED) {
			return new RestClientException("");
		} else if (status.is4xxClientError()) {
			return new NotFoundException(OBJECT_NOT_FOUND+message);
		} else {
			return new RestClientException("");
		} 
    }
}