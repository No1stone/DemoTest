package com.example.demo.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.MediAPI.MediBaseAPICreater;
import com.example.demo.MediAPI.MediopiaAPIClient;
import com.example.demo.ciscospark.Message;
import com.example.demo.ciscospark.Spark;
import com.example.demo.common.util.DateUtils;
import com.example.demo.gsonbuilder.WebexHandler;
import com.example.demo.mapper.first.TestDAO;
import com.example.demo.mapper.second.SecondDAO;
import com.example.demo.mapper.third.ThirdDAO;
import com.example.demo.model.AttendDtlInfos;
import com.example.demo.model.AttendInfos;
import com.example.demo.model.BotList;
import com.example.demo.model.CrsInfo;
import com.example.demo.model.CrsLessonTermInfos;
import com.example.demo.model.CrsTermInfos;
import com.example.demo.model.EtestStatusList;
import com.example.demo.model.ForumRegList;
import com.example.demo.model.LogModel;
import com.example.demo.model.MyEtestInfos;
import com.example.demo.model.MyForumInfos;
import com.example.demo.model.MyResearchInfos;
import com.example.demo.model.MyTeamactInfos;
import com.example.demo.model.Report;
import com.example.demo.model.ResearchAnswerList;
import com.example.demo.model.ScoreBaseInfos;
import com.example.demo.model.ScoreInfos;
import com.example.demo.model.SiteDomain;
import com.example.demo.model.TeamactOutputList;
import com.example.demo.model.TestBind;
import com.example.demo.model.TodoInfos;
import com.example.demo.model.UserInfo;
import com.example.demo.model.chatbotdbhandler;
import com.google.cloud.dialogflow.v2.QueryResult;

import GsonBuilder.MesimpleBuilder;
import enumTestCode.DefineCode;
import enumTestCode.DefineCode.CommonService;

@Service
@Transactional
public class TestService {
	private final Logger logger = LoggerFactory.getLogger(TestService.class);
	@Autowired
	private TestDAO testDAO;

	@Autowired
	private SecondDAO secondDAO;

	@Autowired
	private ThirdDAO thirdDAO;

	@Autowired
	private DateUtils DU;

	@Autowired
	private LogModel logModel;
	@Autowired
	private MediopiaAPIClient mediopiaAPIClient;
	@Autowired
	private GDFHandler gdfh;

	@Autowired
	private ComponentClass cc;
	
	@Autowired
	private MediBaseAPICreater mediBaseAPICreater;

	@Autowired
	private Spark spark;
	@Autowired
	private static	WebexHandler webexHandler;
	
	/*
	 * @Autowired private TestBind testbind;
	 */

	
	

	public QueryResult gdfHandle(String message) {
		int sitecd = 1;
		QueryResult queryResult = gdfh.detectIntentTexts(message, sitecd);
		System.out.println(queryResult.getIntent());
		System.out.println(queryResult.getQueryText());
		System.out.println(queryResult.toString());
		return queryResult;
	}

	public void Loginsert(LogModel lm) {
		System.out.println("LogInsert clear service part");
		Date now = new Date();
		// DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// format.format(now);
		// lm.setMsgDate(now);
		lm.setMsgDate(DU.dateToString(now, "yyyy-MM-dd HH:mm:ss"));
		System.out.println("format date print");
		System.out.println(lm.getMsg());
		System.out.println(lm.getPersonEmail());
		System.out.println(lm.getPersonId());
		System.out.println(lm.getSiteCd());
		System.out.println(lm.getMsgDate());
		System.out.println("print end");
		testDAO.Loginsert(lm.getSiteCd(), lm.getPersonId(), lm.getPersonEmail(), lm.getMsg(), lm.getMsgDate());
		// return testDAO.Loginsert(5, "123", "345", "567");
	}
	public void MainService(String email, String message) {

		QueryResult queryResult = cc.gdfHandle(message);
		UserInfo user = cc.UserInfoSelect(email);
		List<CrsInfo> crs = cc.CrsInfoSelect(email);
		ChatbotHandler cahtbotHandler = ChatbotHandler.builder().queryResult(queryResult).userInfo(user).build();

		System.out.println("chatbotService Value");
		System.out.println("==========================================");
		System.out.println(cahtbotHandler);
		System.out.println("user Value");
		System.out.println(user.toString());
		System.out.println("queryResult Value");
		System.out.println(queryResult.toString());
		System.out.println("Crs value");
		System.out.println(crs.toString());
	}

	public String CheckSelect(String email, String pass) {
		System.out.println("testService print");
		System.out.println(email + pass);
		TestBind testbind = testDAO.CheckSelect(email, pass);
		if (testbind != null) {
			String result = "1";
			System.out.println(result);
			System.out.println("====testbind print start====");
			testbind.setEmail(email);
			testbind.setPass(pass);
			System.out.println(testbind.getEmail());
			System.out.println(testbind.getPass());
			System.out.println("====testbind print end====");
			return result;
		}
		return "";
	}

	public void handlerslect(String type, String key) {
		System.out.println(String.format("값 확인: %s %s", type, key));
		CommonService DefineComm = DefineCode.CommonService.FUNCTION_SEARCH;
		// 카드에 셋팅될 라인 이름과 세팅될 데이터
		// if(DefineComm.service().substring(0,8).equals("function")) {
		if (key.substring(0, 8).equals("function")) {
			System.out.println("서브스트링 검색됨");
			List<chatbotdbhandler> db = new ArrayList<chatbotdbhandler>();
			db.addAll(testDAO.chatbothandleSelect(type, key));
			JsonArrayBuilder ja = Json.createArrayBuilder()
					.add(MesimpleBuilder.SelectCardActionTextTitle("원하시는 검색어를 눌러주세요"));
			for (chatbotdbhandler e : db) {
				ja.add(MesimpleBuilder.SelectCardActionName(e.getReturnbot(), e.getReturnkey()));
			}
			JsonArray cardattchmen = MesimpleBuilder.SelectCardAttachments(MesimpleBuilder.SelectCardContents(ja));
			System.out.println(cardattchmen);
		}
	}

	public void UserInfoSelect(String Email) {
		System.out.println("서비스앞");
		UserInfo user = secondDAO.findUserByPersonEmail(Email);
		System.out.println("서비스뒤");
		System.out.println(user.getPersonId());
		System.out.println(user.toString());
		List<Report> reports = mediopiaAPIClient.requestCourseByProfessor(user);
		for (Report re : reports) {
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println(re.toString());
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println("=============================");
		}
	}

	public void CrsInfoSelect(String Email) {
		System.out.println("서비스앞");
		UserInfo user = secondDAO.findUserByPersonEmail(Email);
		System.out.println("서비스뒤");
		System.out.println(user.getPersonId());
		System.out.println(user.toString());
		List<CrsInfo> crsInfo = mediopiaAPIClient.requestCrsInfo(user);
		for (CrsInfo crs : crsInfo) {
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println(crs.toString());
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println("=============================");
		}
	}

	public void myTodoInfosService(String Email) {
		System.out.println("서비스앞");
		UserInfo user = secondDAO.findUserByPersonEmail(Email);
		System.out.println("서비스뒤");
		System.out.println(user.getPersonId());
		System.out.println(user.toString());
		List<TodoInfos> TodoInfos = mediopiaAPIClient.MyTodoInfosMedi(user);
		for (TodoInfos todo : TodoInfos) {
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println(todo.toString());
			System.out.println("=============================");
			System.out.println("=============================");
			System.out.println("=============================");
		}
	}
	
	public void CrsTermInfosService(String Email) {
		List<CrsTermInfos> crsTermInfos = mediBaseAPICreater.MediCrsTermInfosCreate(Email) ;
		System.out.println("재대로 종료됫는지 확인");
	}

	public void crsTermInfosService(String email) {
		List<CrsTermInfos> crsTermInfos = mediBaseAPICreater.MediCrsTermInfosCreate(email);
		System.out.println("=============================");
		System.out.println(crsTermInfos.toString());
		System.out.println("=============================");
		
	}

	public void crsLessonTermInfosService(String email) {
	
		List<CrsLessonTermInfos> crsLessonTermInfos = mediBaseAPICreater.MediCrsLessonTermInfosCreate(email);
		System.out.println("=============================");
		System.out.println(crsLessonTermInfos.toString());
		System.out.println("=============================");
		
	}

	public void myForumInfosService(String email) {
		
		List<MyForumInfos> myForumInfos = mediBaseAPICreater.MediMyForumInfosCreate(email);
		System.out.println("=============================");
		System.out.println(myForumInfos.toString());
		System.out.println("=============================");
		
	}

	public void forumRegListService(String email) {
		List<ForumRegList> forumRegList = mediBaseAPICreater.MediForumRegListcreate(email);
		System.out.println("=============================");
		System.out.println(forumRegList.toString());
		System.out.println("=============================");
		
	}

	public void attendInfosService(String email) {
		List<AttendInfos> attendInfos = mediBaseAPICreater.MediAttendInfosCreate(email);
		System.out.println("=============================");
		System.out.println(attendInfos.toString());
		System.out.println("=============================");
	}

	public void attendDtlInfosService(String email) {
		List<AttendDtlInfos> attendDtlInfos = mediBaseAPICreater.MediAttendDtlInfosCreate(email);
		System.out.println("=============================");
		System.out.println(attendDtlInfos.toString());
		System.out.println("=============================");
	}

	public void myEtestInfosService(String email) {
		List<MyEtestInfos> myEtestInfos = mediBaseAPICreater.MediMyEtestInfosCreate(email);
		System.out.println("=============================");
		System.out.println(myEtestInfos.toString());
		System.out.println("=============================");
	}

	public void etestStatusListService(String email) {
		List<EtestStatusList> etestStatusList = mediBaseAPICreater.MediEtestStatusListCreate(email);
		System.out.println("=============================");
		System.out.println(etestStatusList.toString());
		System.out.println("=============================");
	}

	public void myResearchInfosService(String email) {
		List<MyResearchInfos> myResearchInfos = mediBaseAPICreater.MediMyResearchInfosCreate(email);
		System.out.println("=============================");
		System.out.println(myResearchInfos.toString());
		System.out.println("=============================");
	}

	public void researchAnswerListService(String email) {
	List<ResearchAnswerList> researchAnswerList = mediBaseAPICreater.MediResearchAnswerListCreate(email);
	System.out.println("=============================");
	System.out.println(researchAnswerList.toString());
	System.out.println("=============================");
	}

	public void myTeamactInfosService(String email) {
	List<MyTeamactInfos> myTeamactInfos = mediBaseAPICreater.MedimyTeamactInfosCreate(email);
	System.out.println("=============================");
	System.out.println(myTeamactInfos.toString());
	System.out.println("=============================");
	}

	public void teamactOutputListService(String email) {
	List<TeamactOutputList> teamactOutputList = mediBaseAPICreater.MediTeamactOutputListCreate(email);
	System.out.println("=============================");
	System.out.println(teamactOutputList.toString());
	System.out.println("=============================");
	}

	public void scoreBaseInfosService(String email) {
		List<ScoreBaseInfos> scoreBaseInfos = mediBaseAPICreater.MediScoreBaseInfosCreate(email);
		System.out.println("=============================");
		System.out.println(scoreBaseInfos.toString());
		System.out.println("=============================");
	}

	public void scoreInfosService(String email) {
		List<ScoreInfos> scoreInfos = mediBaseAPICreater.MediScoreInfosCreate(email);
		System.out.println("=============================");
		System.out.println(scoreInfos.toString());
		System.out.println("=============================");
	}

	public void ReportCreateService(String email) {
		List<Report> scoreInfos = mediBaseAPICreater.MediReportCreate(email);
		System.out.println("=============================");
		System.out.println(scoreInfos.toString());
		System.out.println("=============================");
	}
	
	
	
	
	public void TestOutputService(String email) {
		
		List<CrsInfo>srcinfo = mediBaseAPICreater.MediCrsInfoCreate(email);
		Message msg = new Message();
		msg.setToPersonEmail("prof33@virtualcampus.kr");
		//msg.setToPersonEmail("jangkostlabtest0@gmail.com");
		
		
		msg.setText("원하시는 검색어를 눌러주세요");
		String crsInfost="과목정보 검색 결과입니다<br>"; 
		System.out.println("crsInfo -{}"+srcinfo.toString());
		System.out.println("crsInfoSize -{}"+srcinfo.size());
		StringBuffer sb = new StringBuffer();
		sb.append(crsInfost);
		for (CrsInfo e : srcinfo) {
			sb.append(String.format("<div>과목: %s",e.getCourseName()));
			sb.append(String.format("<br>년도: %s",e.getHaksaYear()));
			sb.append(String.format("<br>학기: %s",e.getCourseTermName()));
			sb.append(String.format("<br>수강생수: %s",e.getLearnerCount()));
			sb.append(String.format("<br>개강일: %s",e.getLearningStartDate()));
			sb.append(String.format("<br>종강일: %s",e.getLearningEndDate()));
			sb.append(String.format("<br>OnLine비율: %s",e.getOnlineRate()));
			sb.append(String.format("<br>OffLine비율: %s",e.getOfflineRate()));
			sb.append(String.format("<br>Report비율: %s",e.getOfflineRate()));
			sb.append(String.format("<br>학점: %s",e.getCredit()));
			sb.append("<br><br><div>");
		}
		msg.setMarkdown(sb.toString());
		Spark spark = Spark.builder().baseUrl(URI.create("https://webexapis.com/v1"))
				.accessToken("NWZkNWI0MjktODc2Ny00YmJkLWE0YzUtMTIzMTAzNDU2NDIxODBkMjVhOGEtY2Rj_PF84_ca8e1346-99fa-49c1-897f-03b7eaa9450d")
		.build();
		spark.messages().post(msg);		
	}
	
	public void MedisiteDomainSelect(String SiteCD, String email) {
		System.out.println(SiteCD);
		System.out.println("parseint");
		System.out.println(Integer.parseInt(SiteCD));
		
		SiteDomain sitedomain = secondDAO.findSiteDomain(Integer.parseInt(SiteCD));
		BotList botList = thirdDAO.findBotlist(Integer.parseInt(SiteCD));
		System.out.println(sitedomain.toString());
		
		List<CrsInfo>srcinfo = mediBaseAPICreater.MediCrsInfoCreate(email);
		Message msg = new Message();
		msg.setToPersonEmail("prof33@virtualcampus.kr");
		//msg.setToPersonEmail("jangkostlabtest0@gmail.com");
		
		
		msg.setText("원하시는 검색어를 눌러주세요");
		String crsInfost="과목정보 검색 결과입니다<br>"; 
		System.out.println("crsInfo -{}"+srcinfo.toString());
		System.out.println("crsInfoSize -{}"+srcinfo.size());
		StringBuffer sb = new StringBuffer();
		sb.append(crsInfost);
		for (CrsInfo e : srcinfo) {
			sb.append(String.format("<div>과목: %s",e.getCourseName()));
			sb.append(String.format("<br>년도: %s",e.getHaksaYear()));
			sb.append(String.format("<br>학기: %s",e.getCourseTermName()));
			sb.append(String.format("<br>수강생수: %s",e.getLearnerCount()));
			sb.append(String.format("<br>개강일: %s",e.getLearningStartDate()));
			sb.append(String.format("<br>종강일: %s",e.getLearningEndDate()));
			sb.append(String.format("<br>OnLine비율: %s",e.getOnlineRate()));
			sb.append(String.format("<br>OffLine비율: %s",e.getOfflineRate()));
			sb.append(String.format("<br>Report비율: %s",e.getOfflineRate()));
			sb.append(String.format("<br>학점: %s",e.getCredit()));
			sb.append("<br><br><div>");
		}
		msg.setMarkdown(sb.toString());
		UserInfo user = secondDAO.findUserByPersonEmail(email);
		
		Spark selectspark = SiteSelectSpark(user);
		
		selectspark.messages().post(msg);	
		
	}
	
	public Spark SiteSelectSpark(UserInfo userinfo) {
		BotList botacc = thirdDAO.findBotlist(14);
		//BotList botacc = thirdDAO.findBotlist(userinfo.getSiteCd());
		Spark spark = Spark.builder()
				.baseUrl(URI.create("https://webexapis.com/v1"))
				.accessToken(botacc.getBotAccToken())
				.build();
		System.out.println(spark);
		return spark;
	}
	
	
	public void Mediuserinfoselect(String email) {

		UserInfo userInfo = secondDAO.findUserByPersonEmail(email);
		
		System.out.println(userInfo.toString());

	}
	
	
	public void TestURLService(String email) {
		
		Message msg = new Message();
		msg.setToPersonEmail("prof33@virtualcampus.kr");
		msg.setText("원하시는 검색어를 눌러주세요");
		
		JsonArrayBuilder ja = Json.createArrayBuilder()
				.add(MesimpleBuilder.SelectCardActionTextTitle("원하시는 검색어를 눌러주세요"));
			ja.add(MesimpleBuilder.SelectCardURL("네이버","https://www.naver.com"));
		JsonArray cardattchmen = MesimpleBuilder.SelectCardAttachments(MesimpleBuilder.SelectCardContents(ja));
	
		msg.setAttachments(cardattchmen);
		Spark spark = Spark.builder().baseUrl(URI.create("https://webexapis.com/v1"))
				.accessToken("NWZkNWI0MjktODc2Ny00YmJkLWE0YzUtMTIzMTAzNDU2NDIxODBkMjVhOGEtY2Rj_PF84_ca8e1346-99fa-49c1-897f-03b7eaa9450d")
		.build();
		spark.messages().post(msg);		
	}

	public void TestGDFFService(String email, int SiteCD) {
		System.out.println("Massage: "+email);
		System.out.println("SiteCD: "+SiteCD);
		QueryResult queryResult = gdfh.detectIntentTexts(email, SiteCD);
		
		System.out.println("queryResult: "+ queryResult.toString());
		
	}
	
}
