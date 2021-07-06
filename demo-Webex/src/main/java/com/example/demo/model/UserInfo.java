package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("userInfo")
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1038292149521286980L;
	
	private int siteCd;
	private String siteNm;
	private String webexSiteCode;
	private String userId;
	private String userName;
	private String webexId;
	private String userType;
	private String deptId;
	private String deptName;
	private String personId;
	public UserInfo(int siteCd, String siteNm, String webexSiteCode, String userId, String userName, String webexId,
			String userType, String deptId, String deptName, String personId) {
		super();
		this.siteCd = siteCd;
		this.siteNm = siteNm;
		this.webexSiteCode = webexSiteCode;
		this.userId = userId;
		this.userName = userName;
		this.webexId = webexId;
		this.userType = userType;
		this.deptId = deptId;
		this.deptName = deptName;
		this.personId = personId;
	}
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public int getSiteCd() {
		return siteCd;
	}
	public void setSiteCd(int siteCd) {
		this.siteCd = siteCd;
	}
	public String getSiteNm() {
		return siteNm;
	}
	public void setSiteNm(String siteNm) {
		this.siteNm = siteNm;
	}
	public String getWebexSiteCode() {
		return webexSiteCode;
	}
	public void setWebexSiteCode(String webexSiteCode) {
		this.webexSiteCode = webexSiteCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWebexId() {
		return webexId;
	}
	public void setWebexId(String webexId) {
		this.webexId = webexId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserInfo [siteCd=" + siteCd + ", siteNm=" + siteNm + ", webexSiteCode=" + webexSiteCode + ", userId="
				+ userId + ", userName=" + userName + ", webexId=" + webexId + ", userType=" + userType + ", deptId="
				+ deptId + ", deptName=" + deptName + ", personId=" + personId + "]";
	}
	
	
	
	}
