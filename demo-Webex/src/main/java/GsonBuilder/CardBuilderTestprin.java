package GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.ciscospark.Message;
import com.example.demo.ciscospark.Spark;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class CardBuilderTestprin {

	@Autowired
	private Spark spark;
	
	public static void main(String[] args) {
	
		
		//맵 이터레이터
		Map<String,String> Vo = new HashMap<>();
		Vo.put("data","data1");
		Vo.put("data","data2");		
		List<Object> selectActions = new ArrayList<Object>();		
		Iterator<String> voit = Vo.keySet().iterator();
		while(voit.hasNext()) {
			String key = voit.next();
		}
		
		
		List<String> FunctionText = new ArrayList<String>();
		FunctionText.add("과제");
		FunctionText.add("퀴즈");
		FunctionText.add("일정");
		FunctionText.add("팀활동");
		FunctionText.add("중간고사");
		FunctionText.add("성적");
		
		Iterator<String> iter = FunctionText.iterator();
		
		//카드이펙트 맨위 설명줄
		//셋팅될 라인(셀렉트액션)보다 위에 냅둬야해서 선언하면서 값을 셋팅
		//셀렉트액션은 add로 검색된 크기만큼 추가
		JsonArrayBuilder ja = Json.createArrayBuilder().add(MesimpleBuilder.SelectCardActionTextTitle("원하시는 검색어를 눌러주세요"));
				
		//카드에 셋팅될 라인 이름과 세팅될 데이터
		while(iter.hasNext()) {
		ja.add(MesimpleBuilder.SelectCardActionName(String.format("스트링 포멧 테스트: %s", iter.next()), "DATATEST"));
		}
	
		javax.json.JsonArray cardattchmen = MesimpleBuilder.SelectCardAttachments(MesimpleBuilder.SelectCardContents(ja));
				
		System.out.println(cardattchmen);
	
	}
}


