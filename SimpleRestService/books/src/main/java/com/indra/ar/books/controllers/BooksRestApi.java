package com.indra.ar.books.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.indra.ar.books.domain.LibroDTO;
import com.indra.ar.books.services.BooksService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;

@RestController
@Api(value = "Books", description = "Rest API for books operations", tags = "Books API")
public class BooksRestApi extends AbstractController{

	private static final String BOOKS_END_POINT = "/books";
	
	@Autowired
	@Getter
	BooksService bookService;
	
	@GetMapping(path = BOOKS_END_POINT + "/{id}")
    @ApiOperation(value = "Display book info to non-admin user", response = LibroDTO.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
	public Resource<LibroDTO> retrieveUser(@PathVariable Long id) {
			
		LibroDTO result =  getBookService().findByid(id);
		
		Resource<LibroDTO> resource = new Resource<>(result);
		
		return resource;

	}
}
