package com.example.demo.webex.meeting;

import org.w3c.dom.NodeList;

import com.example.demo.webex.common.ResponseCommon;


public class CreateMeetingResponse extends ResponseCommon {
	
	private String sessionKey;	

	public CreateMeetingResponse(String responseXml) throws Exception {
		super(responseXml);
		
		NodeList body = this.getBody();
		
		if (body != null && body.getLength() > 0) {
			
			NodeList child = body.item(0).getChildNodes();
			
			if (child != null) {
				for (int i = 0; i < child.getLength(); i++) {
					if (child.item(i) != null) {
						if (child.item(i).getNodeName().equals("meet:meetingkey") || child.item(i).getNodeName().equals("meet:sessionkey")) {
							this.sessionKey = child.item(i).getTextContent().trim();
						}
					}
				}
			}
		}
	}

	public String getSessionKey() {
		return sessionKey;
	}

}
