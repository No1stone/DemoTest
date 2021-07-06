package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TestModelMem {
	
	private String email;
	private String pass;
	
	
	public TestModelMem() {}
			
	public TestModelMem(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
