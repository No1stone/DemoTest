package com.example.demo.model;

public class CrsLessonTermInfos {
	
	private String lessonOrder;
	private String lessonStartDate;
	private String lessonEndDate;
	public CrsLessonTermInfos(String lessonOrder, String lessonStartDate, String lessonEndDate) {
		super();
		this.lessonOrder = lessonOrder;
		this.lessonStartDate = lessonStartDate;
		this.lessonEndDate = lessonEndDate;
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
	@Override
	public String toString() {
		return "CrsLessonTermInfos [lessonOrder=" + lessonOrder + ", lessonStartDate=" + lessonStartDate
				+ ", lessonEndDate=" + lessonEndDate + "]";
	}
	
	
}
