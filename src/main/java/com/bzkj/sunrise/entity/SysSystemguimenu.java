package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;
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
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((classLevel == null) ? 0 : classLevel.hashCode());
		result = prime * result
				+ ((displayMode == null) ? 0 : displayMode.hashCode());
		result = prime * result
				+ ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result
				+ ((menuText == null) ? 0 : menuText.hashCode());
		result = prime * result
				+ ((menuTitle == null) ? 0 : menuTitle.hashCode());
		result = prime * result
				+ ((parentMenuId == null) ? 0 : parentMenuId.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result
				+ ((rightCode == null) ? 0 : rightCode.hashCode());
		result = prime * result
				+ ((shortKey == null) ? 0 : shortKey.hashCode());
		result = prime * result
				+ ((showOrder == null) ? 0 : showOrder.hashCode());
		result = prime * result
				+ ((sysSubsys == null) ? 0 : sysSubsys.hashCode());
		result = prime * result
				+ ((updateDepartId == null) ? 0 : updateDepartId.hashCode());
		result = prime * result
				+ ((updateStaffId == null) ? 0 : updateStaffId.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysSystemguimenu other = (SysSystemguimenu) obj;
		if (classLevel == null) {
			if (other.classLevel != null)
				return false;
		} else if (!classLevel.equals(other.classLevel))
			return false;
		if (displayMode == null) {
			if (other.displayMode != null)
				return false;
		} else if (!displayMode.equals(other.displayMode))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		if (menuText == null) {
			if (other.menuText != null)
				return false;
		} else if (!menuText.equals(other.menuText))
			return false;
		if (menuTitle == null) {
			if (other.menuTitle != null)
				return false;
		} else if (!menuTitle.equals(other.menuTitle))
			return false;
		if (parentMenuId == null) {
			if (other.parentMenuId != null)
				return false;
		} else if (!parentMenuId.equals(other.parentMenuId))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (rightCode == null) {
			if (other.rightCode != null)
				return false;
		} else if (!rightCode.equals(other.rightCode))
			return false;
		if (shortKey == null) {
			if (other.shortKey != null)
				return false;
		} else if (!shortKey.equals(other.shortKey))
			return false;
		if (showOrder == null) {
			if (other.showOrder != null)
				return false;
		} else if (!showOrder.equals(other.showOrder))
			return false;
		if (sysSubsys == null) {
			if (other.sysSubsys != null)
				return false;
		} else if (!sysSubsys.equals(other.sysSubsys))
			return false;
		if (updateDepartId == null) {
			if (other.updateDepartId != null)
				return false;
		} else if (!updateDepartId.equals(other.updateDepartId))
			return false;
		if (updateStaffId == null) {
			if (other.updateStaffId != null)
				return false;
		} else if (!updateStaffId.equals(other.updateStaffId))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}


	
	

}