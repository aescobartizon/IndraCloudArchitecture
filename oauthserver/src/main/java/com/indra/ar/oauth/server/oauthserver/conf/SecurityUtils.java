package com.indra.ar.oauth.server.oauthserver.conf;

import java.util.Date;

import com.indra.ar.oauth.server.oauthserver.domain.TokenInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class SecurityUtils {

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users/sign-up";

	private SecurityUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static String generateToken(TokenInfo tokenInfo) {
		return Jwts.builder().claim("name",tokenInfo.getUserName()).claim("scope",tokenInfo.getRole()).setSubject(tokenInfo.getUserName()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
	}
}
