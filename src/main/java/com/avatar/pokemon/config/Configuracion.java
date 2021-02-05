package com.avatar.pokemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configuracion {

	@Bean("pokemonRest")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
