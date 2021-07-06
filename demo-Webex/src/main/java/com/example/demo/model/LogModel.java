package com.example.demo.model;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class LogModel {

	int siteCd;
	String personId;
	String personEmail;
	String msg;
	String msgDate;
	public int getSiteCd() {
		return siteCd;
	}
	public void setSiteCd(int siteCd) {
		this.siteCd = siteCd;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}
	
	
	
}
