package com.bzh.colud.sunrise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.bzh.cloud"})
@MapperScan(basePackages = "com.bzh.cloud.dao.sunrise")
public class SunRiseApplication {
		
	public static void main(String[] args) {		
		
		SpringApplication.run(SunRiseApplication.class, args);		 
	}
}
