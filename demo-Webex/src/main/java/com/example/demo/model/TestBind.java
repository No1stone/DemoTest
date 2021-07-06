package com.example.demo.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

//@Repository
@Alias("testbind")
@Repository
public class TestBind {

	
	private String email;
	private String pass;
	private boolean isYes;
	
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
