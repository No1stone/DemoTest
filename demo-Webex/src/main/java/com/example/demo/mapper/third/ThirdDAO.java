package com.example.demo.mapper.third;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.BotList;
@Mapper
public interface ThirdDAO {
	BotList findBotlist(@Param("SiteCD") int SiteCD);
}
