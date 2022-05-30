package com.nology.io.consultant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/consultants")
public class ConsultantsController {
	
	
	public ArrayList<Consultant> consultants = new ArrayList<>(Arrays.asList(
			new Consultant("Alice", "Adelaide"),
			new Consultant("Bob", "Brisbane"),
			new Consultant("Charlie", "Canberra")
			));
	
	
	@GetMapping
	public ResponseEntity<ArrayList<Consultant>> all(){ 
		return new ResponseEntity<>(this.consultants, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Consultant> findById(@PathVariable Integer id) { 
		Optional<Consultant> consultant = consultants.stream()
				.filter(x -> x.getId() == id)
				.findFirst();
		if(consultant.isEmpty()) { 
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Consultant>(consultant.get(), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Consultant> create(@Valid @RequestBody ConsultantCreateDTO data) { 
		Consultant newConsultant = new Consultant(data.getName(), data.getLocation());
		this.consultants.add(newConsultant);
		return new ResponseEntity<>(newConsultant, HttpStatus.CREATED);
	}
	
	

}