package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
	
	@GetMapping("/personv1")
	public Personv1 getperson1()
	{
		return new Personv1("Shanmugavel Shanmuganathan Vishakhavel");
	}
	
	@GetMapping("/personv2")
	public Personv2 getperson2()
	{
		return new Personv2(new Name("Shanmugavel","Shanmuganathan","Vishakhavel"));
	}
	

}
