package com.indra.ar.api.books.apibooks.proxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.indra.ar.api.books.apibooks.domain.LibroDTOImp;


@FeignClient(name="books-service",url="${books.externalServer.url}")
public interface BooksServiceProxy {

	@GetMapping(value="/api/books/{id}")
	public LibroDTOImp getBook(@PathVariable("id") Long id);
	
	@GetMapping(path = "/api/findbooks/{titulo}")
	List<LibroDTOImp> getBooksByTitulo(@PathVariable("titulo") String titulo);
	
	@PostMapping(path = "/api/books/")
	LibroDTOImp createBook(@Valid @RequestBody LibroDTOImp libro);
	
	@PutMapping(path = "/api/books/")
	LibroDTOImp updateBook(@Valid @RequestBody LibroDTOImp libro);
	
	@DeleteMapping(path = "/api/books/{id}")
	public void deleteBook(@PathVariable("id") Long id);
}
