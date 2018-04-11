package com.indra.ar.books.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.indra.ar.books.domain.LibroDTO;
import com.indra.ar.books.repositories.BooksRepository;

import lombok.Getter;

public class BooksCrudService implements CrudService<LibroDTO>{

	@Autowired
	@Getter
	BooksRepository booksRepository;
	
	@Autowired
	@Getter
	private ModelMapper modelMapper;
	
	@Override
	public void insert(LibroDTO element) {
		//getBooksRepository().save(LibroDTO)
		
	}

	@Override
	public void update(LibroDTO element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LibroDTO element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LibroDTO findByid() {
		// TODO Auto-generated method stub
		return null;
	}

}
