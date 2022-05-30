package com.nology.io.consultant;

import javax.validation.constraints.NotBlank;

public class ConsultantCreateDTO {
	@NotBlank
	private String name;
	@NotBlank
	private String location;
	
	public ConsultantCreateDTO(String name, String location) { 
		this.name = name;
		this.location = location;
	} 
	
	
	public String getName() { 
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	

}

