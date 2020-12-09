package com.in28minutes.rest.webservices.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	
	private Integer id;

		@ManyToOne(fetch=FetchType.LAZY)
		@JsonIgnore
	private User user;
	
	private String selfie;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getSelfie() {
		return selfie;
	}

	public void setSelfie(String selfie) {
		this.selfie = selfie;
	}
	//get you can'y get for user , will result  in infinte looop
	//set you can use
	public void setUser(User user) {
		this.user=user;
	}

}
