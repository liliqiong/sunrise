package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

public class SysCurrentToken extends Model<SysCurrentToken>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SysCurrentToken() {
		// TODO Auto-generated constructor stub
	}
	
	private String token;
	private String staffId;
	private Date expirationTime;
	private String requestIp;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public Date getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return token;
	}
	public String getRequestIp() {
		return requestIp;
	}
	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}
	@Override
	public String toString() {
		return "SysCurrentToken [token=" + token + ", staffId=" + staffId
				+ ", expirationTime=" + expirationTime + ", requestIp="
				+ requestIp + "]";
	}

	
	
	
	

}
