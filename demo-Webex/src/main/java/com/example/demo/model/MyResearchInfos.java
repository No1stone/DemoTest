package com.example.demo.model;

public class MyResearchInfos {
	private String courseId;
	private String researchInfoId;
	private String title;
	private String researchDesc;
	private String startDate;
	private String endDate;
	private String researchType;
	public MyResearchInfos(String courseId, String researchInfoId, String title, String researchDesc, String startDate,
			String endDate, String researchType) {
		super();
		this.courseId = courseId;
		this.researchInfoId = researchInfoId;
		this.title = title;
		this.researchDesc = researchDesc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.researchType = researchType;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getResearchInfoId() {
		return researchInfoId;
	}
	public void setResearchInfoId(String researchInfoId) {
		this.researchInfoId = researchInfoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResearchDesc() {
		return researchDesc;
	}
	public void setResearchDesc(String researchDesc) {
		this.researchDesc = researchDesc;
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
	public String getResearchType() {
		return researchType;
	}
	public void setResearchType(String researchType) {
		this.researchType = researchType;
	}
	@Override
	public String toString() {
		return "MyResearchInfos [courseId=" + courseId + ", researchInfoId=" + researchInfoId + ", title=" + title
				+ ", researchDesc=" + researchDesc + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", researchType=" + researchType + "]";
	}
	
	
}
