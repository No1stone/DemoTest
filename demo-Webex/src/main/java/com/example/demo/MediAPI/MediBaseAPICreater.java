package com.example.demo.MediAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mapper.second.SecondDAO;
import com.example.demo.model.*;

@Component
public class MediBaseAPICreater {
	@Autowired
	private SecondDAO secondDAO;
	@Autowired
	private MediopiaAPIClient mediopiaAPIClient;

// 유저인포리턴
	public UserInfo MediUserInfoCreate(String email) {
		UserInfo user = secondDAO.findUserByPersonEmail(email);
		return user;
	}

//	코스리턴
	public List<CrsInfo> MediCrsInfoCreate(String email) {
		UserInfo user = secondDAO.findUserByPersonEmail(email);
		List<CrsInfo> crsInfo = mediopiaAPIClient.requestCrsInfo(user);
		return crsInfo;
	}

//	리포트리턴
	public List<Report> MediReportCreate(String email) {
		UserInfo user = secondDAO.findUserByPersonEmail(email);
		List<Report> report = mediopiaAPIClient.requestCourseByProfessor(user);
		return report;
	}

//	학기정보리턴
	public List<CrsTermInfos> MediCrsTermInfosCreate(String email) {
		UserInfo user = secondDAO.findUserByPersonEmail(email);
		List<CrsInfo> crsInfo = mediopiaAPIClient.requestCrsInfo(user);
		List<CrsTermInfos> crstermInfos = null;
		// mediopiaAPIClient.CrsTermInfosMedi(user, crsInfo.get(0).getCourseId());

		// System.out.println(crstermInfos.get(0).getEnrollEndDate());

		List<Object> obj = new ArrayList<>();
		for (CrsInfo e : crsInfo) {
			crstermInfos = mediopiaAPIClient.CrsTermInfosMedi(user, e.getCourseTermId());
			obj.add(crstermInfos);
			System.out.println("getCourseTermId값 확인  :" + e.getCourseTermId());
		}

		for (int i = 0; i < obj.size(); i++) {
			System.out.println("CrsTermInfos obj값 확인--------------------시작");
			System.out.println(obj.get(i).toString());
			System.out.println("CrsTermInfos obj값 확인--------------------끝");
		}

		return crstermInfos;
	}

	public List<CrsLessonTermInfos> MediCrsLessonTermInfosCreate(String email) {
		UserInfo user = MediUserInfoCreate(email);
		List<CrsTermInfos> crsTermInfos = MediCrsTermInfosCreate(email);
		List<CrsLessonTermInfos> crsLessonTermInfos = null;

		List<Object> obj = new ArrayList<>();
		for (CrsTermInfos e : crsTermInfos) {
			crsLessonTermInfos = mediopiaAPIClient.CrsLessonTermInfosMedi(user, e.getCourseTermId());
			obj.add(crsLessonTermInfos);
			System.out.println("======================");
			System.out.println("====출력" + e);
		}

		for (int i = 0; i < obj.size(); i++) {
			System.out.println("CrsLessonTermInfos obj값 확인--------------------시작");
			System.out.println(obj.get(i).toString());
			System.out.println("CrsLessonTermInfos obj값 확인--------------------끝");
		}
		return crsLessonTermInfos;
	}

	public List<MyForumInfos> MediMyForumInfosCreate(String email) {
		UserInfo user = MediUserInfoCreate(email);
		List<MyForumInfos> myForumInfos = mediopiaAPIClient.MyForumInfosMedi(user);
		return myForumInfos;
	}

	public List<ForumRegList> MediForumRegListcreate(String email) {
		UserInfo user = MediUserInfoCreate(email);
		List<MyForumInfos> myForumInfos = mediopiaAPIClient.MyForumInfosMedi(user);
		List<ForumRegList> ForumRegL = null;
		List<Object> obj1 = new ArrayList<>();

		for (MyForumInfos e : myForumInfos) {
			ForumRegL = mediopiaAPIClient.ForumRegListMedi(user, e.getForumInfoId(), e.getCourseId());
			obj1.add(ForumRegL);
		}
		System.out.println("오브잭트사이즈" + obj1.size());

		for (int j = 0; j < obj1.size(); j++) {
			System.out.println("ForumRegList obj값 확인--------------------시작");
			System.out.println(obj1.get(j).toString());
			System.out.println("ForumRegList obj값 확인--------------------끝");
		}

		return ForumRegL;
	}

	public List<AttendInfos> MediAttendInfosCreate(String email) {
		UserInfo user = MediUserInfoCreate(email);
		List<CrsInfo> srcInfo = MediCrsInfoCreate(email);
		List<AttendInfos> attendInfos = null;// mediopiaAPIClient.AttendInfosMedi(user, srcInfo);
		List<Object> obj1 = new ArrayList<>();
		for (CrsInfo e : srcInfo) {
			attendInfos = mediopiaAPIClient.AttendInfosMedi(user, e.getCourseId());
			obj1.add(attendInfos);
		}
		System.out.println("오브잭트사이즈" + obj1.size());
		System.out.println("오브잭트사이즈" + obj1.toString());
		for (int j = 0; j < obj1.size(); j++) {
			System.out.println("ForumRegList obj값 확인--------------------시작");
			System.out.println(obj1.get(j).toString());
			System.out.println("ForumRegList obj값 확인--------------------끝");
		}

		return attendInfos;
	}

	public List<AttendDtlInfos> MediAttendDtlInfosCreate(String email) {

		UserInfo user = MediUserInfoCreate(email);
		List<CrsInfo> srcInfo = MediCrsInfoCreate(email);

		List<AttendDtlInfos> attendDtlInfos = null;
		List<Object> obj1 = new ArrayList<>();
		for (CrsInfo e : srcInfo) {
			attendDtlInfos = mediopiaAPIClient.AttendDtlInfosMedi(user, e.getCourseId());
			obj1.add(attendDtlInfos);
		}
		System.out.println("오브잭트사이즈" + obj1.size());
		System.out.println("오브잭트사이즈" + obj1.toString());
		for (int j = 0; j < obj1.size(); j++) {
			System.out.println("ForumRegList obj값 확인--------------------시작");
			System.out.println(obj1.get(j).toString());
			System.out.println("ForumRegList obj값 확인--------------------끝");
		}
		return attendDtlInfos;
	}

	public List<MyEtestInfos> MediMyEtestInfosCreate(String email) {
		UserInfo userInfo = MediUserInfoCreate(email);
		List<MyEtestInfos> myEtestInfos = mediopiaAPIClient.MyEtestInfosMedi(userInfo);
		return myEtestInfos;
	}

	public List<EtestStatusList> MediEtestStatusListCreate(String email) {

		UserInfo userInfo = MediUserInfoCreate(email);
		List<MyEtestInfos> myEtestInfos = mediopiaAPIClient.MyEtestInfosMedi(userInfo);
		List<EtestStatusList> etestStatusList = null;
		
		List<Object> obj1 = new ArrayList<>();
		for (MyEtestInfos e : myEtestInfos) {
			etestStatusList = mediopiaAPIClient.EtestStatusListMedi(userInfo, e.getCourseId(),
					e.getEtestInfoId());
			obj1.add(etestStatusList);
		}
		System.out.println("오브잭트사이즈" + obj1.size());
		System.out.println("오브잭트사이즈" + obj1.toString());
		for (int j = 0; j < obj1.size(); j++) {
			System.out.println("ForumRegList obj값 확인--------------------시작");
			System.out.println(obj1.get(j).toString());
			System.out.println("ForumRegList obj값 확인--------------------끝");
		}

		return etestStatusList;
	}

	public List<MyResearchInfos> MediMyResearchInfosCreate(String email) {
		UserInfo userInfo = MediUserInfoCreate(email);
		List<MyResearchInfos> myResearchInfos = mediopiaAPIClient.MyResearchInfosMedi(userInfo);
		return myResearchInfos;

	}

	public List<ResearchAnswerList> MediResearchAnswerListCreate(String email) {

		UserInfo userInfo = MediUserInfoCreate(email);
		List<MyResearchInfos> myResearchInfos = mediopiaAPIClient.MyResearchInfosMedi(userInfo);
		List<ResearchAnswerList> researchAnswerList = null;
		//mediopiaAPIClient.ResearchAnswerListMedi(userInfo, crsInfo,myResearchInfos);
		List<Object> obj1 = new ArrayList<>();
		for (MyResearchInfos e : myResearchInfos) {
			researchAnswerList =mediopiaAPIClient.ResearchAnswerListMedi(userInfo, e.getCourseId(),e.getResearchInfoId());
			obj1.add(researchAnswerList);
		}
		System.out.println("오브잭트사이즈" + obj1.size());
		System.out.println("오브잭트사이즈" + obj1.toString());
		for (int j = 0; j < obj1.size(); j++) {
			System.out.println("ForumRegList obj값 확인--------------------시작");
			System.out.println(obj1.get(j).toString());
			System.out.println("ForumRegList obj값 확인--------------------끝");
		}

		
		return researchAnswerList;
	}

	public List<MyTeamactInfos> MedimyTeamactInfosCreate(String email) {
		UserInfo userInfo = MediUserInfoCreate(email);
		List<MyTeamactInfos> myTeamactInfos = mediopiaAPIClient.MyTeamactInfosMedi(userInfo);
		return myTeamactInfos;
	}

	public List<ScoreBaseInfos> MediScoreBaseInfosCreate(String email) {
		UserInfo userInfo = MediUserInfoCreate(email);
		List<CrsInfo> crsInfo = MediCrsInfoCreate(email);
		List<ScoreBaseInfos> scoreBaseInfos = null;
			
		List<Object> obj1 = new ArrayList<>();
		for(CrsInfo e: crsInfo) {
			scoreBaseInfos = mediopiaAPIClient.ScoreBaseInfosMedi(userInfo, e.getCourseId());
			obj1.add(scoreBaseInfos);
		}
		System.out.println("오브잭트사이즈" + obj1.size());
		System.out.println("오브잭트사이즈" + obj1.toString());
		for (int j = 0; j < obj1.size(); j++) {
			System.out.println("ForumRegList obj값 확인--------------------시작");
			System.out.println(obj1.get(j).toString());
			System.out.println("ForumRegList obj값 확인--------------------끝");
		}
		
		return scoreBaseInfos;
	}
	
	

	public List<TeamactOutputList> MediTeamactOutputListCreate(String email) {
		UserInfo userInfo = MediUserInfoCreate(email);
		List<MyTeamactInfos> myTeamactInfos = mediopiaAPIClient.MyTeamactInfosMedi(userInfo);
		List<TeamactOutputList> teamactOutputList = null; 
				//mediopiaAPIClient.TeamactOutputListMedi(userInfo, crsInfo,myTeamactInfos);
		List<Object> obj1 = new ArrayList<>();
		for (MyTeamactInfos e : myTeamactInfos) {
			teamactOutputList = mediopiaAPIClient.TeamactOutputListMedi(userInfo, e.getCourseId(),e.getTeamactId());
			obj1.add(teamactOutputList);
		}
		System.out.println("오브잭트사이즈" + obj1.size());
		System.out.println("오브잭트사이즈" + obj1.toString());
		for (int j = 0; j < obj1.size(); j++) {
			System.out.println("ForumRegList obj값 확인--------------------시작");
			System.out.println(obj1.get(j).toString());
			System.out.println("ForumRegList obj값 확인--------------------끝");
		}

		
		return teamactOutputList;
	}

	public List<ScoreInfos> MediScoreInfosCreate(String email) {
		UserInfo userInfo = MediUserInfoCreate(email);
		List<CrsInfo> crsInfo = MediCrsInfoCreate(email);
		List<ScoreInfos> scoreInfos = null;
		
		List<Object> obj1 = new ArrayList<>();
		for(CrsInfo e: crsInfo) {
			scoreInfos = mediopiaAPIClient.ScoreInfosMedi(userInfo, e.getCourseId());
			obj1.add(scoreInfos);
		}
		System.out.println("오브잭트사이즈" + obj1.size());
		System.out.println("오브잭트사이즈" + obj1.toString());
		for (int j = 0; j < obj1.size(); j++) {
			System.out.println("ForumRegList obj값 확인--------------------시작");
			System.out.println(obj1.get(j).toString());
			System.out.println("ForumRegList obj값 확인--------------------끝");
		}
		
		return scoreInfos;
	}

}
