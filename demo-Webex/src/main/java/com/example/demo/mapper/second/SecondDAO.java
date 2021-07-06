package com.example.demo.mapper.second;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.SiteDomain;
import com.example.demo.model.UserInfo;

@Mapper
public interface SecondDAO {
	public UserInfo findUserByPersonEmail(@Param("personEmail") String personEmail);
	public SiteDomain findSiteDomain(@Param("SiteCD") int SiteCD);
}
