package com.indra.ar.oauth.server.oauthserver.services;


import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.indra.ar.oauth.server.oauthserver.domain.ApplicationUser;
import com.indra.ar.oauth.server.oauthserver.repositories.ApplicationUserRepository;

import lombok.Getter;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Getter
	private ApplicationUserRepository applicationUserRepository;

	public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
		this.applicationUserRepository = applicationUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ApplicationUser applicationUser = getApplicationUserRepository().findByUsername(username);

		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
	}
}
