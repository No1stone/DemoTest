package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.example.demo.mapper.*")
public class DemoWebexApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebexApplication.class, args);
	}

}
