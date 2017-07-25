package com.bzh.colud.sunrise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
@ComponentScan(basePackages={"com.bzkj.sunrise"})
@MapperScan(basePackages = "com.bzkj.sunrise.dao")
public class SunRiseApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(SunRiseApplication.class, args);
		
	 
	}
}
