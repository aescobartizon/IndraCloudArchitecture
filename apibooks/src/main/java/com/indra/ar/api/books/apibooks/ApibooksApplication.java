package com.indra.ar.api.books.apibooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApibooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApibooksApplication.class, args);
	}
}