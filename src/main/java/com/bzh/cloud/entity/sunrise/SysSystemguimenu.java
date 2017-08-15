package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

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
	@TableId
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	// Fields
	//菜单项标识：默认为“子系统编码＋四位序列
	private String menuId;
	private String subsysCode;
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
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getSubsysCode() {
		return subsysCode;
	}
	public void setSubsysCode(String subsysCode) {
		this.subsysCode = subsysCode;
	}
	public String getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public String getMenuTitle() {
		return menuTitle;
	}
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	public String getMenuText() {
		return menuText;
	}
	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}
	public Integer getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(Integer classLevel) {
		this.classLevel = classLevel;
	}
	public String getDisplayMode() {
		return displayMode;
	}
	public void setDisplayMode(String displayMode) {
		this.displayMode = displayMode;
	}
	public String getRightCode() {
		return rightCode;
	}
	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}
	public String getShortKey() {
		return shortKey;
	}
	public void setShortKey(String shortKey) {
		this.shortKey = shortKey;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateStaffId() {
		return updateStaffId;
	}
	public void setUpdateStaffId(String updateStaffId) {
		this.updateStaffId = updateStaffId;
	}
	public String getUpdateDepartId() {
		return updateDepartId;
	}
	public void setUpdateDepartId(String updateDepartId) {
		this.updateDepartId = updateDepartId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((classLevel == null) ? 0 : classLevel.hashCode());
		result = prime * result
				+ ((displayMode == null) ? 0 : displayMode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
				+ ((subsysCode == null) ? 0 : subsysCode.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (subsysCode == null) {
			if (other.subsysCode != null)
				return false;
		} else if (!subsysCode.equals(other.subsysCode))
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
	@Override
	protected Serializable pkVal() {
		return id;
	}
	@Override
	public String toString() {
		return "SysSystemguimenu [id=" + id + ", menuId=" + menuId
				+ ", subsysCode=" + subsysCode + ", parentMenuId="
				+ parentMenuId + ", menuTitle=" + menuTitle + ", menuText="
				+ menuText + ", imageUrl=" + imageUrl + ", showOrder="
				+ showOrder + ", classLevel=" + classLevel + ", displayMode="
				+ displayMode + ", rightCode=" + rightCode + ", shortKey="
				+ shortKey + ", remark=" + remark + ", updateTime="
				+ updateTime + ", updateStaffId=" + updateStaffId
				+ ", updateDepartId=" + updateDepartId + "]";
	}

	
	

	


	
	

}