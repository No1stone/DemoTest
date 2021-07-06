package com.example.demo.model;

public class ActionItem extends Report{

    private String personalId;
    private String userId;
    private String siteCd;
    private String service;
    private String lessonElementId;
    private Attendance.Question question;

    public String getPersonalId() {
        return personalId;
    }
    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }
    public String getSiteCd() {
        return siteCd;
    }
    public void setSiteCd(String siteCd) {
        this.siteCd = siteCd;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }

    public String getLessonElementId() {
        return lessonElementId;
    }
    public void setLessonElementId(String lessonElementId) {
        this.lessonElementId = lessonElementId;
    }

    public Attendance.Question getQuestion() {
        return question;
    }
    public void setQuestion(Attendance.Question question) {
        this.question = question;
    }
}
