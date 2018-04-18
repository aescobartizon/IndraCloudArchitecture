package com.indra.ar.api.books.apibooks.conf;

public class SecurityUtils {

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String CLAIM_KEY = "claim_key";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users/sign-up";
	
	
	public enum TOKEN_INFO {

		NAME("name"),USER_NAME("userName"),ROLE("role");

		private String field;

		TOKEN_INFO(String field) {
			this.field = field;
		}

		public String getField() {
			return field;
		}
	} 

	private SecurityUtils() {
		throw new IllegalStateException("Utility class");
	}
}
