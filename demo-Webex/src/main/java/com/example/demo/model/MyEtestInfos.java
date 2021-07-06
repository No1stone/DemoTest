package com.example.demo.model;

public class MyEtestInfos {

	private String courseId;
	private String etestInfoId;
	private String etestName;
	private String etestType;
	private String etestDesc;
	private String startDate;
	private String endDate;
	private String restartDate;
	private String reendDate;
	private String retestRatio;
	private String viewScoreDate;
	private String durationTime;
	private String applyNum;
	private String scoreYn;
	private String questionSetType;
	private String etestTestType;
	private String scoreOpenYn;
	public MyEtestInfos(String courseId, String etestInfoId, String etestName, String etestType, String etestDesc,
			String startDate, String endDate, String restartDate, String reendDate, String retestRatio,
			String viewScoreDate, String durationTime, String applyNum, String scoreYn, String questionSetType,
			String etestTestType, String scoreOpenYn) {
		super();
		this.courseId = courseId;
		this.etestInfoId = etestInfoId;
		this.etestName = etestName;
		this.etestType = etestType;
		this.etestDesc = etestDesc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.restartDate = restartDate;
		this.reendDate = reendDate;
		this.retestRatio = retestRatio;
		this.viewScoreDate = viewScoreDate;
		this.durationTime = durationTime;
		this.applyNum = applyNum;
		this.scoreYn = scoreYn;
		this.questionSetType = questionSetType;
		this.etestTestType = etestTestType;
		this.scoreOpenYn = scoreOpenYn;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getEtestInfoId() {
		return etestInfoId;
	}
	public void setEtestInfoId(String etestInfoId) {
		this.etestInfoId = etestInfoId;
	}
	public String getEtestName() {
		return etestName;
	}
	public void setEtestName(String etestName) {
		this.etestName = etestName;
	}
	public String getEtestType() {
		return etestType;
	}
	public void setEtestType(String etestType) {
		this.etestType = etestType;
	}
	public String getEtestDesc() {
		return etestDesc;
	}
	public void setEtestDesc(String etestDesc) {
		this.etestDesc = etestDesc;
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
	public String getRestartDate() {
		return restartDate;
	}
	public void setRestartDate(String restartDate) {
		this.restartDate = restartDate;
	}
	public String getReendDate() {
		return reendDate;
	}
	public void setReendDate(String reendDate) {
		this.reendDate = reendDate;
	}
	public String getRetestRatio() {
		return retestRatio;
	}
	public void setRetestRatio(String retestRatio) {
		this.retestRatio = retestRatio;
	}
	public String getViewScoreDate() {
		return viewScoreDate;
	}
	public void setViewScoreDate(String viewScoreDate) {
		this.viewScoreDate = viewScoreDate;
	}
	public String getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	public String getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}
	public String getScoreYn() {
		return scoreYn;
	}
	public void setScoreYn(String scoreYn) {
		this.scoreYn = scoreYn;
	}
	public String getQuestionSetType() {
		return questionSetType;
	}
	public void setQuestionSetType(String questionSetType) {
		this.questionSetType = questionSetType;
	}
	public String getEtestTestType() {
		return etestTestType;
	}
	public void setEtestTestType(String etestTestType) {
		this.etestTestType = etestTestType;
	}
	public String getScoreOpenYn() {
		return scoreOpenYn;
	}
	public void setScoreOpenYn(String scoreOpenYn) {
		this.scoreOpenYn = scoreOpenYn;
	}
	@Override
	public String toString() {
		return "MyEtestInfos [courseId=" + courseId + ", etestInfoId=" + etestInfoId + ", etestName=" + etestName
				+ ", etestType=" + etestType + ", etestDesc=" + etestDesc + ", startDate=" + startDate + ", endDate="
				+ endDate + ", restartDate=" + restartDate + ", reendDate=" + reendDate + ", retestRatio=" + retestRatio
				+ ", viewScoreDate=" + viewScoreDate + ", durationTime=" + durationTime + ", applyNum=" + applyNum
				+ ", scoreYn=" + scoreYn + ", questionSetType=" + questionSetType + ", etestTestType=" + etestTestType
				+ ", scoreOpenYn=" + scoreOpenYn + "]";
	}

	
}
