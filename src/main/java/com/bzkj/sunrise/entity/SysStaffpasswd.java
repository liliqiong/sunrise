package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 *员工密码表
 *
 *保存加密后的员工密码信息
 */
public class SysStaffpasswd extends Model<SysStaffpasswd>{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String staffId;
	
	
	private String staffPasswd;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysStaffpasswd() {
	}

	/** minimal constructor */
	public SysStaffpasswd(String staffId) {
		this.staffId = staffId;
	}

	/** full constructor */
	public SysStaffpasswd(String staffId, String staffPasswd, Date updateTime,
			String updateStaffId, String updateDepartId) {
		this.staffId = staffId;
		this.staffPasswd = staffPasswd;
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

	public String getStaffPasswd() {
		return this.staffPasswd;
	}

	public void setStaffPasswd(String staffPasswd) {
		this.staffPasswd = staffPasswd;
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