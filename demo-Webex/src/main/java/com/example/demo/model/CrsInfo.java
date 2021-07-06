package com.example.demo.model;

public class CrsInfo extends UserInfo{
	public CrsInfo(int siteCd, String siteNm, String webexSiteCode, String userId, String userName, String webexId,
			String userType, String deptId, String deptName, String personId) {
		super(siteCd, siteNm, webexSiteCode, userId, userName, webexId, userType, deptId, deptName, personId);
		// TODO Auto-generated constructor stub
	}
	private String courseCode;
	private String courseId;
	private String courseName;
	private String courseNameEn;
	private String courseOwnerId;
	private String coursePartCode;
	private String courseTermId;
	private String courseTermName;
	private String courseType;
	private String credit;
	private String curriculumId;
	private String curriculumName;
	private String departmentId;
	private String grade;
	private String haksaTerm;
	private String haksaYear;
	private String isCourseLearningTerm;
	private String isHaksaData;
	private String learnerCount;
	private String learningEndDate;
	private String learningStartDate;
	private String learningType;
	private String offlineRate;
	private String onlineRate;
	private String regDate;
	private String regId;
	private String reportRate;
	private String scoreEndDate;
	private String scoreStartDate;
	private String shareCourseId;
	private String shareCourseItem;
	private String shareCourseYn;
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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
	public String getCourseNameEn() {
		return courseNameEn;
	}
	public void setCourseNameEn(String courseNameEn) {
		this.courseNameEn = courseNameEn;
	}
	public String getCourseOwnerId() {
		return courseOwnerId;
	}
	public void setCourseOwnerId(String courseOwnerId) {
		this.courseOwnerId = courseOwnerId;
	}
	public String getCoursePartCode() {
		return coursePartCode;
	}
	public void setCoursePartCode(String coursePartCode) {
		this.coursePartCode = coursePartCode;
	}
	public String getCourseTermId() {
		return courseTermId;
	}
	public void setCourseTermId(String courseTermId) {
		this.courseTermId = courseTermId;
	}
	public String getCourseTermName() {
		return courseTermName;
	}
	public void setCourseTermName(String courseTermName) {
		this.courseTermName = courseTermName;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getCurriculumId() {
		return curriculumId;
	}
	public void setCurriculumId(String curriculumId) {
		this.curriculumId = curriculumId;
	}
	public String getCurriculumName() {
		return curriculumName;
	}
	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getHaksaTerm() {
		return haksaTerm;
	}
	public void setHaksaTerm(String haksaTerm) {
		this.haksaTerm = haksaTerm;
	}
	public String getHaksaYear() {
		return haksaYear;
	}
	public void setHaksaYear(String haksaYear) {
		this.haksaYear = haksaYear;
	}
	public String getIsCourseLearningTerm() {
		return isCourseLearningTerm;
	}
	public void setIsCourseLearningTerm(String isCourseLearningTerm) {
		this.isCourseLearningTerm = isCourseLearningTerm;
	}
	public String getIsHaksaData() {
		return isHaksaData;
	}
	public void setIsHaksaData(String isHaksaData) {
		this.isHaksaData = isHaksaData;
	}
	public String getLearnerCount() {
		return learnerCount;
	}
	public void setLearnerCount(String learnerCount) {
		this.learnerCount = learnerCount;
	}
	public String getLearningEndDate() {
		return learningEndDate;
	}
	public void setLearningEndDate(String learningEndDate) {
		this.learningEndDate = learningEndDate;
	}
	public String getLearningStartDate() {
		return learningStartDate;
	}
	public void setLearningStartDate(String learningStartDate) {
		this.learningStartDate = learningStartDate;
	}
	public String getLearningType() {
		return learningType;
	}
	public void setLearningType(String learningType) {
		this.learningType = learningType;
	}
	public String getOfflineRate() {
		return offlineRate;
	}
	public void setOfflineRate(String offlineRate) {
		this.offlineRate = offlineRate;
	}
	public String getOnlineRate() {
		return onlineRate;
	}
	public void setOnlineRate(String onlineRate) {
		this.onlineRate = onlineRate;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getReportRate() {
		return reportRate;
	}
	public void setReportRate(String reportRate) {
		this.reportRate = reportRate;
	}
	public String getScoreEndDate() {
		return scoreEndDate;
	}
	public void setScoreEndDate(String scoreEndDate) {
		this.scoreEndDate = scoreEndDate;
	}
	public String getScoreStartDate() {
		return scoreStartDate;
	}
	public void setScoreStartDate(String scoreStartDate) {
		this.scoreStartDate = scoreStartDate;
	}
	public String getShareCourseId() {
		return shareCourseId;
	}
	public void setShareCourseId(String shareCourseId) {
		this.shareCourseId = shareCourseId;
	}
	public String getShareCourseItem() {
		return shareCourseItem;
	}
	public void setShareCourseItem(String shareCourseItem) {
		this.shareCourseItem = shareCourseItem;
	}
	public String getShareCourseYn() {
		return shareCourseYn;
	}
	public void setShareCourseYn(String shareCourseYn) {
		this.shareCourseYn = shareCourseYn;
	}
	@Override
	public String toString() {
		return "CrsInfo [courseCode=" + courseCode + ", courseId=" + courseId + ", courseName=" + courseName
				+ ", courseNameEn=" + courseNameEn + ", courseOwnerId=" + courseOwnerId + ", coursePartCode="
				+ coursePartCode + ", courseTermId=" + courseTermId + ", courseTermName=" + courseTermName
				+ ", courseType=" + courseType + ", credit=" + credit + ", curriculumId=" + curriculumId
				+ ", curriculumName=" + curriculumName + ", departmentId=" + departmentId + ", grade=" + grade
				+ ", haksaTerm=" + haksaTerm + ", haksaYear=" + haksaYear + ", isCourseLearningTerm="
				+ isCourseLearningTerm + ", isHaksaData=" + isHaksaData + ", learnerCount=" + learnerCount
				+ ", learningEndDate=" + learningEndDate + ", learningStartDate=" + learningStartDate
				+ ", learningType=" + learningType + ", offlineRate=" + offlineRate + ", onlineRate=" + onlineRate
				+ ", regDate=" + regDate + ", regId=" + regId + ", reportRate=" + reportRate + ", scoreEndDate="
				+ scoreEndDate + ", scoreStartDate=" + scoreStartDate + ", shareCourseId=" + shareCourseId
				+ ", shareCourseItem=" + shareCourseItem + ", shareCourseYn=" + shareCourseYn + "]";
	}
	
	
	
	

}
