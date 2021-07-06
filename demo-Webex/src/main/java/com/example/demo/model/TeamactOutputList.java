package com.example.demo.model;

public class TeamactOutputList {

	private String userId;
	private String userName;
	private String teamCategoryId;
	private String teamCategoryName;
	private String teamInfoId;
	private String teamName;
	private String memberType;
	private String title;
	private String outputContents;
	private String regDate;
	private String outputNum;
	private String teamactScore;
	public TeamactOutputList(String userId, String userName, String teamCategoryId, String teamCategoryName,
			String teamInfoId, String teamName, String memberType, String title, String outputContents, String regDate,
			String outputNum, String teamactScore) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.teamCategoryId = teamCategoryId;
		this.teamCategoryName = teamCategoryName;
		this.teamInfoId = teamInfoId;
		this.teamName = teamName;
		this.memberType = memberType;
		this.title = title;
		this.outputContents = outputContents;
		this.regDate = regDate;
		this.outputNum = outputNum;
		this.teamactScore = teamactScore;
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
	public String getTeamCategoryId() {
		return teamCategoryId;
	}
	public void setTeamCategoryId(String teamCategoryId) {
		this.teamCategoryId = teamCategoryId;
	}
	public String getTeamCategoryName() {
		return teamCategoryName;
	}
	public void setTeamCategoryName(String teamCategoryName) {
		this.teamCategoryName = teamCategoryName;
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
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOutputContents() {
		return outputContents;
	}
	public void setOutputContents(String outputContents) {
		this.outputContents = outputContents;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getOutputNum() {
		return outputNum;
	}
	public void setOutputNum(String outputNum) {
		this.outputNum = outputNum;
	}
	public String getTeamactScore() {
		return teamactScore;
	}
	public void setTeamactScore(String teamactScore) {
		this.teamactScore = teamactScore;
	}
	@Override
	public String toString() {
		return "TeamactOutputList [userId=" + userId + ", userName=" + userName + ", teamCategoryId=" + teamCategoryId
				+ ", teamCategoryName=" + teamCategoryName + ", teamInfoId=" + teamInfoId + ", teamName=" + teamName
				+ ", memberType=" + memberType + ", title=" + title + ", outputContents=" + outputContents
				+ ", regDate=" + regDate + ", outputNum=" + outputNum + ", teamactScore=" + teamactScore + "]";
	}

	
	
}
