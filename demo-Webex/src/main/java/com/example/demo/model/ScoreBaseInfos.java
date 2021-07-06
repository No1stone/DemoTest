package com.example.demo.model;

public class ScoreBaseInfos {

	private String scoreField;
	private String scoreType;
	private String scoreName;
	private String basePoint;
	private String etcName;
	public ScoreBaseInfos(String scoreField, String scoreType, String scoreName, String basePoint, String etcName) {
		super();
		this.scoreField = scoreField;
		this.scoreType = scoreType;
		this.scoreName = scoreName;
		this.basePoint = basePoint;
		this.etcName = etcName;
	}
	public String getScoreField() {
		return scoreField;
	}
	public void setScoreField(String scoreField) {
		this.scoreField = scoreField;
	}
	public String getScoreType() {
		return scoreType;
	}
	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}
	public String getScoreName() {
		return scoreName;
	}
	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}
	public String getBasePoint() {
		return basePoint;
	}
	public void setBasePoint(String basePoint) {
		this.basePoint = basePoint;
	}
	public String getEtcName() {
		return etcName;
	}
	public void setEtcName(String etcName) {
		this.etcName = etcName;
	}
	@Override
	public String toString() {
		return "ScoreBaseInfos [scoreField=" + scoreField + ", scoreType=" + scoreType + ", scoreName=" + scoreName
				+ ", basePoint=" + basePoint + ", etcName=" + etcName + "]";
	}

	
}
