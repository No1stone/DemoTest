package com.example.demo.webex.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCommon {
	
	private static final Logger log = LoggerFactory.getLogger(RequestCommon.class);
	
	private String siteName = "";
	private String webExID = "";
	private String passWord = "";
	private String xsiType = "";	//<bodyContent xsi:type="java:com.webex.service.binding.user.CreateUser">
	protected StringBuffer bodyContent = new StringBuffer();
	protected StringBuffer xml;
		
	public RequestCommon(String siteName, String webExID, String passWord, String xsiType) {
		super();
		this.siteName = siteName;
		this.webExID = webExID;
		this.passWord = passWord;
		this.xsiType = xsiType;
	}

	public String getSiteName() {
		return siteName;
	}
	
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public String getWebExID() {
		return webExID;
	}
	
	public void setWebExID(String webExID) {
		this.webExID = webExID;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getXsiType() {
		return xsiType;
	}
	
	public void setXsiType(String xsiType) {
		this.xsiType = xsiType;
	}
	
	public void setBodyContent(StringBuffer bodyContent) {
		this.bodyContent = bodyContent;
	}

	public String getRequestXML() {
		
		this.xml = new StringBuffer();
		
		this.xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		this.xml.append("<serv:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:serv=\"http://www.webex.com/schemas/2002/06/service\">\n");
		this.xml.append("\t<header>\n");
		this.xml.append("\t\t<securityContext>\n");
		this.xml.append("\t\t\t<siteName>");
		this.xml.append(this.siteName);
		this.xml.append("</siteName>\n");
		this.xml.append("\t\t\t<webExID>");
		this.xml.append(this.webExID);
		this.xml.append("</webExID>\n");
		this.xml.append("\t\t\t<password>");
		this.xml.append(this.passWord);
		this.xml.append("</password>\n");
		this.xml.append("\t\t\t<partnerID></partnerID>\n");
		this.xml.append("\t\t</securityContext>\n");
		this.xml.append("\t</header>\n");
		this.xml.append("\t<body>\n");
		this.xml.append("\t\t<bodyContent xsi:type=\"");
		this.xml.append(this.xsiType);
		this.xml.append("\">\n");
		
		if (this.bodyContent != null && this.bodyContent.length() > 0) {
			this.xml.append(this.bodyContent);
		}
		
		this.xml.append("\t\t</bodyContent>\n");
		this.xml.append("\t</body>\n");
		this.xml.append("</serv:message>");
		
		return this.xml.toString();
		
	}
	
}
