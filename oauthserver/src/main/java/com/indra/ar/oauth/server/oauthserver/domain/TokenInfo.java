package com.indra.ar.oauth.server.oauthserver.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TokenInfo implements Serializable {

	private static final long serialVersionUID = 7674108100150928078L;


	public TokenInfo(String name, String userName, String role) {
		super();
		this.name = name;
		this.userName = userName;
		this.role = role;
	}

	private String name;
	
	private String userName;

	private String role;

}
