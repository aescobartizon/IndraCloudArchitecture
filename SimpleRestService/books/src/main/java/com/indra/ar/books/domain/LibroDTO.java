package com.indra.ar.books.domain;

import java.util.Date;

public interface LibroDTO extends GenericDTO{

	String getTitulo();
	
	void setTitulo(String titulo);
	
	String getAutor();
	
	void setAutor(String autor);
	
	Date getFechaPublicacion();
	
	void setFechaPublicacion(Date fechaPublicacion);
	
	String getIsbn();
	
	void setIsbn(String isbn);
}
