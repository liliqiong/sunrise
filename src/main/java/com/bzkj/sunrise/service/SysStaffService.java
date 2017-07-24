package com.bzkj.sunrise.service;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bzkj.sunrise.dao.SysCurrentTokenDao;
import com.bzkj.sunrise.dao.SysStaffDao;
import com.bzkj.sunrise.dao.SysStaffdatetimeDao;
import com.bzkj.sunrise.entity.SysCurrentToken;
import com.bzkj.sunrise.entity.SysStaff;


@Service
@ConfigurationProperties(prefix="selfProperties")
public class SysStaffService {

	@Autowired
	SysStaffDao sysStaffDao;
	
	@Autowired
	SysCurrentTokenDao sysCurrentTokenDao;
	@Autowired
	SysStaffdatetimeDao sysStaffdatetimeDao;

	@Autowired
	ConfigPropertiesService configPropertiesService;
    @Resource(name = "redisTemplate")
    ValueOperations<String, SysStaff> staffOps;
    @Resource(name = "redisTemplate")
    ValueOperations<String, SysCurrentToken> tokenOps;
	

	
	/**
	 * 通过员工ID，email,电话号码之一和密码验证当前用户是否有效
	 * @param id
	 * @param passwd
	 * @return
	 */
	public SysStaff verifyStaff(String id,String passwd){
		SysStaff staff=null;
		String[] params=new String[]{"staff_id","email","serial_number"};
		for (String param : params) {
			staff=sysStaffDao.findByParam(param, id);
			if(staff!=null){
				break;
			}
		}
		//TODO  密码加密解密
		if (staff!=null && passwd.equals(staff.getStaffPasswd())){
			return staff;
		}else{
			return null;
		}		
	}
	
	/**
	 * 验证当前用户是否已经登录
	 * 
	 */
	public SysCurrentToken verifyLogin(String staffId){
		return sysCurrentTokenDao.findByStaffId(staffId);
	}
	


	/**
	 * 根据员工ID和登录IP建立一个token
	 * @param staffId
	 * @param requestIp
	 * @return
	 */
	@Transactional
	public SysCurrentToken createToken(String staffId,String requestIp){
		//先清除对应staffId下之前使用过的token
		sysCurrentTokenDao.deleteByStaffId(staffId);
		//新建一个token默认有效时间30分钟
		SysCurrentToken sct=new SysCurrentToken();
		sct.setStaffId(staffId);
		sct.setToken(UUID.randomUUID().toString());
		sct.setExpirationTime(new Date(System.currentTimeMillis()+configPropertiesService.getTokenExpirationTime()*60*1000));
		sct.setRequestIp(requestIp);
		sysCurrentTokenDao.insert(sct);
		return sct;
	}
	
	/**
	 * 验证当前token是否有效
	 * @param token
	 * @param ip
	 * @return
	 */
	@Transactional
	public SysCurrentToken verifyToken(String token,String ip){
		//从redis获取
		SysCurrentToken sct =tokenOps.get(token+"_"+ip);
		if(sct!=null){
			return sct;
		}
		sct= sysCurrentTokenDao.findByToken(token, ip);
		if(sct==null){
			return null;
		}
		sct.setExpirationTime(new Date(System.currentTimeMillis()+configPropertiesService.getTokenExpirationTime()*60*1000));
		//跟新token有效时间
		System.out.println(sct);
		sysCurrentTokenDao.updateOne(sct);
		tokenOps.set(token+"_"+ip, sct, configPropertiesService.getTokenExpirationTime(), TimeUnit.MINUTES);
		return sct;
	}
	
	
}
