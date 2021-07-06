package com.example.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MediAPI.MediopiaAPIClient;
import com.example.demo.mapper.second.SecondDAO;
import com.example.demo.model.GDFMessage;
import com.example.demo.model.LogModel;
import com.example.demo.model.Report;
import com.example.demo.model.TestModelMem;
import com.example.demo.model.UserInfo;
import com.example.demo.model.WebexMessageModel;
import com.example.demo.model.WebexMessageModelData;
import com.example.demo.service.GDFHandler;
import com.example.demo.service.TestService;
import com.example.demo.service.WebexServiceTest;

@RestController
public class TestController {
	// jackson 디펜던시 추가

	private final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	TestService testService;
	@Autowired
	GDFMessage gdfm;
	@Autowired
	private GDFHandler gdfh;
	@Autowired
	private MediopiaAPIClient medi;
	@Autowired
	WebexServiceTest webexServicetest;

	// @Autowired
	// TestModelMem testModelMem;

	// 리퀘스트맵핑 메소드 겟
	// 모델로 받음

	// /url 내부 바디로 오는경우 모델로 받기 가능
	@RequestMapping(value = "/createmeeting0", method = RequestMethod.GET)
	public void CreateMeeting(@RequestBody TestModelMem testModelMem) {

		int result = 0;

		System.out.println("Model==RequestMapping,Get===");
		System.out.println(testModelMem.getEmail());
		System.out.println(testModelMem.getPass());

		testService.CheckSelect(testModelMem.getEmail(), testModelMem.getPass());

	}

	@GetMapping(value = "/createmeeting1")
	public void CreateMeeting1(@RequestBody TestModelMem testModelMem) {

		System.out.println("Model====GetMapping====");

		System.out.println(testModelMem.getEmail());
		System.out.println(testModelMem.getPass());

	}

	@RequestMapping(value = "/createmeeting2", method = RequestMethod.POST)
	public void CreateMeeting2(@RequestBody TestModelMem testModelMem) {

		System.out.println("Model====RequestMapping,Post====");
		System.out.println(testModelMem.getEmail());
		System.out.println(testModelMem.getPass());
	}

	// 포스트맵핑 형식
	@PostMapping(value = "/createmeeting3")
	public void CreateMeeting33(@RequestBody TestModelMem testModelMem) {
		// postman url = 8080/createmeeting1 타입 포스트
		// Body 선택
		// Json 선택

		// 인스턴스화 시켜 만든건 출력안됨
		TestModelMem tmm = new TestModelMem();

		System.out.println(tmm.getEmail());
		System.out.println(tmm.getPass());

		System.out.println("Model====PostMapping====");

		// 오토와이어 주입시킨건 출력됨
		System.out.println(testModelMem.getEmail());
		System.out.println(testModelMem.getPass());

	}

	// 하나씩받기는 안됨
	// @PathVariable("email") 못받음
	// @RequestBody 못받음
	// @RequestParam 못받음
	// URL로 주는것만 하나씩 바인딩해서 받을수 있는거같음
	// /URL?email=jang&pass=1003
	@RequestMapping(value = "/createmeeting4", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void CreateMeeting4(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "pass", required = true) String pass) {
		System.out.println(email);
		System.out.println(pass);
	}

	@GetMapping(value = "/createmeeting5")
	public void CreateMeeting5(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "pass", required = true) String pass) {
		System.out.println(email);
		System.out.println(pass);
	}

	@RequestMapping(value = "/createmeeting6", method = RequestMethod.POST)
	public void CreateMeeting6(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "pass", required = true) String pass) {
		System.out.println(email);
		System.out.println(pass);
	}

	@PostMapping(value = "/createmeeting7")
	public void CreateMeeting7(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "pass", required = true) String pass) {
		System.out.println(email);
		System.out.println(pass);
	}

	@PostMapping(value = "/LogInsert")
	public void MsgBotMsgLog(@RequestBody LogModel lm) {

		System.out.println(lm.getMsg());
		System.out.println(lm.getPersonEmail());
		System.out.println(lm.getPersonId());
		System.out.println(lm.getSiteCd());
		System.out.println(lm.getMsgDate());
		System.out.println("date value null test");
		testService.Loginsert(lm);
		System.out.println(lm.getMsgDate());
	}

	@PostMapping(value = "/gdfMessage")
	public void GDFMessage(@RequestBody GDFMessage msg) {

		System.out.println(msg.getMessage());

		testService.gdfHandle(msg.getMessage());

	}

	@PostMapping(value = "/WebexMessage")
	public void WebexMessage(@RequestBody WebexMessageModel webmsg) {

//		WebexMessageModelData webmsgdata = new WebexMessageModelData();
//		
//		String botmail = "wsassigntest@webex.bot";
//		String checkmail = (String)webmsgdata.getPersonEmail();
//		System.out.println(checkmail);
//		if(botmail.equals(checkmail)) {return;} 	
//		
//		
//		System.out.println("getActorId: "+webmsg.getActorId());
//		System.out.println("getAppId: "+webmsg.getAppId());
//		System.out.println("getCreatedBy: "+webmsg.getCreatedBy());
//		System.out.println("getEvent: "+webmsg.getEvent());
//		System.out.println("getFilter: "+webmsg.getFilter());
//		System.out.println("getId: "+webmsg.getId());
//		System.out.println("getName: "+webmsg.getName());
//		System.out.println("getOrgId: "+webmsg.getOrgId());
//		System.out.println("getOwnedBy: "+webmsg.getOwnedBy());
//		System.out.println("getResource: "+webmsg.getResource());
//		System.out.println("getStatus: "+webmsg.getStatus());
//		System.out.println("getData: "+webmsg.getData());
//		System.out.println("ToString: "+webmsg.toString());
//
//		System.out.println("=========================================");
		webexServicetest.MessageSelect(webmsg.getData());

	}

	@PostMapping(value = "/WebexMessageAttachmentActions")
	public void WebexMessageAttachmentActions(@RequestBody GDFMessage msg) {

	}

	@RequestMapping(value = "/handlertest", method = RequestMethod.GET)
	public void handlertest(@Param("sitetype") String sitetype, @Param("searchkey") String searchkey) {

		System.out.println(sitetype);
		System.out.println(searchkey);

		testService.handlerslect(sitetype, searchkey);

	}

	@RequestMapping(value = "/TestMediAPI", method = RequestMethod.GET)
	public void TestMediAPIUserInfo(@Param("email") String email, @Param("message") String message) {
		System.out.println(email + message);
		testService.MainService(email, message);
	}
	
	@RequestMapping(value = "/crsInfo", method = RequestMethod.GET)
	public void TestMediAPIUserInfoCrsInfo(@Param("email") String email) {
		System.out.println(email);
		testService.CrsInfoSelect(email);
	}

	@RequestMapping(value = "/myReportInfos", method = RequestMethod.GET)
	public void TestMediAPIMyReportInfos(@Param("email") String email) {
		System.out.println(email);
		testService.ReportCreateService(email);
	}

	@RequestMapping(value = "/myTodoInfos", method = RequestMethod.GET)
	public void myTodoInfos(@Param("email") String email) {
		System.out.println(email);
		testService.myTodoInfosService(email);
	}
	
	@RequestMapping(value = "/crsTermInfos", method = RequestMethod.GET)
	public void crsTermInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.crsTermInfosService(email);
	}
	
	@RequestMapping(value = "/crsLessonTermInfos", method = RequestMethod.GET)
	public void crsLessonTermInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.crsLessonTermInfosService(email);
	}
	
	@RequestMapping(value = "/myForumInfos", method = RequestMethod.GET)
	public void myForumInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.myForumInfosService(email);
	}
	@RequestMapping(value = "/forumRegList", method = RequestMethod.GET)
	public void forumRegListController(@Param("email") String email) {
		System.out.println(email);
		testService.forumRegListService(email);
	}
	@RequestMapping(value = "/attendInfos", method = RequestMethod.GET)
	public void attendInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.attendInfosService(email);
	}
	@RequestMapping(value = "/attendDtlInfos", method = RequestMethod.GET)
	public void attendDtlInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.attendDtlInfosService(email);
	}
	@RequestMapping(value = "/myEtestInfos", method = RequestMethod.GET)
	public void myEtestInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.myEtestInfosService(email);
	}
	@RequestMapping(value = "/etestStatusList", method = RequestMethod.GET)
	public void etestStatusListgController(@Param("email") String email) {
		System.out.println(email);
		testService.etestStatusListService(email);
	}
	@RequestMapping(value = "/myResearchInfos", method = RequestMethod.GET)
	public void myResearchInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.myResearchInfosService(email);
	}
	@RequestMapping(value = "/researchAnswerList", method = RequestMethod.GET)
	public void researchAnswerListController(@Param("email") String email) {
		System.out.println(email);
		testService.researchAnswerListService(email);
	}
	@RequestMapping(value = "/myTeamactInfos", method = RequestMethod.GET)
	public void myTeamactInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.myTeamactInfosService(email);
	}

	@RequestMapping(value = "/teamactOutputList", method = RequestMethod.GET)
	public void teamactOutputListController(@Param("email") String email) {
		System.out.println(email);
		testService.teamactOutputListService(email);
	}

	@RequestMapping(value = "/scoreBaseInfos", method = RequestMethod.GET)
	public void scoreBaseInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.scoreBaseInfosService(email);
	}

	@RequestMapping(value = "/scoreInfos", method = RequestMethod.GET)
	public void scoreInfosController(@Param("email") String email) {
		System.out.println(email);
		testService.scoreInfosService(email);
	}
	
	@RequestMapping(value = "/testoutput", method = RequestMethod.GET)
	public void testoutput(@Param("email") String email) {
		System.out.println(email);
		testService.TestOutputService(email);
	}
	
	@RequestMapping(value = "/MediSiteDomainselect", method = RequestMethod.GET)
	public void MediSiteDomainselect(@Param("email") String email,@Param("SiteCD") String SiteCD) {
		System.out.println(email);
		System.out.println(SiteCD);
		testService.MedisiteDomainSelect(SiteCD, email);
	}
	
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public void MediUserinfo(@Param("email") String email,@Param("SiteCD") String SiteCD) {
		System.out.println(email);
		System.out.println(SiteCD);
		testService.Mediuserinfoselect(email);
	}
	
	
	@RequestMapping(value = "/URLSendTest", method = RequestMethod.GET)
	public void URLSendTest(@Param("email") String email,@Param("SiteCD") String SiteCD) {
		System.out.println(email);
		System.out.println(SiteCD);
		testService.TestURLService(email);
	}
	
	@RequestMapping(value = "/GdfTest", method = RequestMethod.GET)
	public void GdfTest(@Param("email") String email,@Param("SiteCD") String SiteCD) {
		System.out.println(email);
		System.out.println(SiteCD);
		int siteCD = Integer.parseInt(SiteCD);
		testService.TestGDFFService(email,siteCD);
	}
	
	
}
