package com.indra.ar.api.books.apibooks.domain;


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationUser implements Serializable{


	private static final long serialVersionUID = 3067453669572191250L;
	
	public ApplicationUser(long id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	private long id;
	private String username;
	private String password;
	private String role;
}