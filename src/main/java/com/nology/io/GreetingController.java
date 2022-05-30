package com.nology.io;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting")

public class GreetingController {
	
	@GetMapping
	public String greeting() { 
		return "Hello, world";
		
	}
	
	@GetMapping(value = "/{name}")
	public String namedGreeting(@PathVariable String name) { 
		return String.format("Hello, %s", name);
		
	}

}
