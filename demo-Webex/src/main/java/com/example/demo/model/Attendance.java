package com.example.demo.model;

import java.util.List;

public class Attendance {
    private String userId;
    private String lessonElementId;
    private Question question;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getLessonElementId() {
        return lessonElementId;
    }
    public void setLessonElementId(String lessonElementId) {
        this.lessonElementId = lessonElementId;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }

    public static class Question {
        private long id;
        private String title;
        private String validTime;
        private int correctAnswerNo;
        private String successMessage;
        private String failMessage;
        private List<Item> items;

        public Question() {}
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValidTime() {
            return validTime;
        }

        public void setValidTime(String validTime) {
            this.validTime = validTime;
        }

        public int getCorrectAnswerNo() {
            return correctAnswerNo;
        }

        public void setCorrectAnswerNo(int correctAnswerNo) {
            this.correctAnswerNo = correctAnswerNo;
        }

        public String getSuccessMessage() {
            return successMessage;
        }

        public void setSuccessMessage(String successMessage) {
            this.successMessage = successMessage;
        }

        public String getFailMessage() {
            return failMessage;
        }

        public void setFailMessage(String failMessage) {
            this.failMessage = failMessage;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }
    public static class Item {
        private int no;
        private String title;

        public Item() {}
        public int getNo() {
            return no;
        }
        public void setNo(int no) {
            this.no = no;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
    }
}
