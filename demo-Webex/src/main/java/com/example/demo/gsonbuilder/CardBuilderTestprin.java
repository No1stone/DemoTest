package com.example.demo.gsonbuilder;

import java.net.URI;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.ciscospark.Message;
import com.example.demo.ciscospark.Spark;
import com.example.demo.model.CrsInfo;
import com.example.demo.service.webexhandle;
import com.google.gson.JsonArray;

public class CardBuilderTestprin {

	@Autowired
	private Spark spark;
	@Autowired
	private static	WebexHandler webexHandler;
	
	public static void main(String[] args) {
	
		Message msg = new Message();
		
		msg.setToPersonEmail("prof33@virtualcampus.kr");
		//msg.setToPersonEmail("jangkostlabtest0@gmail.com");
		msg.setText("원하시는 검색어를 눌러주세요");

			String crsname = "Test과목";
			String year = "2021";
			String term = "1학기";
			String sugang = "100명";
			String open = "2021.03.31";
			String close = "2021.06.15";
			String on = "10%";
			String off = "10%";
			String repo = "10%";
			String score = "3학점";		
			
			//String body = "과목: "+crsname+"\n년도: "+year+"\n학기: "+term;
			
			String CrsInfo = "<div>".concat("과목: ").concat(crsname)
					.concat("<br>").concat("년도: ").concat(year)
					.concat("<br>").concat("학기: ").concat(term)
					.concat("<br>").concat("수강생수: ").concat(sugang)
					.concat("<br>").concat("개강일: ").concat(open)
					.concat("<br>").concat("종강일: ").concat(close)
					.concat("<br>").concat("OnLine비율: ").concat(on)
					.concat("<br>").concat("OffLine비율: ").concat(off)
					.concat("<br>").concat("Report비율: ").concat(repo)
					.concat("<br>").concat("학점: ").concat(score)
					.concat("<div>")
					;
			
			String reportInfo = "<div>".concat("과목: ").concat(crsname)
					.concat("<br>").concat("과제: ").concat(year)
					.concat("<br>").concat("과제내용: ").concat(year)
					.concat("<br>").concat("제출기간: ").concat(year)
					.concat("<br>").concat("성적반영: ").concat(year)
					.concat("<br>").concat("성적공개: ").concat(year)
					.concat("<br>").concat("성적공개일자: ").concat(year)
					.concat("<br>").concat("연장제출: ").concat(year)
					.concat("<br>").concat("제출자: ").concat(year).concat("명")
					.concat("<br>").concat("미제출자: ").concat(year).concat("명")
					.concat("<br>").concat("연장제출자: ").concat(year).concat("명")
					.concat("<div>")
					;
			
			String application = "<div>".concat("수강신청시작일: ").concat(crsname)
					.concat("<br>").concat("수강신청종료일: ").concat(year)
					.concat("<br>").concat("수강정정시작일: ").concat(year)
					.concat("<br>").concat("수강정정종료일: ").concat(year)
					.concat("<div>")
					;
			
			String academic = "<div>".concat("강의시작일: ").concat(crsname)
					.concat("<br>").concat("강의종료일: ").concat(year)
					.concat("<div>")
					;
		
			String grade = "<div>".concat("성적처리 시작일: ").concat(crsname)
					.concat("<br>").concat("성적처리 종료일: ").concat(year)
					.concat("<div>")
					;
		
			
			String discussion = "<div>".concat("토론명: ").concat(crsname)
					.concat("<br>").concat("토론내용: ").concat(year)
					.concat("<br>").concat("토론시작일: ").concat(year)
					.concat("<br>").concat("토론종료일 :").concat(year)
					.concat("<br>").concat("성적반영: ").concat(year)
					.concat("<br>").concat("성적공개: ").concat(year)
					.concat("<br>").concat("성적공개일: ").concat(year)
					.concat("<div>")
					;
		
			String discussionSt = "<div>".concat("팀이름: ").concat(crsname)
					.concat("<br>").concat("사용자이름: ").concat(year)
					.concat("<br>").concat("등록글: ").concat(year).concat("개")
					.concat("<div>")
					;
			
			//교수전용 리스트
			String attendInfos= "<div>";
			
			//반복
			attendInfos.
			concat("<br>").concat("학습자: ").concat(year)
			.concat("<br>").concat("출석률: ").concat(year).concat("개");
			
			
			String exam = "<div>".concat("시험명: ").concat(crsname)
			.concat("<br>").concat("On/Off Line: ").concat(year)
			.concat("<div>")
			;
			
			
			//JsonArrayBuilder ja = Json.createArrayBuilder().add(WebexCardBuilder.SelectCardActionTextTitle("과목정보 검색 결과입니다."));
			//ja.add(WebexCardBuilder.SelectCardSendName(reportInfo));
			//javax.json.JsonArray attachments = WebexCardBuilder.SelectCardAttachments(WebexCardBuilder.SelectCardContents(ja));
			

		//msg.setAttachments(attachments);
		//System.out.println(attachments);
		//webexHandler.sendMessage(msg);
		
		Spark spark = Spark.builder().baseUrl(URI.create("https://webexapis.com/v1"))
				.accessToken("YjFiYTVhZGEtZjVkMC00YTJmLTkwYzUtNGI3YzY3YWIwNjZiNTgwNjU1ODctNTVj_PF84_ca8e1346-99fa-49c1-897f-03b7eaa9450d")
		.build();
		
		//msg.setAttachments(attachments);
		msg.setMarkdown(attendInfos);
		spark.messages().post(msg);
		

		
		}
}


