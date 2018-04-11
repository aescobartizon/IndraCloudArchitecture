package com.indra.ar.books.services;

public interface CrudService<T> {
	
	void insert(T element);
	
	void update(T element);
	
	void delete(T element);
	
	T findByid();

}
