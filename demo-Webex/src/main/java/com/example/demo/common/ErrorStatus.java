package com.example.demo.common;

public enum ErrorStatus {
	
	OK(true, 1, ""),
	
	NO_RESULT(false, -1, "No Record"),					//일반적인 조회없음이 아닌 반드시 결과가 있어야하는데 없는 경우 에러
	
	ACCESS_DENIED(false, -101, "Unauthorized Access"),	//인증토큰 오류, 토큰이 없거나 암호화, 복호화 오류시
	TOKEN_EXPIRED(false, -102, "Token Expired"),		//토큰 만료
	
	ID_NOT_EXIST(false, -201, "ID Not Exist Error"),	//해당 아이디 없음
	LOGIN_ERROR(false, -202, "Login Error"),			//아이디 패스워드 오류로 인한 에러
	SITENAME_ERROR(false, -203, "Site Name Error"),		//해당 계정이 site_name이 없음
	WX_LOGIN_ERROR(false, -204, "Webex Login Error"),	//웹액스 로그인 에러
	WX_GETUSER_ERROR(false, -205, "Webex GetUser Error"),	//웹엑스 GetUser API 호출 실패
	
	WX_CREATEMEETING_ERROR(false, -301, "Cannot Create Meeting Schedule"), //웹액스 미팅 예약 등록 실패
	WX_GETHOSTURL_ERROR(false, -302, "Cannot Get HOST URL Meeting Info"),	//HOST URL 호출 실패
	WX_GETJOINURL_ERROR(false, -303, "Cannot Get JOIN URL Meeting Info"),	//JOIN URL 호출 실패
	WX_SETMEETING_ERROR(false, -304, "Cannot Modify Meeting Schedule"),		//웹엑스 미팅 예약 수정 실패
	
	ILLEGAL_ACCESS(false, -904, "Illegal Request");		//sqlinjection 감지	
	
	private int errCode;
	private String errMsg;
	private boolean valid;
	
	private ErrorStatus(boolean valid, int errCode, String errMsg) {
		this.valid = valid;
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public boolean getValid() {
		return this.valid;
	}
	
	public int getErrCode() {
		return this.errCode;
	}
	
	public String getErrMsg() {
		return this.errMsg;
	}	

}
