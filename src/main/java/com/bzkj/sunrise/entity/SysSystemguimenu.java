package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * 系统GUI菜单表
 * 
 * 保存云平台所有GUI菜单信息
 */
public class SysSystemguimenu extends Model<SysSystemguimenu> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	//菜单项标识：默认为“子系统编码＋四位序列
	private String menuId;
	private SysSubsys sysSubsys;
	private String parentMenuId;
	private String menuTitle;
	private String menuText;
	private String imageUrl;
	private Integer showOrder;
	private Integer classLevel;
	private String displayMode;
	private String rightCode;
	private String shortKey;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;
	private Set<SysHidemenuitem> sysHidemenuitems = new HashSet<SysHidemenuitem>(0);

	// Constructors

	/** default constructor */
	public SysSystemguimenu() {
	}

	/** minimal constructor */
	public SysSystemguimenu(String menuId, SysSubsys sysSubsys) {
		this.menuId = menuId;
		this.sysSubsys = sysSubsys;
	}

	/** full constructor */
	public SysSystemguimenu(String menuId, SysSubsys sysSubsys,
			String parentMenuId, String menuTitle, String menuText,
			String imageUrl, Integer showOrder, Integer classLevel,
			String displayMode, String rightCode, String shortKey,
			String remark, Date updateTime, String updateStaffId,
			String updateDepartId, Set<SysHidemenuitem> sysHidemenuitems) {
		this.menuId = menuId;
		this.sysSubsys = sysSubsys;
		this.parentMenuId = parentMenuId;
		this.menuTitle = menuTitle;
		this.menuText = menuText;
		this.imageUrl = imageUrl;
		this.showOrder = showOrder;
		this.classLevel = classLevel;
		this.displayMode = displayMode;
		this.rightCode = rightCode;
		this.shortKey = shortKey;
		this.remark = remark;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
		this.sysHidemenuitems = sysHidemenuitems;
	}

	// Property accessors
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public SysSubsys getSysSubsys() {
		return this.sysSubsys;
	}

	public void setSysSubsys(SysSubsys sysSubsys) {
		this.sysSubsys = sysSubsys;
	}

	public String getParentMenuId() {
		return this.parentMenuId;
	}

	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public String getMenuTitle() {
		return this.menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getMenuText() {
		return this.menuText;
	}

	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getShowOrder() {
		return this.showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public Integer getClassLevel() {
		return this.classLevel;
	}

	public void setClassLevel(Integer classLevel) {
		this.classLevel = classLevel;
	}

	public String getDisplayMode() {
		return this.displayMode;
	}

	public void setDisplayMode(String displayMode) {
		this.displayMode = displayMode;
	}

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getShortKey() {
		return this.shortKey;
	}

	public void setShortKey(String shortKey) {
		this.shortKey = shortKey;
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

	public Set<SysHidemenuitem> getSysHidemenuitems() {
		return this.sysHidemenuitems;
	}

	public void setSysHidemenuitems(Set<SysHidemenuitem> sysHidemenuitems) {
		this.sysHidemenuitems = sysHidemenuitems;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return menuId;
	}

	@Override
	public String toString() {
		return "SysSystemguimenu [menuId=" + menuId + ", sysSubsys="
				+ sysSubsys + ", parentMenuId=" + parentMenuId + ", menuTitle="
				+ menuTitle + ", menuText=" + menuText + ", imageUrl="
				+ imageUrl + ", showOrder=" + showOrder + ", classLevel="
				+ classLevel + ", displayMode=" + displayMode + ", rightCode="
				+ rightCode + ", shortKey=" + shortKey + ", remark=" + remark
				+ ", updateTime=" + updateTime + ", updateStaffId="
				+ updateStaffId + ", updateDepartId=" + updateDepartId
				+ ", sysHidemenuitems=" + sysHidemenuitems + "]";
	}
	
	

}