package com.bzkj.sunrise.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzkj.sunrise.dao.SysStaffdatetimeDao;
import com.bzkj.sunrise.dao.SysStafftermipaddrDao;
import com.bzkj.sunrise.entity.SysStafftermipaddr;

/**
 * 
 * @author syu
 * 处理IP限制登录
 * 时间段限制登录
 * 业务逻辑
 */
@Service
public class LoginLimitService {

	
	@Autowired
	SysStafftermipaddrDao sysStafftermipaddrDao;
	
	@Autowired
	SysStaffdatetimeDao sysStaffdatetimeDao;
	
	/**
	 * 通过员工登录IP限制表限制
	 * true 为通过
	 */
	public boolean verifyIpLimit(String staffId,String requestIp){
		SysStafftermipaddr check=sysStafftermipaddrDao.findByStaffId(staffId);
		if(check==null){
			return true;
		}
		if("0".equals(check.getSysTag())){
			//黑名单
			return !ipIn(check.getIpStart(),check.getIpEnd(),requestIp);
		}else{
			//白名单
			return ipIn(check.getIpStart(),check.getIpEnd(),requestIp);
		}
	}
	/**
	 * 登录时间限制
	 * true 为通过
	 */
	public boolean verifyTimeLimit(String staffId){		
		return sysStaffdatetimeDao.checkTimeLimit(staffId)>0?false:true;
	}
	
	private boolean ipIn(String start,String end,String ip){
		int[] startArr=getGroup(start);
		int[] endArr=getGroup(end);
		int[] ipArr=getGroup(ip);
		for (int i = 0; i <4; i++) {
			if(startArr[i]>ipArr[i] || endArr[i]<ipArr[i]){
				return false;
			}
		}
		return true;
	}
	
	private int[] getGroup(String match){
		int[] arr=new int[4];
		String exp="(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
		Matcher m=Pattern.compile(exp).matcher(match);
		m.find();
		for (int i = 1; i <= arr.length; i++) {
			arr[i-1]=Integer.valueOf(m.group(i));
		}
		return arr;
	}
}
