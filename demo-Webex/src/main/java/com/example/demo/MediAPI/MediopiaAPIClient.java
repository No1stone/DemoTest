package com.example.demo.MediAPI;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.common.util.AES256Util;
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
import com.google.gson.Gson;

@Component
public class MediopiaAPIClient {
	private final Logger logger = LoggerFactory.getLogger(MediopiaAPIClient.class);
	@Autowired
	private RestTemplate restTemplate;

	@Value("${mediopia.base.url}")
	private String mediopiaBaseUrl;

	@Value("${mediopia.secret.key}")
	private String secretKey;
	private AES256Util aes256;

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

	@PostConstruct
	public void init() {
		try {
			this.aes256 = new AES256Util(secretKey);
		} catch (UnsupportedEncodingException ue) {
			ue.printStackTrace();
			this.aes256 = null;
		}
	}

	private String encryptData(UserInfo userInfo) {
		if (userInfo == null)
			return null;

		String encrypt = null;
		try {
			String data = String.format("%d;%s;%s", userInfo.getSiteCd(), userInfo.getUserId(),
					dateFormat.format(System.currentTimeMillis()));
//            String data = String.format("%d;%s;%s", 5, "prof1", dateFormat.format(System.currentTimeMillis()));
			encrypt = aes256.aesEncode(data);
		} catch (Exception ex) {
			ex.printStackTrace();
			encrypt = null;
		}
		return encrypt;
	}
	//과제리스트 
	public List<Report> requestCourseByProfessor(UserInfo userInfo) {
		return requestCourseByProfessor(null, userInfo);
	}
	//과제리스트
	public List<Report> requestCourseByProfessor(String filter, UserInfo userInfo) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "myReportInfos");
		if (StringUtils.isEmpty(filter) == false) {
			builder.queryParam("filter", filter);
		}
		UriComponents uriComponents = builder.build();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);

//        HttpEntity<String> httpRes = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;
		if ("200".equals(jsonObject.getString("resultCd")) == false)
			return null;

		JSONArray array = jsonObject.getJSONArray("list");

		List<Report> reports = null;
		if (ObjectUtils.isEmpty(array) == false) {
			reports = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				Report report = gson.fromJson(array.get(i).toString(), Report.class);
				reports.add(report);
			}
		}
		return reports;
	}
	//과제제출자
	public List<Submitter> requestSubmitterByProfessor(String submitStatus, UserInfo userInfo, ActionItem item) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "reportSubmitList").queryParam("courseId", item.getCourseId())
				.queryParam("reportInfoId", item.getReportInfoId()).queryParam("submitStatus", submitStatus).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		JSONArray array = jsonObject.getJSONArray("list");

		List<Submitter> submitters = null;
		if (ObjectUtils.isEmpty(array) == false) {
			submitters = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				Submitter submitter = gson.fromJson(array.get(i).toString(), Submitter.class);
				submitters.add(submitter);
			}
		}
		return submitters;
	}
	//과제제출자
	public Submitter requestReportSubmitStatus(String submitStatus, UserInfo userInfo, ActionItem item) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "reportSubmitList").queryParam("courseId", item.getCourseId())
				.queryParam("reportInfoId", item.getReportInfoId()).queryParam("submitStatus", submitStatus)
				.queryParam("filter", String.format("userId==%s", userInfo.getUserId())).build();

		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		logger.info("jsonObject : {}", jsonObject.toString());

		JSONArray array = jsonObject.getJSONArray("list");
		if (ObjectUtils.isEmpty(array) || array.length() > 1)
			return null;

		logger.info("array : {}", array.toString());
		Submitter submitter = null;

		if (ObjectUtils.isEmpty(array) == false) {
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				submitter = gson.fromJson(array.get(i).toString(), Submitter.class);
				if (submitter != null)
					break;
			}
		}
		return submitter;
	}
	//몰입도체크
	public String requestAttendance(boolean isCorrect, ActionItem item) {
		UserInfo userInfo = new UserInfo();
		userInfo.setSiteCd(Integer.valueOf(item.getSiteCd()));
		userInfo.setUserId(item.getUserId());

		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "chkAnswer").queryParam("lessonElementId", item.getLessonElementId())
				.queryParam("lessonQuestionId", item.getQuestion().getId())
				.queryParam("answerYn", isCorrect ? "Y" : "N").build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		return jsonObject.getString("resultCd");
	}
	//코스정보
	public List<CrsInfo> requestCrsInfo(UserInfo userInfo) {
		return requestCrsInfo(null, userInfo);
	}
	//코스정보
	public List<CrsInfo> requestCrsInfo(String filter, UserInfo userInfo) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		// URL주소가 다르다 co.kr이다
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme("http").host("lms6.edutrack.co.kr")
				.path("/Api.do").queryParam("cmd", "myCrsInfos");
		if (StringUtils.isEmpty(filter) == false) {
			builder.queryParam("filter", filter);
		}
		UriComponents uriComponents = builder.build();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);

//        HttpEntity<String> httpRes = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;
		if ("200".equals(jsonObject.getString("resultCd")) == false)
			return null;

		JSONArray array = jsonObject.getJSONArray("list");

		List<CrsInfo> CrsInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			CrsInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				CrsInfo crsInfo = gson.fromJson(array.get(i).toString(), CrsInfo.class);
				CrsInfos.add(crsInfo);
			}
		}
		return CrsInfos;
	}
	//학기정보
	public List<CrsTermInfos> CrsTermInfosMedi(UserInfo user, String courseTermId) {
		UserInfo userInfo = new UserInfo();
		userInfo.setSiteCd(Integer.valueOf(user.getSiteCd()));
		userInfo.setUserId(user.getUserId());

		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "crsTermInfos")
				.queryParam("courseTermId", courseTermId).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		System.out.println("URL값"+uriComponents.toUriString());
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject)) {
			System.out.println("반환오브젝트가 널임");
			return null;
		}
		JSONArray array = jsonObject.getJSONArray("list");

		List<CrsTermInfos> CrsTermInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			CrsTermInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				CrsTermInfos CrsTermInfo = gson.fromJson(array.get(i).toString(), CrsTermInfos.class);
				CrsTermInfos.add(CrsTermInfo);
			}
		}
		return CrsTermInfos;
	}
	// 투두리스트
	public List<TodoInfos> MyTodoInfosMedi(UserInfo userInfo) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);

		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "myTodoInfos");

		UriComponents uriComponents = builder.build();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);

//        HttpEntity<String> httpRes = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;
		if ("200".equals(jsonObject.getString("resultCd")) == false)
			return null;

		JSONArray array = jsonObject.getJSONArray("list");

		List<TodoInfos> todoInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			todoInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				TodoInfos todoInfo = gson.fromJson(array.get(i).toString(), TodoInfos.class);
				todoInfos.add(todoInfo);
			}
		}
		else if(ObjectUtils.isEmpty(array) == true) {
			System.out.println("data is null");
		}
		return todoInfos;
	}
	
	//학기아이디를 받음
	public List<CrsLessonTermInfos> CrsLessonTermInfosMedi(UserInfo userInfo, String courseTermId) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "crsLessonTermInfos")
				.queryParam("courseTermId", courseTermId).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
	
		System.out.println("URL값"+uriComponents.toUriString());
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject)) {
			System.out.println("반환오브젝트가 널임");
			return null;
		}
		JSONArray array = jsonObject.getJSONArray("list");

		List<CrsLessonTermInfos> crsLessonTermInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			crsLessonTermInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				CrsLessonTermInfos CrsLessonTermInfo = gson.fromJson(array.get(i).toString(), CrsLessonTermInfos.class);
				crsLessonTermInfos.add(CrsLessonTermInfo);
			}
		}
		return crsLessonTermInfos;
		
	}


	public List<MyForumInfos> MyForumInfosMedi(UserInfo userInfo) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "myForumInfos");
		UriComponents uriComponents = builder.build();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);

//        HttpEntity<String> httpRes = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;
		if ("200".equals(jsonObject.getString("resultCd")) == false)
			return null;

		JSONArray array = jsonObject.getJSONArray("list");

		List<MyForumInfos> myForumInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			myForumInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				MyForumInfos MyForumInfo = gson.fromJson(array.get(i).toString(), MyForumInfos.class);
				myForumInfos.add(MyForumInfo);
			}
		}
		return myForumInfos;
	}


	public List<ForumRegList> ForumRegListMedi(UserInfo userInfo,String myForumInfos,String crsInfo) {
		
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "forumRegList")
				.queryParam("forumInfoId", myForumInfos)
				.queryParam("courseId", crsInfo).build();
				//.queryParam("forumStatus", crsTermInfos.get(0).getCourseTermId()).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		logger.info("jsonObject : {}", jsonObject.toString());

		System.out.println("ForumRegListMedi제이손오브잭트 투스트링"+jsonObject.toString());
		
		JSONArray array = jsonObject.getJSONArray("list");

		logger.info("array : {}", array.toString());

		List<ForumRegList> forumRegLists = null;
		if (ObjectUtils.isEmpty(array) == false) {
			forumRegLists = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				ForumRegList forumRegList = gson.fromJson(array.get(i).toString(), ForumRegList.class);
				forumRegLists.add(forumRegList);
				System.out.println("forumRegList data 확인========="+forumRegList);
			}
		}
		

		return forumRegLists;
		
	}


	public List<AttendInfos> AttendInfosMedi(UserInfo userInfo, String crsInfo) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "attendInfos")
				.queryParam("courseId", crsInfo).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		logger.info("jsonObject : {}", jsonObject.toString());

		JSONArray array = jsonObject.getJSONArray("list");
	

		logger.info("array : {}", array.toString());
	
		List<AttendInfos> attendInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			attendInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				AttendInfos attendInfo = gson.fromJson(array.get(i).toString(), AttendInfos.class);
				attendInfos.add(attendInfo);
			}
		}
		return attendInfos;
		}


	public List<AttendDtlInfos> AttendDtlInfosMedi(UserInfo userInfo, String crsInfo) {
		
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "attendDtlInfos")
				.queryParam("courseId", crsInfo).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		logger.info("jsonObject : {}", jsonObject.toString());

		JSONArray array = jsonObject.getJSONArray("list");
		if (ObjectUtils.isEmpty(array) || array.length() > 1)
			return null;

		logger.info("array : {}", array.toString());
	
		List<AttendDtlInfos> attendDtlInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			attendDtlInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				AttendDtlInfos attendDtlInfo = gson.fromJson(array.get(i).toString(), AttendDtlInfos.class);
				attendDtlInfos.add(attendDtlInfo);
			}
		}
		return attendDtlInfos;
		
	}


	public List<MyEtestInfos> MyEtestInfosMedi(UserInfo userInfo) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "myEtestInfos");
		UriComponents uriComponents = builder.build();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);

//        HttpEntity<String> httpRes = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;
		if ("200".equals(jsonObject.getString("resultCd")) == false)
			return null;

		JSONArray array = jsonObject.getJSONArray("list");

		List<MyEtestInfos> myEtestInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			myEtestInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				MyEtestInfos MyEtestInfo = gson.fromJson(array.get(i).toString(), MyEtestInfos.class);
				myEtestInfos.add(MyEtestInfo);
			}
		}
		return myEtestInfos;
	
	}


	public List<EtestStatusList> EtestStatusListMedi(UserInfo userInfo,String crsInfo,String myEtestInfos) {
		
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "etestStatusList")
				.queryParam("etestInfoId", myEtestInfos)
				.queryParam("courseId", crsInfo).build();
		System.out.println("URI 투스트링!!!!"+uriComponents.toUriString());
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		

		
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		logger.info("jsonObject : {}", jsonObject.toString());

		JSONArray array = jsonObject.getJSONArray("list");
	

		logger.info("array : {}", array.toString());
	
		List<EtestStatusList> etestStatusLists = null;
		if (ObjectUtils.isEmpty(array) == false) {
			etestStatusLists = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				EtestStatusList attendDtlInfo = gson.fromJson(array.get(i).toString(), EtestStatusList.class);
				etestStatusLists.add(attendDtlInfo);
			}
		}
		return etestStatusLists;
	}


	public List<MyResearchInfos> MyResearchInfosMedi(UserInfo userInfo) {
		
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "myResearchInfos");
		UriComponents uriComponents = builder.build();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);

//        HttpEntity<String> httpRes = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;
		if ("200".equals(jsonObject.getString("resultCd")) == false)
			return null;

		JSONArray array = jsonObject.getJSONArray("list");

		List<MyResearchInfos> myResearchInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			myResearchInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				MyResearchInfos MyResearchInfo = gson.fromJson(array.get(i).toString(), MyResearchInfos.class);
				myResearchInfos.add(MyResearchInfo);
			}
		}
		return myResearchInfos;
	
	}


	public List<ResearchAnswerList> ResearchAnswerListMedi(UserInfo userInfo,String crsInfo,String myResearchInfos) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "researchAnswerList")
				.queryParam("researchInfoId", myResearchInfos)
				.queryParam("courseId", crsInfo).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		logger.info("jsonObject : {}", jsonObject.toString());

		JSONArray array = jsonObject.getJSONArray("list");

		logger.info("array : {}", array.toString());
	
		List<ResearchAnswerList> researchAnswerLists = null;
		if (ObjectUtils.isEmpty(array) == false) {
			researchAnswerLists = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				ResearchAnswerList researchAnswerList = gson.fromJson(array.get(i).toString(), ResearchAnswerList.class);
				researchAnswerLists.add(researchAnswerList);
			}
		}
		return researchAnswerLists;}


	public List<MyTeamactInfos> MyTeamactInfosMedi(UserInfo userInfo) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "myTeamactInfos");
		UriComponents uriComponents = builder.build();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);

//        HttpEntity<String> httpRes = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;
		if ("200".equals(jsonObject.getString("resultCd")) == false)
			return null;

		JSONArray array = jsonObject.getJSONArray("list");

		List<MyTeamactInfos> myTeamactInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			myTeamactInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				MyTeamactInfos myTeamactInfo = gson.fromJson(array.get(i).toString(), MyTeamactInfos.class);
				myTeamactInfos.add(myTeamactInfo);
			}
		}
		return myTeamactInfos;
	}

	public List<TeamactOutputList> TeamactOutputListMedi(UserInfo userInfo,String crsInfo,String myTeamactInfos) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "teamactOutputList")
				.queryParam("teamactId", myTeamactInfos)
				.queryParam("courseId", crsInfo).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		logger.info("jsonObject : {}", jsonObject.toString());

		JSONArray array = jsonObject.getJSONArray("list");


		logger.info("array : {}", array.toString());
	
		List<TeamactOutputList> teamactOutputLists = null;
		if (ObjectUtils.isEmpty(array) == false) {
			teamactOutputLists = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				TeamactOutputList teamactOutputList = gson.fromJson(array.get(i).toString(), TeamactOutputList.class);
				teamactOutputLists.add(teamactOutputList);
			}
		}
		return teamactOutputLists;
		
	}
		

	public List<ScoreBaseInfos> ScoreBaseInfosMedi(UserInfo userInfo,String crsInfo) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "scoreBaseInfos")
				.queryParam("courseId", crsInfo).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		logger.info("jsonObject : {}", jsonObject.toString());

		JSONArray array = jsonObject.getJSONArray("list");
	

		logger.info("array : {}", array.toString());
	
		List<ScoreBaseInfos> attendDtlInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			attendDtlInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				ScoreBaseInfos attendDtlInfo = gson.fromJson(array.get(i).toString(), ScoreBaseInfos.class);
				attendDtlInfos.add(attendDtlInfo);
			}
		}
		return attendDtlInfos;
	}


	public List<ScoreInfos> ScoreInfosMedi(UserInfo userInfo,String crsInfo) {
		String accessToken = encryptData(userInfo);
		if (accessToken == null)
			return null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("AuthToken", accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(mediopiaBaseUrl)
				.path("/Api.do").queryParam("cmd", "scoreInfos")
				.queryParam("courseId", crsInfo).build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity,
				String.class);
		JSONObject obj = new JSONObject(response.getBody());
		JSONObject jsonObject = obj.getJSONObject("result");
		if (ObjectUtils.isEmpty(jsonObject))
			return null;

		logger.info("jsonObject : {}", jsonObject.toString());

		JSONArray array = jsonObject.getJSONArray("list");

		logger.info("array : {}", array.toString());
	
		List<ScoreInfos> ScoreInfos = null;
		if (ObjectUtils.isEmpty(array) == false) {
			ScoreInfos = new ArrayList<>();
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) {
				ScoreInfos ScoreInfo = gson.fromJson(array.get(i).toString(), ScoreInfos.class);
				ScoreInfos.add(ScoreInfo);
			}
		}
		return ScoreInfos;
	}

}
