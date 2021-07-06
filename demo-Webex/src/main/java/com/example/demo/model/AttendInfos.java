package com.example.demo.model;

public class AttendInfos {
	private String userId;
	private String userName;     
	private String studyRatio;
	public AttendInfos(String userId, String userName, String studyRatio) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.studyRatio = studyRatio;
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
	public String getStudyRatio() {
		return studyRatio;
	}
	public void setStudyRatio(String studyRatio) {
		this.studyRatio = studyRatio;
	}
	@Override
	public String toString() {
		return "attendInfos [userId=" + userId + ", userName=" + userName + ", studyRatio=" + studyRatio + "]";
	}

	
}
