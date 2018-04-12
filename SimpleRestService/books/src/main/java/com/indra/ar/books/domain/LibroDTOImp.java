package com.indra.ar.books.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LibroDTOImp extends AbstractDTO implements LibroDTO {

	private static final long serialVersionUID = 1143490730364007930L;
	
	public LibroDTOImp(Long id, String titulo, String autor, Long fechaPublicacion, String isbn) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.isbn = isbn;
	}
	
	
	@ApiModelProperty(notes = "internal Book id", required =true)
	private Long id;

	
	@ApiModelProperty(notes = "titulo Book ", required =true)
	private String titulo;

	
	@ApiModelProperty(notes = "author Book ", required =true)
	private String autor;

	
	@ApiModelProperty(notes = "fecha Publicacion id", required =true)
	private Long fechaPublicacion;

	
	@ApiModelProperty(notes = "ISBN Book ", required =false)
	private String isbn;

}
