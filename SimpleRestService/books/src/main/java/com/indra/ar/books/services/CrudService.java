package com.indra.ar.books.services;

public interface CrudService<T> {
	
	void save(T element);
	
	void delete(T element);
	
	T findByid(Long id);
	
	void deleteById(Long id); 

}
