package com.indra.ar.api.books.apibooks.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.indra.ar.api.books.apibooks.domain.LibroDTOImp;

@FeignClient(name="books-server",url="localhost:8081",decode404 = true)
public interface BooksServiceProxy {

	@GetMapping(value="/api/books/{id}")
	public LibroDTOImp getBook(@PathVariable("id") Long id);

}
