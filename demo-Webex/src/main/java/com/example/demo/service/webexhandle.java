package com.example.demo.service;

import javax.json.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.ciscospark.Attachment;
import com.example.demo.ciscospark.Message;
import com.example.demo.ciscospark.Spark;
import com.example.demo.model.WebexMessageModelData;

@Component
public class webexhandle {
	  @Autowired
	  private Spark chatbotSpark;
	
	
	public String messageGet(WebexMessageModelData data) {
		String messageid = data.getId();
		
		System.out.println("messageid: "+messageid);
		
		
		Message message = chatbotSpark.messages().path("/".concat(messageid)).get();
		
		message.setId(data.getId());
		
		return message.getText();
	}
	
	public void sendMessage(String id, String sendmessage) {
		
		Message message = new Message();
		
		message.setToPersonId(id);
		message.setText(sendmessage);
		chatbotSpark.messages().post(message);
	}
	
	public void attechmentMessage(String id, String sendmessage) {
		
		 Attachment attachment = chatbotSpark.attachment().path("/".concat(id)).get();
		
	}
//	
//    public void sendCardMessage(String title, Message message) {
//
//        JsonObject titleBlock = WebexCardBuilder.buildTextBlock(title);
//        JsonObject textBlock = WebexCardBuilder.buildTextBlock(message.getText());
//
//        JsonArray bodys = Json.createArrayBuilder().add(titleBlock).add(textBlock).build();
//        JsonArray attachmentsArry = WebexCardBuilder.buildAdaptiveCard(bodys);
//        message.setAttachments(attachmentsArry);
//
//        chatbotSpark.messages().post(message);;
//    }

}
