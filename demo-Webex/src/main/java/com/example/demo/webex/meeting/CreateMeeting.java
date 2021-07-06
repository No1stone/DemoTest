package com.example.demo.webex.meeting;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.example.demo.common.util.DateUtils;
import com.example.demo.webex.common.RequestCommon;



public class CreateMeeting extends RequestCommon {
	
	/**
	   1: Free meeting
	 2: Standard meeting
	 3: Pro meeting
	 4: Standard subscription office meeting
	 5: Pro subscription office meeting
	 6: Pay-per-use meeting
	 7: Support Center support session
	 8: OnTour session
	 9: Event Center event session
	 10: Access Anywhere meeting
	 11: Training session
	 101: Support Center Application share and File transfer only
	*/
	private int meetingType = 3; 
	private String meetingSubject;
	private String pw;	//미팅 패스워드
	private int maxUserNumber;
	private String startDate;	//MM/dd/yyyy HH:mm:ss
	private int duration;	//단위 분
	private int timeZoneID = 50;	//타임존 기본 한국시간
	private int remindDaysAhead = 1;
	private int remindHoursAhead = 2;
	
	public CreateMeeting(String siteName, String webExID, String passWord) {
		super(siteName, webExID, passWord, "java:com.webex.service.binding.meeting.CreateMeeting");
	}

	public int getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(int meetingType) {
		this.meetingType = meetingType;
	}
	
	public String getMeetingSubject() throws UnsupportedEncodingException {
		return this.meetingSubject;
	}

	public void setMeetingSubject(String meetingSubject) {
		this.meetingSubject = meetingSubject;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getMaxUserNumber() {
		return maxUserNumber;
	}

	public void setMaxUserNumber(int maxUserNumber) {
		this.maxUserNumber = maxUserNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = DateUtils.dateToString(startDate, "MM/dd/yyyy HH:mm:ss");
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTimeZoneID() {
		return timeZoneID;
	}

	public void setTimeZoneID(int timeZoneID) {
		this.timeZoneID = timeZoneID;
	}
	
	public int getRemindDaysAhead() {
		return remindDaysAhead;
	}

	public void setRemindDaysAhead(int remindDaysAhead) {
		this.remindDaysAhead = remindDaysAhead;
	}

	public int getRemindHoursAhead() {
		return remindHoursAhead;
	}

	public void setRemindHoursAhead(int remindHoursAhead) {
		this.remindHoursAhead = remindHoursAhead;
	}

	@Override
	public String getRequestXML() {
		
		this.bodyContent.append("<accessControl>\n");
		this.bodyContent.append("<listToPublic>FALSE</listToPublic>\n");
		this.bodyContent.append("<isPublic>FALSE</isPublic>\n");
		this.bodyContent.append("<meetingPassword>" + this.getPw() + "</meetingPassword>\n");
		//this.bodyContent.append("<enforcePassword>FALSE</enforcePassword>\n");
		this.bodyContent.append("</accessControl>\n");
				
		this.bodyContent.append("<metaData>\n");
		this.bodyContent.append("<confName>" + this.meetingSubject + "</confName>\n");
		this.bodyContent.append("<meetingType>" + this.meetingType + "</meetingType>\n");
		this.bodyContent.append("</metaData>\n");
		
		this.bodyContent.append("<participants>\n");
		this.bodyContent.append("<maxUserNumber>" + this.maxUserNumber + "</maxUserNumber>\n");        
		this.bodyContent.append("</participants>\n");
		
		this.bodyContent.append("<enableOptions>\n");
		this.bodyContent.append("<chat>TRUE</chat>\n");
		this.bodyContent.append("<poll>TRUE</poll>\n");
		this.bodyContent.append("<audioVideo>TRUE</audioVideo>\n");
		this.bodyContent.append("<supportE2E>FALSE</supportE2E>\n"); //End To End Encryption 옵션으로 TRUE로 하면 자동레코딩이 안됨.
		this.bodyContent.append("<autoRecord>TRUE</autoRecord>\n");
		this.bodyContent.append("<attendeeList>TRUE</attendeeList>\n");
		this.bodyContent.append("<fileShare>TRUE</fileShare>\n");
		this.bodyContent.append("<presentation>TRUE</presentation>\n");
		this.bodyContent.append("<applicationShare>TRUE</applicationShare>\n");
		this.bodyContent.append("<desktopShare>TRUE</desktopShare>\n");
		this.bodyContent.append("<pointer>TRUE</pointer>\n");
		this.bodyContent.append("<HQvideo>TRUE</HQvideo>\n");
		this.bodyContent.append("<HDvideo>TRUE</HDvideo>\n");
		this.bodyContent.append("</enableOptions>\n");
		
		this.bodyContent.append("<schedule>\n");
		this.bodyContent.append("<startDate>" + this.getStartDate() + "</startDate>\n");
		this.bodyContent.append("<duration>" + this.duration + "</duration>\n");
		this.bodyContent.append("<timeZoneID>" + this.timeZoneID + "</timeZoneID>\n");
		this.bodyContent.append("<joinTeleconfBeforeHost>FALSE</joinTeleconfBeforeHost>\n");	//호스트가 열지 않아도 방에 입장할 수 있는 옵션으로 추정됨
		this.bodyContent.append("</schedule>\n");
		
		this.bodyContent.append("<remind>\n");
		this.bodyContent.append("<enableReminder>TRUE</enableReminder>\n");
		this.bodyContent.append("<sendEmail>TRUE</sendEmail>\n");
		this.bodyContent.append("<daysAhead>" + this.remindDaysAhead + "</daysAhead>\n");
		this.bodyContent.append("<hoursAhead>" + this.remindHoursAhead + "</hoursAhead>\n");
		this.bodyContent.append("</remind>\n");
		
		this.bodyContent.append("<attendeeOptions>\n");
		this.bodyContent.append("<request>FALSE</request>");
		this.bodyContent.append("<registration>TRUE</registration>");
		this.bodyContent.append("<auto>FALSE</auto>");
		this.bodyContent.append("<emailInvitations>TRUE</emailInvitations>");
		this.bodyContent.append("<joinRequiresAccount>TRUE</joinRequiresAccount>");
		this.bodyContent.append("</attendeeOptions>\n");
		
		this.xml = new StringBuffer();
		
		this.xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		this.xml.append("<serv:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:serv=\"http://www.webex.com/schemas/2002/06/service\">\n");
		this.xml.append("\t<header>\n");
		this.xml.append("\t\t<securityContext>\n");
		this.xml.append("\t\t\t<siteName>");
		this.xml.append(this.getSiteName());
		this.xml.append("</siteName>\n");
		this.xml.append("\t\t\t<webExID>");
		this.xml.append(this.getWebExID());
		this.xml.append("</webExID>\n");
		this.xml.append("\t\t\t<password>");
		this.xml.append(this.getPassWord());
		this.xml.append("</password>\n");
		this.xml.append("\t\t\t<partnerID></partnerID>\n");
		this.xml.append("\t\t</securityContext>\n");
		this.xml.append("\t</header>\n");
		this.xml.append("\t<body>\n");
		this.xml.append("\t\t<bodyContent xsi:type=\"");
		this.xml.append(this.getXsiType());
		this.xml.append("\">\n");
		
		this.xml.append(this.bodyContent);
		
		this.xml.append("\t\t</bodyContent>\n");
		this.xml.append("\t</body>\n");
		this.xml.append("</serv:message>");
		
		return this.xml.toString();
		
	}

}
