package com.example.demo.model;

public class MyTeamactInfos {

	private String courseId;
	private String teamactId;
	private String outputYn;
	private String openYn;
	private String scoreYn;
	private String scoreRatio;
	private String afterYn;
	private String deletedYn;
	private String teamCategoryId;
	private String teamCategoryNm;
	private String startDate;
	private String endDate;
	private String viewScoreDate;
	private String scoreOpenYn;
	private String teamactSummary;
	private String referenceData;
	private String teamactObject;
	public MyTeamactInfos(String courseId, String teamactId, String outputYn, String openYn, String scoreYn,
			String scoreRatio, String afterYn, String deletedYn, String teamCategoryId, String teamCategoryNm,
			String startDate, String endDate, String viewScoreDate, String scoreOpenYn, String teamactSummary,
			String referenceData, String teamactObject) {
		super();
		this.courseId = courseId;
		this.teamactId = teamactId;
		this.outputYn = outputYn;
		this.openYn = openYn;
		this.scoreYn = scoreYn;
		this.scoreRatio = scoreRatio;
		this.afterYn = afterYn;
		this.deletedYn = deletedYn;
		this.teamCategoryId = teamCategoryId;
		this.teamCategoryNm = teamCategoryNm;
		this.startDate = startDate;
		this.endDate = endDate;
		this.viewScoreDate = viewScoreDate;
		this.scoreOpenYn = scoreOpenYn;
		this.teamactSummary = teamactSummary;
		this.referenceData = referenceData;
		this.teamactObject = teamactObject;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getTeamactId() {
		return teamactId;
	}
	public void setTeamactId(String teamactId) {
		this.teamactId = teamactId;
	}
	public String getOutputYn() {
		return outputYn;
	}
	public void setOutputYn(String outputYn) {
		this.outputYn = outputYn;
	}
	public String getOpenYn() {
		return openYn;
	}
	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}
	public String getScoreYn() {
		return scoreYn;
	}
	public void setScoreYn(String scoreYn) {
		this.scoreYn = scoreYn;
	}
	public String getScoreRatio() {
		return scoreRatio;
	}
	public void setScoreRatio(String scoreRatio) {
		this.scoreRatio = scoreRatio;
	}
	public String getAfterYn() {
		return afterYn;
	}
	public void setAfterYn(String afterYn) {
		this.afterYn = afterYn;
	}
	public String getDeletedYn() {
		return deletedYn;
	}
	public void setDeletedYn(String deletedYn) {
		this.deletedYn = deletedYn;
	}
	public String getTeamCategoryId() {
		return teamCategoryId;
	}
	public void setTeamCategoryId(String teamCategoryId) {
		this.teamCategoryId = teamCategoryId;
	}
	public String getTeamCategoryNm() {
		return teamCategoryNm;
	}
	public void setTeamCategoryNm(String teamCategoryNm) {
		this.teamCategoryNm = teamCategoryNm;
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
	public String getViewScoreDate() {
		return viewScoreDate;
	}
	public void setViewScoreDate(String viewScoreDate) {
		this.viewScoreDate = viewScoreDate;
	}
	public String getScoreOpenYn() {
		return scoreOpenYn;
	}
	public void setScoreOpenYn(String scoreOpenYn) {
		this.scoreOpenYn = scoreOpenYn;
	}
	public String getTeamactSummary() {
		return teamactSummary;
	}
	public void setTeamactSummary(String teamactSummary) {
		this.teamactSummary = teamactSummary;
	}
	public String getReferenceData() {
		return referenceData;
	}
	public void setReferenceData(String referenceData) {
		this.referenceData = referenceData;
	}
	public String getTeamactObject() {
		return teamactObject;
	}
	public void setTeamactObject(String teamactObject) {
		this.teamactObject = teamactObject;
	}
	@Override
	public String toString() {
		return "MyTeamactInfos [courseId=" + courseId + ", teamactId=" + teamactId + ", outputYn=" + outputYn
				+ ", openYn=" + openYn + ", scoreYn=" + scoreYn + ", scoreRatio=" + scoreRatio + ", afterYn=" + afterYn
				+ ", deletedYn=" + deletedYn + ", teamCategoryId=" + teamCategoryId + ", teamCategoryNm="
				+ teamCategoryNm + ", startDate=" + startDate + ", endDate=" + endDate + ", viewScoreDate="
				+ viewScoreDate + ", scoreOpenYn=" + scoreOpenYn + ", teamactSummary=" + teamactSummary
				+ ", referenceData=" + referenceData + ", teamactObject=" + teamactObject + "]";
	}

	
	
}
