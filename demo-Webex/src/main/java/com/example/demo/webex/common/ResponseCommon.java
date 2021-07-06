package com.example.demo.webex.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ResponseCommon {
	
	private String performance;
	private String result;
	private String reason;
	private String gsbStatus;
	private String exceptionID;
	private String subErrors;
	private String value;
	private NodeList body;
	
	public ResponseCommon(String responseXml) throws Exception {
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			InputStream is = new ByteArrayInputStream(responseXml.getBytes());
			Document doc = documentBuilder.parse(is);
			Element element = doc.getDocumentElement();
			
			NodeList items = element.getElementsByTagName("serv:result");
			if (items != null && items.item(0) != null) {
				this.result = items.item(0).getTextContent().trim();
			}
			
			items = element.getElementsByTagName("serv:performance");
			if (items != null && items.item(0) != null) {
				this.performance = items.item(0).getTextContent().trim();
			}
			
			items = element.getElementsByTagName("serv:gsbStatus");
			if (items != null && items.item(0) != null) {
				this.gsbStatus = items.item(0).getTextContent().trim();
			}
			
			if (this.result != null && this.result.equals("SUCCESS")) {
				items = element.getElementsByTagName("serv:bodyContent");
				if (items != null) {
					this.body = items;
				}
			} else {
				items = element.getElementsByTagName("serv:reason");
				if (items != null && items.item(0) != null) {
					this.reason = items.item(0).getTextContent().trim();
				}
				
				items = element.getElementsByTagName("serv:exceptionID");
				if (items != null && items.item(0) != null) {
					this.exceptionID = items.item(0).getTextContent().trim();
				}
				
				items = element.getElementsByTagName("serv:subErrors");
				if (items != null && items.item(0) != null) {
					this.subErrors = items.item(0).getTextContent().trim();
				}
				
				items = element.getElementsByTagName("serv:value");
				if (items != null && items.item(0) != null) {
					this.value = items.item(0).getTextContent().trim();
				}
			}
			
		} catch (ParserConfigurationException | SAXException | IOException | NullPointerException e) {
			throw new Exception("Response XML Parsing Error");
		}
		
		
	}
	
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getGsbStatus() {
		return gsbStatus;
	}
	public void setGsbStatus(String gsbStatus) {
		this.gsbStatus = gsbStatus;
	}
	
	public String getExceptionID() {
		return exceptionID;
	}
	public void setExceptionID(String exceptionID) {
		this.exceptionID = exceptionID;
	}
	
	public String getSubErrors() {
		return subErrors;
	}
	public void setSubErrors(String subErrors) {
		this.subErrors = subErrors;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public NodeList getBody() {
		return body;
	}
	public void setBody(NodeList body) {
		this.body = body;
	}	

}
