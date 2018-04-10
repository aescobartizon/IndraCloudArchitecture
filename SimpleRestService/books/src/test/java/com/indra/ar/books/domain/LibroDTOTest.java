package com.indra.ar.books.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LibroDTOTest {
	
	private final String titulo = "TITULO";
	
	private final String autor = "AUTOR";
	
	private final Date fechaPublicacion = new Date();
	
	private final String isbn = "ISBN";

	@Test
	public void build() {
		LibroDTO libro = LibroDTOImp.builder().build();
		assertNotNull(libro);	
	}
	
	@Test
	public void initAttributes() {
		LibroDTO libro = LibroDTOImp.builder().autor(autor).titulo(titulo).fechaPublicacion(fechaPublicacion).isbn(isbn).build();
		
		assertEquals(autor,libro.getAutor());
		
		assertEquals(titulo,libro.getTitulo());
		
		assertEquals(fechaPublicacion.getTime(),libro.getFechaPublicacion().getTime());
		
		assertEquals(isbn,libro.getIsbn());
		
	}
	
	@Test
	public void deepClone() {
		
		LibroDTO libro = LibroDTOImp.builder().autor(autor).titulo(titulo).fechaPublicacion(fechaPublicacion).isbn(isbn).build();
	
		LibroDTO libroCloned = libro.deepClone();
		
		libroCloned.setAutor("AUTOR2");
		
		assertEquals(autor,libro.getAutor());
		
		assertEquals("AUTOR2",libroCloned.getAutor());
	}
}
