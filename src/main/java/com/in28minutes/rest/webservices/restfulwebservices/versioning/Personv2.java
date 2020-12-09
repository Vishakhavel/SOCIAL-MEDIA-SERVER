package com.in28minutes.rest.webservices.restfulwebservices.versioning;



/* ONE NAME AT A TIME (ALL SEPERATE)*/

public class Personv2 {
	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Personv2(Name name) {
		super();
		this.name = name;
	}


}
