package com.example.demo.common;

public class Constants {
	
	private static String webExXmlSvcUrl = "https://%s.Webex.com/WBXService/XMLService";
	
	public static String WX_SVC_URL(String siteName) {
		return String.format(Constants.webExXmlSvcUrl, siteName);
	}

}
