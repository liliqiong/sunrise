package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * 菜单定制隐藏显示
 * 屏蔽员工相关菜单
 */
public class SysHidemenuitem extends Model<SysHidemenuitem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 复合ID
	private String staffId;
	private String menuId;
	private String departId;
	
	
	private SysSystemguimenu sysSystemguimenu;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysHidemenuitem() {
	}



	/** full constructor */


	// Property accessors


	public SysSystemguimenu getSysSystemguimenu() {
		return this.sysSystemguimenu;
	}

	public void setSysSystemguimenu(SysSystemguimenu sysSystemguimenu) {
		this.sysSystemguimenu = sysSystemguimenu;
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



	public String getStaffId() {
		return staffId;
	}



	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}



	public String getMenuId() {
		return menuId;
	}



	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}



	public String getDepartId() {
		return departId;
	}



	public void setDepartId(String departId) {
		this.departId = departId;
	}



	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

}