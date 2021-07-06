package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.MediAPI.MediopiaAPIClient;
import com.example.demo.common.util.DateUtils;
import com.example.demo.mapper.first.TestDAO;
import com.example.demo.mapper.second.SecondDAO;
import com.example.demo.model.CrsInfo;
import com.example.demo.model.LogModel;
import com.example.demo.model.Report;
import com.example.demo.model.UserInfo;
import com.google.cloud.dialogflow.v2.QueryResult;

@Component
public class ComponentClass {

	@Autowired
	private TestDAO testDAO;
	@Autowired
	private SecondDAO secondDAO;
	@Autowired
	private DateUtils DU;
	@Autowired
	private LogModel logModel;
    @Autowired
    private MediopiaAPIClient mediopiaAPIClient;	
    @Autowired
	private GDFHandler gdfh;

	
	public UserInfo UserInfoSelect(String Email) {
	
		UserInfo user = secondDAO.findUserByPersonEmail(Email);
	
		 List<Report> reports = mediopiaAPIClient.requestCourseByProfessor(user);
		 for(Report re : reports) {			 
			 System.out.println(re.toString());
		 }
	return user;
	}
	public List<CrsInfo> CrsInfoSelect(String Email) {
		UserInfo user = secondDAO.findUserByPersonEmail(Email);
		 List<CrsInfo> crsInfo = mediopiaAPIClient.requestCrsInfo(user);
		 for(CrsInfo crs : crsInfo) {			 
			 System.out.println(crs.toString());
		 }
		return crsInfo;
	}
	public QueryResult gdfHandle(String message) {
		QueryResult queryResult = gdfh.detectIntentTexts(message,1);
		System.out.println(queryResult.getIntent());
		System.out.println(queryResult.getQueryText());
		System.out.println(queryResult.toString());
		return queryResult;
	}
	
	public void Loginsert(LogModel lm) {
		System.out.println("LogInsert clear service part");
		Date now = new Date();
		//DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//format.format(now);
		//lm.setMsgDate(now);
		lm.setMsgDate(DU.dateToString(now, "yyyy-MM-dd HH:mm:ss"));
		System.out.println("format date print");
		System.out.println(lm.getMsg());
		System.out.println(lm.getPersonEmail());
		System.out.println(lm.getPersonId());
		System.out.println(lm.getSiteCd());
		System.out.println(lm.getMsgDate());
		System.out.println("print end");
		testDAO.Loginsert(lm.getSiteCd(), lm.getPersonId(), lm.getPersonEmail(), lm.getMsg(),lm.getMsgDate());
		//return testDAO.Loginsert(5, "123", "345", "567");
	}
}
