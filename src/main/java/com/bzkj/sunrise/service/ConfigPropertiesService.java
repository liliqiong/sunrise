package com.bzkj.sunrise.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;


@Service
@ConfigurationProperties(prefix="selfProperties")
public class ConfigPropertiesService {
	
	private Long tokenExpirationTime;	
	public void setTokenExpirationTime(Long tokenExpirationTime) {
		this.tokenExpirationTime = tokenExpirationTime;
	}
	public Long getTokenExpirationTime(){
		return tokenExpirationTime;
	}

}
