package com.example.demo.webex.meeting;

import com.example.demo.webex.common.RequestCommon;

public class CreateMeetingAttendee extends RequestCommon {
	
	public CreateMeetingAttendee(String siteName, String webExID, String passWord, String name, String id, String sessionKey) {
		super(siteName, webExID, passWord, "java:com.webex.service.binding.attendee.CreateMeetingAttendee");
		
		this.bodyContent.append("<person>\n");
		this.bodyContent.append("<name>" + name + "</name>\n");
		this.bodyContent.append("<email>" + id + "</email>\n");
		this.bodyContent.append("<type>MEMBER</type>\n");
		this.bodyContent.append("</person>\n");
		
		this.bodyContent.append("<sessionKey>" + sessionKey + "</sessionKey>\n");
	}
	
}
