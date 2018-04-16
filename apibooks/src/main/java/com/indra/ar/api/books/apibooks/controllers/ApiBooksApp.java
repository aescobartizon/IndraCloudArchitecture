package com.indra.ar.api.books.apibooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.ar.api.books.apibooks.domain.LibroDTO;
import com.indra.ar.api.books.apibooks.proxy.BooksServiceProxy;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/apibooks/")
public class ApiBooksApp extends AbstractController implements ApiBooks{

	private static final String BOOKS_END_POINT = "/books";
	
	@Autowired
	@Setter
	@Getter
	BooksServiceProxy booksServiceProxy;
	
	@GetMapping(path = BOOKS_END_POINT + "/{id}")
    @ApiOperation(value = "Display book info to non-admin user", response = LibroDTO.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
	public LibroDTO getBook(@PathVariable Long id) {
		
//		Map<String, Long> uriVariables = new HashMap<>();
//		uriVariables.put("id", id);
//		ResponseEntity<LibroDTOImp> currencyConversion = new RestTemplate().getForEntity(
//				"http://localhost:8081/api/books/{id}", LibroDTOImp.class, uriVariables);
//		LibroDTO response = currencyConversion.getBody();
//		
//		return response;
			
		LibroDTO result =  getBooksServiceProxy().getBook(id);
		return result;
		
		//Resource<LibroDTO> resource = new Resource<>(result);

		//return resource;

	}
}
