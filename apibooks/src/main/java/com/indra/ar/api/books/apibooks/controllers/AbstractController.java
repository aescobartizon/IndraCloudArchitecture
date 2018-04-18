package com.indra.ar.api.books.apibooks.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;

import com.indra.ar.api.books.apibooks.domain.ApplicationUser;

import lombok.Getter;
import lombok.Setter;

public class AbstractController {

	@Autowired
	@Getter
	@Setter
	private Environment enviroment;
	
	@Autowired
	@Getter
	@Setter
	private MessageSource messageSource;
	
	@Getter
	private static Logger log = LoggerFactory.getLogger(AbstractController.class);
	
	
	public ApplicationUser getApplicationUserLogged() {
		return ((ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).deepClone();
	}
}
