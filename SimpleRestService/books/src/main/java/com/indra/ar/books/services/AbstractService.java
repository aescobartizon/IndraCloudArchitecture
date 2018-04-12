package com.indra.ar.books.services;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

public class AbstractService {

	@Autowired
	@Getter
	private TransformDtoToEntity transformDtoToEntity;
	
}
