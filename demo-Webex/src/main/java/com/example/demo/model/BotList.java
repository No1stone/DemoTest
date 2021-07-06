package com.example.demo.model;

public class BotList {

	private int siteCD;
	private String botID;
	private String botAccToken;
	private String botEmail;
	private String siteName;
	
	public BotList() {}

	public BotList(int siteCD, String botID, String botAccToken, String botEmail, String siteName) {
		super();
		this.siteCD = siteCD;
		this.botID = botID;
		this.botAccToken = botAccToken;
		this.botEmail = botEmail;
		this.siteName = siteName;
	}

	public int getSiteCD() {
		return siteCD;
	}

	public void setSiteCD(int siteCD) {
		this.siteCD = siteCD;
	}

	public String getBotID() {
		return botID;
	}

	public void setBotID(String botID) {
		this.botID = botID;
	}

	public String getBotAccToken() {
		return botAccToken;
	}

	public void setBotAccToken(String botAccToken) {
		this.botAccToken = botAccToken;
	}

	public String getBotEmail() {
		return botEmail;
	}

	public void setBotEmail(String botEmail) {
		this.botEmail = botEmail;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Override
	public String toString() {
		return "BotList [siteCD=" + siteCD + ", botID=" + botID + ", botAccToken=" + botAccToken + ", botEmail="
				+ botEmail + ", siteName=" + siteName + "]";
	}
	
	
	
}
