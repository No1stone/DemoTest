package com.example.demo.model;

public class ForumRegList {
	private String userId;
	private String userName;
	private String teamInfoId;
	private String teamName;
	private String regCnt;
	public ForumRegList(String userId, String userName, String teamInfoId, String teamName, String regCnt) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.teamInfoId = teamInfoId;
		this.teamName = teamName;
		this.regCnt = regCnt;
	}
	public ForumRegList() {
		// TODO Auto-generated constructor stub
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
	public String getTeamInfoId() {
		return teamInfoId;
	}
	public void setTeamInfoId(String teamInfoId) {
		this.teamInfoId = teamInfoId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getRegCnt() {
		return regCnt;
	}
	public void setRegCnt(String regCnt) {
		this.regCnt = regCnt;
	}
	@Override
	public String toString() {
		return "forumRegList [userId=" + userId + ", userName=" + userName + ", teamInfoId=" + teamInfoId
				+ ", teamName=" + teamName + ", regCnt=" + regCnt + "]";
	}

	
}
