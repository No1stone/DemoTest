package com.example.demo.webex.meeting;

import org.w3c.dom.NodeList;

import com.example.demo.webex.common.ResponseCommon;


public class CreateMeetingAttendeeResponse extends ResponseCommon {
	
	private String attendeeId;

	public CreateMeetingAttendeeResponse(String responseXml) throws Exception {
		
		super(responseXml);
		
		NodeList body = this.getBody();
		
		if (body != null && body.getLength() > 0) {
			
			NodeList child = body.item(0).getChildNodes();
			
			if (child != null) {
				for (int i = 0; i < child.getLength(); i++) {
					if (child.item(i) != null) {
						if (child.item(i).getNodeName().equals("att:attendeeId")) {
							this.attendeeId = child.item(i).getTextContent().trim();
						}
					}
				}
			}
		}
		
	}

	public String getAttendeeId() {
		return attendeeId;
	}
}
