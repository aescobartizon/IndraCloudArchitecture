package com.indra.ar.api.books.apibooks.exceptions;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = -8482739001310523692L;

	public NotFoundException(String message) {
		super(message);
	}
}
