package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 子系统参数表
 * 
 * 保存云平台所有子系统编码信息
 */
public class SysSubsys extends Model<SysSubsys> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableId
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String subsysCode;
	private String subsysName;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;
	private Set<SysSystemguimenu> sysSystemguimenus = new HashSet<SysSystemguimenu>(0);

	// Constructors

	/** default constructor */
	public SysSubsys() {
	}

	/** minimal constructor */
	public SysSubsys(String subsysCode) {
		this.subsysCode = subsysCode;
	}

	/** full constructor */
	public SysSubsys(String subsysCode, String subsysName, String remark,
			Date updateTime, String updateStaffId, String updateDepartId,
			Set<SysSystemguimenu> sysSystemguimenus) {
		this.subsysCode = subsysCode;
		this.subsysName = subsysName;
		this.remark = remark;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
		this.sysSystemguimenus = sysSystemguimenus;
	}

	// Property accessors
	public String getSubsysCode() {
		return this.subsysCode;
	}

	public void setSubsysCode(String subsysCode) {
		this.subsysCode = subsysCode;
	}

	public String getSubsysName() {
		return this.subsysName;
	}

	public void setSubsysName(String subsysName) {
		this.subsysName = subsysName;
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

	public Set<SysSystemguimenu> getSysSystemguimenus() {
		return this.sysSystemguimenus;
	}

	public void setSysSystemguimenus(Set<SysSystemguimenu> sysSystemguimenus) {
		this.sysSystemguimenus = sysSystemguimenus;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return id;
	}

}