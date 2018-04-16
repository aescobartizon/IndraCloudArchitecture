package com.indra.ar.api.books.apibooks.domain;

public interface GenericDTO {

	<T> T deepClone();
}
