package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * 模块编码表
 */
public class SysModfile extends Model<SysModfile>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	//模块编码：子系统编码＋三位序列
	private String modCode;
	//唯一
	private String modName;
	//库文件类型：0－GUI的DLL文件，1－WEB地址
	private String modType;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysModfile() {
	}

	/** minimal constructor */
	public SysModfile(String modCode, String modName, String modType) {
		this.modCode = modCode;
		this.modName = modName;
		this.modType = modType;
	}

	/** full constructor */
	public SysModfile(String modCode, String modName, String modType,
			String remark, Date updateTime, String updateStaffId,
			String updateDepartId) {
		this.modCode = modCode;
		this.modName = modName;
		this.modType = modType;
		this.remark = remark;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
	}

	// Property accessors

	public String getModCode() {
		return this.modCode;
	}

	public void setModCode(String modCode) {
		this.modCode = modCode;
	}

	public String getModName() {
		return this.modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getModType() {
		return this.modType;
	}

	public void setModType(String modType) {
		this.modType = modType;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysModfile))
			return false;
		SysModfile castOther = (SysModfile) other;

		return ((this.getModCode() == castOther.getModCode()) || (this
				.getModCode() != null && castOther.getModCode() != null && this
				.getModCode().equals(castOther.getModCode())))
				&& ((this.getModName() == castOther.getModName()) || (this
						.getModName() != null && castOther.getModName() != null && this
						.getModName().equals(castOther.getModName())))
				&& ((this.getModType() == castOther.getModType()) || (this
						.getModType() != null && castOther.getModType() != null && this
						.getModType().equals(castOther.getModType())))
				&& ((this.getRemark() == castOther.getRemark()) || (this
						.getRemark() != null && castOther.getRemark() != null && this
						.getRemark().equals(castOther.getRemark())))
				&& ((this.getUpdateTime() == castOther.getUpdateTime()) || (this
						.getUpdateTime() != null
						&& castOther.getUpdateTime() != null && this
						.getUpdateTime().equals(castOther.getUpdateTime())))
				&& ((this.getUpdateStaffId() == castOther.getUpdateStaffId()) || (this
						.getUpdateStaffId() != null
						&& castOther.getUpdateStaffId() != null && this
						.getUpdateStaffId()
						.equals(castOther.getUpdateStaffId())))
				&& ((this.getUpdateDepartId() == castOther.getUpdateDepartId()) || (this
						.getUpdateDepartId() != null
						&& castOther.getUpdateDepartId() != null && this
						.getUpdateDepartId().equals(
								castOther.getUpdateDepartId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getModCode() == null ? 0 : this.getModCode().hashCode());
		result = 37 * result
				+ (getModName() == null ? 0 : this.getModName().hashCode());
		result = 37 * result
				+ (getModType() == null ? 0 : this.getModType().hashCode());
		result = 37 * result
				+ (getRemark() == null ? 0 : this.getRemark().hashCode());
		result = 37
				* result
				+ (getUpdateTime() == null ? 0 : this.getUpdateTime()
						.hashCode());
		result = 37
				* result
				+ (getUpdateStaffId() == null ? 0 : this.getUpdateStaffId()
						.hashCode());
		result = 37
				* result
				+ (getUpdateDepartId() == null ? 0 : this.getUpdateDepartId()
						.hashCode());
		return result;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

}