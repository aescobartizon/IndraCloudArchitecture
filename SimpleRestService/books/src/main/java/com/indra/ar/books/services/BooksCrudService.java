package com.indra.ar.books.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.ar.books.domain.LibroDTO;
import com.indra.ar.books.entities.Books;
import com.indra.ar.books.exceptions.BookNotFoundException;
import com.indra.ar.books.repositories.BooksRepository;

import lombok.Getter;

@Service
public class BooksCrudService extends AbstractService implements BooksService{

	@Autowired
	@Getter
	BooksRepository booksRepository;
	
	@Override
	public void save(LibroDTO element) {
		getBooksRepository().save(getTransformDtoToEntity().LibroDtoToBooks(element));	
	}

	@Override
	public void delete(LibroDTO element) {
		getBooksRepository().delete(getTransformDtoToEntity().LibroDtoToBooks(element));
		
	}
	
	@Override
	public void deleteById(Long id) {
		getBooksRepository().deleteById(id);
		
	}

	@Override
	public LibroDTO findByid(Long id) {
		
		Optional<Books> result = getBooksRepository().findById(id);
		
		if(result.isPresent()) {
			return getTransformDtoToEntity().BooksToLibroDto(result.get());
		}else {
			throw new BookNotFoundException("Book id "+id.toString());
		}
	}

}
