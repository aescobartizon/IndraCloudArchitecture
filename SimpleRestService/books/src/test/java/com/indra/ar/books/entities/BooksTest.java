package com.indra.ar.books.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BooksTest {
	
	private static final Long ID = 1L;
	
	private static final String TITULO = "Titulo 1";
	
	private static final String AUTOR = "Autor 1 ";
	
	private static final Long FECHA_PUBLICACION = new Date().getTime();
	
	private static final String ISBN = "isbn";

	@Test
	public void build() {
		
		Books bookEntity = Books.builder().build();
		
		assertNotNull(bookEntity);
	}
	
	@Test
	public void initAttributes() {
		
		Books bookEntity = Books.builder().autor(AUTOR).titulo(TITULO).fechaPublicacion(FECHA_PUBLICACION).isbn(ISBN).id(ID).build();
		
		
		assertEquals(bookEntity.getAutor(), AUTOR);
		
		assertEquals(bookEntity.getTitulo(), TITULO);
		
		assertEquals(bookEntity.getFechaPublicacion(), FECHA_PUBLICACION);
	
		assertEquals(bookEntity.getId(),ID);
		
		assertEquals(bookEntity.getIsbn(), ISBN);
		
	}
}
