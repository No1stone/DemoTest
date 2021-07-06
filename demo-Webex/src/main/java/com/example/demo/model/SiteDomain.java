package com.example.demo.model;

public class SiteDomain {
	private int SiteCD;
	private String SiteNM;
	private String SiteDomain;
	private String LMSDomain;
	private String WebexSiteCode;
	
	public SiteDomain() {};
	
	public SiteDomain(int siteCD, String siteNM, String siteDomain, String lMSDomain, String webexSiteCode) {
		super();
		SiteCD = siteCD;
		SiteNM = siteNM;
		SiteDomain = siteDomain;
		LMSDomain = lMSDomain;
		WebexSiteCode = webexSiteCode;
	}
	
	public int getSiteCD() {
		return SiteCD;
	}
	public void setSiteCD(int siteCD) {
		SiteCD = siteCD;
	}
	public String getSiteNM() {
		return SiteNM;
	}
	public void setSiteNM(String siteNM) {
		SiteNM = siteNM;
	}
	public String getSiteDomain() {
		return SiteDomain;
	}
	public void setSiteDomain(String siteDomain) {
		SiteDomain = siteDomain;
	}
	public String getLMSDomain() {
		return LMSDomain;
	}
	public void setLMSDomain(String lMSDomain) {
		LMSDomain = lMSDomain;
	}
	public String getWebexSiteCode() {
		return WebexSiteCode;
	}
	public void setWebexSiteCode(String webexSiteCode) {
		WebexSiteCode = webexSiteCode;
	}
	
	@Override
	public String toString() {
		return "Sitedomain [SiteCD=" + SiteCD + ", SiteNM=" + SiteNM + ", SiteDomain=" + SiteDomain + ", LMSDomain="
				+ LMSDomain + ", WebexSiteCode=" + WebexSiteCode + "]";
	}

}
