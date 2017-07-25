package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * 角色编码表
 * 保存角色编码参数信息
 *
 */
public class SysRole extends Model<SysRole>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	//角色编码
	private String roleCode;
	private String roleName;
	//'角色属性：0－功能权限角色，1－资源数据权限角色，2－数据特权角色 可扩展',
	private String roleAttr;
	private String remark;
	
	//'有效0 ；无效1
	private String validflag;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;



	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(String roleCode, String roleAttr, String validflag) {
		this.roleCode = roleCode;
		this.roleAttr = roleAttr;
		this.validflag = validflag;
	}

	/** full constructor */
	public SysRole(String roleCode, String roleName, String roleAttr,
			String remark, String validflag, Date updateTime,
			String updateStaffId, String updateDepartId) {
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.roleAttr = roleAttr;
		this.remark = remark;
		this.validflag = validflag;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
	}

	// Property accessors
	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleAttr() {
		return this.roleAttr;
	}

	public void setRoleAttr(String roleAttr) {
		this.roleAttr = roleAttr;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValidflag() {
		return this.validflag;
	}

	public void setValidflag(String validflag) {
		this.validflag = validflag;
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