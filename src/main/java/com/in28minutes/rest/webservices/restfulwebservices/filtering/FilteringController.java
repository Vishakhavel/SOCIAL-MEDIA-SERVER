package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	
	@GetMapping("/filtering")
	public someBean retrieveSOmeBean()
	{
		return new someBean("vichu", "vishakhavel", "Slash");
	}
	
	@GetMapping("/filteringListExample")
	public List<someBean> retrieveSOmeBeans()
	{
		return  Arrays.asList(new someBean("vichu", "vishakhavel", "Slash") 
				, new someBean("Murr","Murali","Mort")) ;
		
	}
	
	

}
