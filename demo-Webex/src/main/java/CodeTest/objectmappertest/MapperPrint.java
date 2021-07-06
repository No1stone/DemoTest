package CodeTest.objectmappertest;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperPrint {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub

		UserVO userVO = new UserVO();
		MobileVO mobileVO = new MobileVO();
		TelVO telVO = new TelVO();
		
		mobileVO.setMobile1("010");
		mobileVO.setMobile2("1111");
		mobileVO.setMobile3("2222");
		
		telVO.setTel1("02");
		telVO.setTel2("1111");
		telVO.setTel3("2222");
		
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		Map<String, Object> telMap = new HashMap<String, Object>();
		
		mobileMap.put("MOBILE", mobileVO);
		telMap.put("TEL", mobileVO);
		
		userVO.setId("USERID");
		userVO.setName("USERNAME");
		userVO.setMobile(mobileMap);
		userVO.setTel(telMap);
		
		ObjectMapper mapper = new ObjectMapper();
		String mapperwriteValueAsString = mapper.writeValueAsString(userVO);
		UserVO mapperconvertValue = mapper.convertValue(userVO, UserVO.class);
		//String mpperr = mapper.;
		
		System.out.println(mapperwriteValueAsString);
		System.out.println(mapper.writeValueAsString(mapperconvertValue));
		
	}
	
}
