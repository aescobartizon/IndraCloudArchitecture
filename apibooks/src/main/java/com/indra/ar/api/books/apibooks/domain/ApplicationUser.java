package com.indra.ar.api.books.apibooks.domain;


import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApplicationUser extends AbstractDTO implements Serializable{

	private static final long serialVersionUID = -6457444490350948571L;
	private String username;
	private String name;
	private String role;
}