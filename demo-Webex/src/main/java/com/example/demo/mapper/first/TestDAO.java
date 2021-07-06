package com.example.demo.mapper.first;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.TestBind;
import com.example.demo.model.UserInfo;
import com.example.demo.model.chatbotdbhandler;

@Mapper
public interface TestDAO {

	
	//@Select("Select * from meetingmem where email = #{email} and pass = #{pass}" )
	//String CheckSelect(@Param("email")String email, @Param("pass")String pass);
	TestBind CheckSelect(String email, String pass);
	
	void Loginsert(int siteCd, String personId, String personEmail, String msg, String msgDate);
	List<chatbotdbhandler> chatbothandleSelect(String siteType, String searchKey);

}
