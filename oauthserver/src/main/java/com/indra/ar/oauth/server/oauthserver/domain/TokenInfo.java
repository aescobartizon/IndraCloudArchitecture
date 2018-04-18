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

	public TokenInfo(String userName, String role) {
		super();
		this.userName = userName;
		this.role = role;
	}

	@Override
	public String toString() {
		return "TokenInfo [userName=" + userName + ", role=" + role + "]";
	}

	private String userName;

	private String role;

}
