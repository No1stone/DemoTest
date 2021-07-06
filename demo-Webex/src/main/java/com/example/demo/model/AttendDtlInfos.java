package com.example.demo.model;

public class AttendDtlInfos {
	private String lessonContentsId;
	private String lessonName;
	private String lessonOrder;
	private String lessonStartDate;
	private String lessonEndDate;
	private String lessonElementId;
	private String elementType;
	private String elementName;
	private String elementOrder;
	private String studyTotalTime;
	private String studyAfterTime;
	private String studyStatus;
	public AttendDtlInfos(String lessonContentsId, String lessonName, String lessonOrder, String lessonStartDate,
			String lessonEndDate, String lessonElementId, String elementType, String elementName, String elementOrder,
			String studyTotalTime, String studyAfterTime, String studyStatus) {
		super();
		this.lessonContentsId = lessonContentsId;
		this.lessonName = lessonName;
		this.lessonOrder = lessonOrder;
		this.lessonStartDate = lessonStartDate;
		this.lessonEndDate = lessonEndDate;
		this.lessonElementId = lessonElementId;
		this.elementType = elementType;
		this.elementName = elementName;
		this.elementOrder = elementOrder;
		this.studyTotalTime = studyTotalTime;
		this.studyAfterTime = studyAfterTime;
		this.studyStatus = studyStatus;
	}
	public String getLessonContentsId() {
		return lessonContentsId;
	}
	public void setLessonContentsId(String lessonContentsId) {
		this.lessonContentsId = lessonContentsId;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public String getLessonOrder() {
		return lessonOrder;
	}
	public void setLessonOrder(String lessonOrder) {
		this.lessonOrder = lessonOrder;
	}
	public String getLessonStartDate() {
		return lessonStartDate;
	}
	public void setLessonStartDate(String lessonStartDate) {
		this.lessonStartDate = lessonStartDate;
	}
	public String getLessonEndDate() {
		return lessonEndDate;
	}
	public void setLessonEndDate(String lessonEndDate) {
		this.lessonEndDate = lessonEndDate;
	}
	public String getLessonElementId() {
		return lessonElementId;
	}
	public void setLessonElementId(String lessonElementId) {
		this.lessonElementId = lessonElementId;
	}
	public String getElementType() {
		return elementType;
	}
	public void setElementType(String elementType) {
		this.elementType = elementType;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public String getElementOrder() {
		return elementOrder;
	}
	public void setElementOrder(String elementOrder) {
		this.elementOrder = elementOrder;
	}
	public String getStudyTotalTime() {
		return studyTotalTime;
	}
	public void setStudyTotalTime(String studyTotalTime) {
		this.studyTotalTime = studyTotalTime;
	}
	public String getStudyAfterTime() {
		return studyAfterTime;
	}
	public void setStudyAfterTime(String studyAfterTime) {
		this.studyAfterTime = studyAfterTime;
	}
	public String getStudyStatus() {
		return studyStatus;
	}
	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}
	@Override
	public String toString() {
		return "AttendDtlInfos [lessonContentsId=" + lessonContentsId + ", lessonName=" + lessonName + ", lessonOrder="
				+ lessonOrder + ", lessonStartDate=" + lessonStartDate + ", lessonEndDate=" + lessonEndDate
				+ ", lessonElementId=" + lessonElementId + ", elementType=" + elementType + ", elementName="
				+ elementName + ", elementOrder=" + elementOrder + ", studyTotalTime=" + studyTotalTime
				+ ", studyAfterTime=" + studyAfterTime + ", studyStatus=" + studyStatus + "]";
	}
	
	

}
