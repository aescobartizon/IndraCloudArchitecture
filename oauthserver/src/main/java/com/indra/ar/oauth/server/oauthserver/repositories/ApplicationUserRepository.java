package com.indra.ar.oauth.server.oauthserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.indra.ar.oauth.server.oauthserver.domain.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{

	
	@Query(value = "SELECT * FROM ApplicationUser U WHERE U.username = ?1", nativeQuery = true)
	ApplicationUser findByUsername(String name);
}
