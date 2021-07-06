package com.example.demo.model;

public class ResearchAnswerList {
	private String userId;
	private String userName;
	private String regDate;
	public ResearchAnswerList(String userId, String userName, String regDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ResearchAnswerList [userId=" + userId + ", userName=" + userName + ", regDate=" + regDate + "]";
	}
	

	
	
}
