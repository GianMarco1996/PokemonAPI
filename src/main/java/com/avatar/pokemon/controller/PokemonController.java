package com.avatar.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.avatar.pokemon.model.Pokemon;

@Controller
public class PokemonController {

	@Autowired
	RestTemplate pokemonRest;
	
	@GetMapping("/pokemones")
	public String pokemones(Model model) {
		Pokemon data = pokemonRest.getForObject("https://pokeapi.co/api/v2/pokemon-species", Pokemon.class);
		
		model.addAttribute("titulo", "APP::POKEMON");
		model.addAttribute("count", data.getCount());
		model.addAttribute("next", data.getNext().toString());
		model.addAttribute("data", data.getResults());
		
		return "pokemon";
	}
}
