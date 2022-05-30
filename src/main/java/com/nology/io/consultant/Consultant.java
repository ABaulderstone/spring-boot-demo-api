package com.nology.io.consultant;

public class Consultant {
	static Integer counter = 0;
	private Integer id;
	private String name;
	private double salary; 
	private String location; 
	
	Consultant(String name, String location) {
		this.id = ++counter;
		this.name = name;
		this.location = location; 
		this.salary = 50000.00;
	}
	
	public double increaseSalary() { 
		this.salary += 5000.00;
		return this.salary;
	}
	
    public double increaseSalary(double amount) {
    	this.salary += amount;
    	return this.salary;
    }
    
    public double getSalary() {
    	return this.salary;
    }
    
    public String getLocation() {
    	return this.location;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public Integer getId() { 
    	return this.id;
    }
    

}