package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 角色功能权限表
 */
public class SysRolefuncright extends Model<SysRolefuncright> {

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
	// Fields
	private String roleCode;
	private String rightCode;
	
	

	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysRolefuncright() {
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



	
	public String getRoleCode() {
		return roleCode;
	}



	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}



	public String getRightCode() {
		return rightCode;
	}



	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}



	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return id;
	}

}