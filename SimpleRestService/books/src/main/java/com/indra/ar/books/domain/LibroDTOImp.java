package com.indra.ar.books.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LibroDTOImp extends AbstractDTO implements LibroDTO {

	private static final long serialVersionUID = 1143490730364007930L;
	
	private Long id;

	private String titulo;

	private String autor;

	private Long fechaPublicacion;

	private String isbn;

}
