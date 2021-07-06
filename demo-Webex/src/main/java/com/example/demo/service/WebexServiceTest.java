package com.example.demo.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ciscospark.Message;
import com.example.demo.ciscospark.Spark;
import com.example.demo.ciscospark.Spark.Builder;
import com.example.demo.model.WebexMessageModelData;


@Service
public class WebexServiceTest {

	@Autowired
	webexhandle webexHandle;
	
	
	public void MessageSelect(WebexMessageModelData webmsgdata) {
		
		String botmail = "wsassigntest@webex.bot";
		String checkmail = (String)webmsgdata.getPersonEmail();
		
		if(botmail.equals(checkmail)) {return;} 	
		System.out.println("CheckMail:  "+checkmail);

	System.out.println(" ");
	System.out.println("==============================================");
	System.out.println("WebexServiceTest Data");

	
	System.out.println("getCreated: "+webmsgdata.getCreated());
	System.out.println("getId: "+webmsgdata.getId());
	System.out.println("getPersonEmail: "+webmsgdata.getPersonEmail());
	System.out.println("getPersonId: "+webmsgdata.getPersonId());
	System.out.println("getRoomId: "+webmsgdata.getRoomId());
	System.out.println("getRoomType: "+webmsgdata.getRoomType());
	System.out.println("toString: "+webmsgdata.toString());
	
	System.out.println("==============================================");
	System.out.println("WebexServiceTest END");
	System.out.println(" ");

	String message = webexHandle.messageGet(webmsgdata);
	
	System.out.println(message);
	
	String testsend = "testsendmessage";
	webexHandle.sendMessage(webmsgdata.getPersonId(), testsend);
	
	webexHandle.attechmentMessage(webmsgdata.getPersonId(), testsend);
	
}}
