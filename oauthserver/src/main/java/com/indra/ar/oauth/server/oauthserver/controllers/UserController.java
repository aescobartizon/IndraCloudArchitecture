package com.indra.ar.oauth.server.oauthserver.controllers;

import static com.indra.ar.oauth.server.oauthserver.conf.SecurityUtils.HEADER_STRING;
import static com.indra.ar.oauth.server.oauthserver.conf.SecurityUtils.TOKEN_PREFIX;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.ar.oauth.server.oauthserver.conf.SecurityUtils;
import com.indra.ar.oauth.server.oauthserver.domain.ApplicationUser;
import com.indra.ar.oauth.server.oauthserver.domain.TokenInfo;
import com.indra.ar.oauth.server.oauthserver.repositories.ApplicationUserRepository;

import lombok.Getter;

@RestController
@RequestMapping("/users")
public class UserController {

	@Getter
	private ApplicationUserRepository applicationUserRepository;

	@Getter
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserController(ApplicationUserRepository applicationUserRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {

		this.applicationUserRepository = applicationUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody ApplicationUser user, HttpServletResponse res) {

		user.setPassword(getBCryptPasswordEncoder().encode(user.getPassword()));
		getApplicationUserRepository().save(user);
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + SecurityUtils.generateToken(TokenInfo.builder().userName(user.getUsername()).role(user.getRole()).build()));
	}
}