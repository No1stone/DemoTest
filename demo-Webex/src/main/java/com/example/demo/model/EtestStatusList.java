package com.example.demo.model;

public class EtestStatusList {
	private String userId;
	private String userName;   
	private String startDate;
	private String endDate;
	private String sessionCount;
	private String testTime;
	private String testStatus;
	private String finalScore;
	private String retestYn;
	public EtestStatusList(String userId, String userName, String startDate, String endDate, String sessionCount,
			String testTime, String testStatus, String finalScore, String retestYn) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sessionCount = sessionCount;
		this.testTime = testTime;
		this.testStatus = testStatus;
		this.finalScore = finalScore;
		this.retestYn = retestYn;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSessionCount() {
		return sessionCount;
	}
	public void setSessionCount(String sessionCount) {
		this.sessionCount = sessionCount;
	}
	public String getTestTime() {
		return testTime;
	}
	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	public String getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}
	public String getRetestYn() {
		return retestYn;
	}
	public void setRetestYn(String retestYn) {
		this.retestYn = retestYn;
	}
	@Override
	public String toString() {
		return "EtestStatusList [userId=" + userId + ", userName=" + userName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", sessionCount=" + sessionCount + ", testTime=" + testTime + ", testStatus="
				+ testStatus + ", finalScore=" + finalScore + ", retestYn=" + retestYn + "]";
	}

	
}
