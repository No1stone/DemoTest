package com.example.demo.model;

public class MyForumInfos {
	private String courseId;
	private String forumInfoId;
	private String forumName;
	private String forumContents;
	private String startDate;
	private String endDate;
	private String scoreOpenYn;
	private String endUseYn;
	private String otherUseYn;
	private String forumScoreDate;
	private String viewScoreDate;
	private String teamForumYn;
	private String teamCategoryId;
	public MyForumInfos(String courseId, String forumInfoId, String forumName, String forumContents, String startDate,
			String endDate, String scoreOpenYn, String endUseYn, String otherUseYn, String forumScoreDate,
			String viewScoreDate, String teamForumYn, String teamCategoryId) {
		super();
		this.courseId = courseId;
		this.forumInfoId = forumInfoId;
		this.forumName = forumName;
		this.forumContents = forumContents;
		this.startDate = startDate;
		this.endDate = endDate;
		this.scoreOpenYn = scoreOpenYn;
		this.endUseYn = endUseYn;
		this.otherUseYn = otherUseYn;
		this.forumScoreDate = forumScoreDate;
		this.viewScoreDate = viewScoreDate;
		this.teamForumYn = teamForumYn;
		this.teamCategoryId = teamCategoryId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getForumInfoId() {
		return forumInfoId;
	}
	public void setForumInfoId(String forumInfoId) {
		this.forumInfoId = forumInfoId;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumContents() {
		return forumContents;
	}
	public void setForumContents(String forumContents) {
		this.forumContents = forumContents;
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
	public String getScoreOpenYn() {
		return scoreOpenYn;
	}
	public void setScoreOpenYn(String scoreOpenYn) {
		this.scoreOpenYn = scoreOpenYn;
	}
	public String getEndUseYn() {
		return endUseYn;
	}
	public void setEndUseYn(String endUseYn) {
		this.endUseYn = endUseYn;
	}
	public String getOtherUseYn() {
		return otherUseYn;
	}
	public void setOtherUseYn(String otherUseYn) {
		this.otherUseYn = otherUseYn;
	}
	public String getForumScoreDate() {
		return forumScoreDate;
	}
	public void setForumScoreDate(String forumScoreDate) {
		this.forumScoreDate = forumScoreDate;
	}
	public String getViewScoreDate() {
		return viewScoreDate;
	}
	public void setViewScoreDate(String viewScoreDate) {
		this.viewScoreDate = viewScoreDate;
	}
	public String getTeamForumYn() {
		return teamForumYn;
	}
	public void setTeamForumYn(String teamForumYn) {
		this.teamForumYn = teamForumYn;
	}
	public String getTeamCategoryId() {
		return teamCategoryId;
	}
	public void setTeamCategoryId(String teamCategoryId) {
		this.teamCategoryId = teamCategoryId;
	}
	@Override
	public String toString() {
		return "MyForumInfos [courseId=" + courseId + ", forumInfoId=" + forumInfoId + ", forumName=" + forumName
				+ ", forumContents=" + forumContents + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", scoreOpenYn=" + scoreOpenYn + ", endUseYn=" + endUseYn + ", otherUseYn=" + otherUseYn
				+ ", forumScoreDate=" + forumScoreDate + ", viewScoreDate=" + viewScoreDate + ", teamForumYn="
				+ teamForumYn + ", teamCategoryId=" + teamCategoryId + "]";
	}

	
	
}
