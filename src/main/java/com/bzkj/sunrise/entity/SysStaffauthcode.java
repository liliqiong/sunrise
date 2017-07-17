package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * 员工授权码表
 * 
 * 员工授权码管理
 */
public class SysStaffauthcode extends Model<SysStaffauthcode> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	//员工编码
	private String staffId;
	//授权码
	private String webPasswd;
	private Date strData;
	private Date endData;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysStaffauthcode() {
	}

	/** minimal constructor */
	public SysStaffauthcode(String staffId, String webPasswd, Date strData,
			Date endData) {
		this.staffId = staffId;
		this.webPasswd = webPasswd;
		this.strData = strData;
		this.endData = endData;
	}

	/** full constructor */
	public SysStaffauthcode(String staffId, String webPasswd, Date strData,
			Date endData, String remark, Date updateTime, String updateStaffId,
			String updateDepartId) {
		this.staffId = staffId;
		this.webPasswd = webPasswd;
		this.strData = strData;
		this.endData = endData;
		this.remark = remark;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
	}

	// Property accessors
	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getWebPasswd() {
		return this.webPasswd;
	}

	public void setWebPasswd(String webPasswd) {
		this.webPasswd = webPasswd;
	}

	public Date getStrData() {
		return this.strData;
	}

	public void setStrData(Date strData) {
		this.strData = strData;
	}

	public Date getEndData() {
		return this.endData;
	}

	public void setEndData(Date endData) {
		this.endData = endData;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateStaffId() {
		return this.updateStaffId;
	}

	public void setUpdateStaffId(String updateStaffId) {
		this.updateStaffId = updateStaffId;
	}

	public String getUpdateDepartId() {
		return this.updateDepartId;
	}

	public void setUpdateDepartId(String updateDepartId) {
		this.updateDepartId = updateDepartId;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

}