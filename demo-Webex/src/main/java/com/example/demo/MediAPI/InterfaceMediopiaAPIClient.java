package com.example.demo.MediAPI;

import java.util.List;

import com.example.demo.model.ActionItem;
import com.example.demo.model.AttendDtlInfos;
import com.example.demo.model.AttendInfos;
import com.example.demo.model.CrsInfo;
import com.example.demo.model.CrsLessonTermInfos;
import com.example.demo.model.CrsTermInfos;
import com.example.demo.model.EtestStatusList;
import com.example.demo.model.ForumRegList;
import com.example.demo.model.MyEtestInfos;
import com.example.demo.model.MyForumInfos;
import com.example.demo.model.MyResearchInfos;
import com.example.demo.model.MyTeamactInfos;
import com.example.demo.model.Report;
import com.example.demo.model.ResearchAnswerList;
import com.example.demo.model.ScoreBaseInfos;
import com.example.demo.model.ScoreInfos;
import com.example.demo.model.Submitter;
import com.example.demo.model.TeamactOutputList;
import com.example.demo.model.TodoInfos;
import com.example.demo.model.UserInfo;

public interface InterfaceMediopiaAPIClient {

	// 리포트
	public List<Report> requestCourseByProfessor(UserInfo userInfo);

	// 리포트
	public List<Report> requestCourseByProfessor(String filter, UserInfo userInfo);

	// 코스정보
	public List<CrsInfo> requestCrsInfo(UserInfo userInfo);

	// 코스정보
	public List<CrsInfo> requestCrsInfo(String filter, UserInfo userInfo);

	// 오늘할일
	public List<TodoInfos> MyTodoInfosMedi(UserInfo userInfo);

	// 나의토론정보리스트 코스인포 값 사용한다
	public List<MyForumInfos> MyForumInfosMedi(UserInfo userInfo);

	// 나의시험정보리스트
	public List<MyEtestInfos> MyEtestInfosMedi(UserInfo userInfo);

	// 나의 설문 정보 리스트
	public List<MyResearchInfos> MyResearchInfosMedi(UserInfo userInfo);

	// 나의 팀활동 정보 리스트
	public List<MyTeamactInfos> MyTeamactInfosMedi(UserInfo userInfo);


	// 차시별 출석 정보 리스트 코스인포값 사용한다
	public List<AttendDtlInfos> AttendDtlInfosMedi(UserInfo userInfo, String crsInfo);


	// 평가비율리스트 코스인포값 사용한다
	public List<ScoreBaseInfos> ScoreBaseInfosMedi(UserInfo userInfo, String crsInfo);

	// 성적정보리스트 코스인포값 사용한다
	public List<ScoreInfos> ScoreInfosMedi(UserInfo userInfo, String crsInfo);

	// 출석 정보 리스트 코스인포값 사용한다
	public List<AttendInfos> AttendInfosMedi(UserInfo userInfo, String crsInfo);
	
	// 학기정보
	public List<CrsTermInfos> CrsTermInfosMedi(UserInfo user, String courseTermId);
	
	// 제출자
	public List<Submitter> requestSubmitterByProfessor(String submitStatus, UserInfo userInfo, ActionItem item);

	// 제출상태
	public Submitter requestReportSubmitStatus(String submitStatus, UserInfo userInfo, ActionItem item);

	// 몰입도
	public String requestAttendance(boolean isCorrect, ActionItem item);


	// 주별일정리스트 코스인포 courseTermId값 사용한다.
	public List<CrsLessonTermInfos> CrsLessonTermInfosMedi(UserInfo userInfo, String courseTermId);

	// 토론 참여자 리스트 코스인포값 사용한다
	public List<ForumRegList> ForumRegListMedi(UserInfo userInfo, String myForumInfos,
			String crsInfo);

	// 시험 응시자 리스트 코스인포값 사용한다
	public List<EtestStatusList> EtestStatusListMedi(UserInfo userInfo, String crsInfo,
			String myEtestInfos);

	// 설문 응답자 리스트 코스인포값 사용한다
	public List<ResearchAnswerList> ResearchAnswerListMedi(UserInfo userInfo, String crsInfo,
			String myResearchInfos);

	// 팀활동 산출물 리스트 코스인포값 사용한다
	public List<TeamactOutputList> TeamactOutputListMedi(UserInfo userInfo, String crsInfo,
			String myTeamactInfos);


}
