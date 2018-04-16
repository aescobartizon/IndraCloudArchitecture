package com.indra.ar.api.books.apibooks.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.indra.ar.api.books.apibooks.exceptions.CustomFeignErrorDecoder;

@Configuration
public class ApiConfig {

	@Bean
	public CustomFeignErrorDecoder customErrorDecoder(){
		return new CustomFeignErrorDecoder();
	}
}
