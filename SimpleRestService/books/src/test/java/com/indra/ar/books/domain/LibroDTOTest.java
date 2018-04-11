package com.indra.ar.books.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LibroDTOTest {
	
	private static final String TITULO = "TITULO";
	
	private static final String AUTOR = "AUTOR";
	
	private static final Long FECHA_PUBLICACION = new Date().getTime();
	
	private static final String ISBN = "ISBN";
	
	private static final Long ID = 1L;

	@Test
	public void build() {
		LibroDTO libro = LibroDTOImp.builder().build();
		assertNotNull(libro);	
	}
	
	@Test
	public void initAttributes() {
		LibroDTO libro = LibroDTOImp.builder().id(ID).autor(AUTOR).titulo(TITULO).fechaPublicacion(FECHA_PUBLICACION).isbn(ISBN).build();
		
		assertEquals(ID,libro.getId());
		
		assertEquals(AUTOR,libro.getAutor());
		
		assertEquals(TITULO,libro.getTitulo());
		
		assertEquals(FECHA_PUBLICACION,libro.getFechaPublicacion());
		
		assertEquals(ISBN,libro.getIsbn());
		
	}
	
	@Test
	public void deepClone() {
		
		LibroDTO libro = LibroDTOImp.builder().id(ID).autor(AUTOR).titulo(TITULO).fechaPublicacion(FECHA_PUBLICACION).isbn(ISBN).build();
	
		LibroDTO libroCloned = libro.deepClone();
		
		libroCloned.setAutor("AUTOR2");
		
		assertEquals(AUTOR,libro.getAutor());
		
		assertEquals("AUTOR2",libroCloned.getAutor());
	}
}
