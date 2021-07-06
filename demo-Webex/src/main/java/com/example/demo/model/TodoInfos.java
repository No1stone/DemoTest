package com.example.demo.model;

public class TodoInfos {

	private String courseId;
	private String courseName;
	private String coursePartCode;
	private String userId;
	private String infoId;
	private String titleName;
	private String title;
	private String endDate;
	private String titleNamea;
	private String studentDate;
	private String submitIdCnt;
	private String userType;
	public TodoInfos(String courseId, String courseName, String coursePartCode, String userId, String infoId,
			String titleName, String title, String endDate, String titleNamea, String studentDate, String submitIdCnt,
			String userType) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePartCode = coursePartCode;
		this.userId = userId;
		this.infoId = infoId;
		this.titleName = titleName;
		this.title = title;
		this.endDate = endDate;
		this.titleNamea = titleNamea;
		this.studentDate = studentDate;
		this.submitIdCnt = submitIdCnt;
		this.userType = userType;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCoursePartCode() {
		return coursePartCode;
	}
	public void setCoursePartCode(String coursePartCode) {
		this.coursePartCode = coursePartCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTitleNamea() {
		return titleNamea;
	}
	public void setTitleNamea(String titleNamea) {
		this.titleNamea = titleNamea;
	}
	public String getStudentDate() {
		return studentDate;
	}
	public void setStudentDate(String studentDate) {
		this.studentDate = studentDate;
	}
	public String getSubmitIdCnt() {
		return submitIdCnt;
	}
	public void setSubmitIdCnt(String submitIdCnt) {
		this.submitIdCnt = submitIdCnt;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "TodoInfos [courseId=" + courseId + ", courseName=" + courseName + ", coursePartCode=" + coursePartCode
				+ ", userId=" + userId + ", infoId=" + infoId + ", titleName=" + titleName + ", title=" + title
				+ ", endDate=" + endDate + ", titleNamea=" + titleNamea + ", studentDate=" + studentDate
				+ ", submitIdCnt=" + submitIdCnt + ", userType=" + userType + "]";
	}

	
	
}
