package com.example.demo.interceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.common.ErrorStatus;


@Component
public class SQLInjectionInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(SQLInjectionInterceptor.class);
	
	private List<String> sqlKeywordList = Arrays.asList(
			"--",
			";--",
			";",
			"/*",
			"*/",
			"@@",
			//"@", --아이디가 이메일이라 뺌
			"char",
			"nchar",
			"varchar",
			"nvarchar",
			"alter",
			"begin",
			"cast",
			"create",
			"cursor",
			"declare",
			"delete",
			"drop",
			"end",
			"exec",
			"execute",
			"fetch",
			"insert",
			"kill",
			"select",
			"sys",
			"sysobjects",
			"syscolumns"
			);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Enumeration<String>enumName = request.getParameterNames();
		while(enumName.hasMoreElements()){
			
			String name  = enumName.nextElement();
			
			if (!checkSQLInjection(request.getParameter(name))) {
				errResponse(response, ErrorStatus.ILLEGAL_ACCESS, HttpServletResponse.SC_NOT_ACCEPTABLE);
				return false;
			}
		}		
		return true;
	}
	
	private boolean checkSQLInjection(String param) {
		
		for (String sql : this.sqlKeywordList) {
			if (param.contains(sql)) {
				log.info("PARAM HAVE SQL KEYWORD ==> {}", param);
				return false;
			}
		}		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private void errResponse(HttpServletResponse response, ErrorStatus errStatus, int status) throws IOException {
		
		JSONObject resJSON = new JSONObject();
		resJSON.put("valid", errStatus.getValid());
		resJSON.put("resultCode", errStatus.getErrCode());
		resJSON.put("errMsg", errStatus.getErrMsg());			
		
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.setStatus(status);
		response.setHeader("Access-Control-Allow-Origin", "*"); //이거 안넣으면 CORS에러남
		response.getWriter().write(resJSON.toJSONString());
		response.getWriter().flush();
		response.getWriter().close();
	}
	
}
