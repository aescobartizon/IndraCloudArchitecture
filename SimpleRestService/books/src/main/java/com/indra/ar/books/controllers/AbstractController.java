package com.indra.ar.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.Getter;
import lombok.Setter;

public class AbstractController {
	
	@Autowired
	@Getter
	@Setter
	private Environment enviroment;
}
