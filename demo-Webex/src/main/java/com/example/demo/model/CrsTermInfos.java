package com.example.demo.model;

public class CrsTermInfos extends UserInfo{

	
	private String courseTermId;
	private String courseTermName; 
	private String enrollStartDate;
	private String enrollEndDate;
	private String enrollModifyStartDate;
	private String enrollModifyEndDate;
	private String learningStartDate;
	private String learningModifyEndDate;
	private String scoreStartDate;
	private String scoreEndDate;
	public CrsTermInfos(String courseTermId, String courseTermNm, String enrollStartDate, String enrollEndDate,
			String enrollModifyStartDate, String enrollModifyEndDate, String learningStartDate,
			String learningModifyEndDate, String scoreStartDate, String scoreEndDate) {
		super();
		this.courseTermId = courseTermId;
		this.courseTermName = courseTermNm;
		this.enrollStartDate = enrollStartDate;
		this.enrollEndDate = enrollEndDate;
		this.enrollModifyStartDate = enrollModifyStartDate;
		this.enrollModifyEndDate = enrollModifyEndDate;
		this.learningStartDate = learningStartDate;
		this.learningModifyEndDate = learningModifyEndDate;
		this.scoreStartDate = scoreStartDate;
		this.scoreEndDate = scoreEndDate;
	}
	public CrsTermInfos() {
		// TODO Auto-generated constructor stub
	}
	public String getCourseTermId() {
		return courseTermId;
	}
	public void setCourseTermId(String courseTermId) {
		this.courseTermId = courseTermId;
	}
	public String getCourseTermNm() {
		return courseTermName;
	}
	public void setCourseTermNm(String courseTermNm) {
		this.courseTermName = courseTermNm;
	}
	public String getEnrollStartDate() {
		return enrollStartDate;
	}
	public void setEnrollStartDate(String enrollStartDate) {
		this.enrollStartDate = enrollStartDate;
	}
	public String getEnrollEndDate() {
		return enrollEndDate;
	}
	public void setEnrollEndDate(String enrollEndDate) {
		this.enrollEndDate = enrollEndDate;
	}
	public String getEnrollModifyStartDate() {
		return enrollModifyStartDate;
	}
	public void setEnrollModifyStartDate(String enrollModifyStartDate) {
		this.enrollModifyStartDate = enrollModifyStartDate;
	}
	public String getEnrollModifyEndDate() {
		return enrollModifyEndDate;
	}
	public void setEnrollModifyEndDate(String enrollModifyEndDate) {
		this.enrollModifyEndDate = enrollModifyEndDate;
	}
	public String getLearningStartDate() {
		return learningStartDate;
	}
	public void setLearningStartDate(String learningStartDate) {
		this.learningStartDate = learningStartDate;
	}
	public String getLearningModifyEndDate() {
		return learningModifyEndDate;
	}
	public void setLearningModifyEndDate(String learningModifyEndDate) {
		this.learningModifyEndDate = learningModifyEndDate;
	}
	public String getScoreStartDate() {
		return scoreStartDate;
	}
	public void setScoreStartDate(String scoreStartDate) {
		this.scoreStartDate = scoreStartDate;
	}
	public String getScoreEndDate() {
		return scoreEndDate;
	}
	public void setScoreEndDate(String scoreEndDate) {
		this.scoreEndDate = scoreEndDate;
	}
	@Override
	public String toString() {
		return "CrsTermInfos [courseTermId=" + courseTermId + ", courseTermNm=" + courseTermName + ", enrollStartDate="
				+ enrollStartDate + ", enrollEndDate=" + enrollEndDate + ", enrollModifyStartDate="
				+ enrollModifyStartDate + ", enrollModifyEndDate=" + enrollModifyEndDate + ", learningStartDate="
				+ learningStartDate + ", learningModifyEndDate=" + learningModifyEndDate + ", scoreStartDate="
				+ scoreStartDate + ", scoreEndDate=" + scoreEndDate + "]";
	}

	
}
