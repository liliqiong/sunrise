package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * 
 * 系统分类编码参数表
 * 
 * 保存权限分类编码参数信息
 */
public class SysSysClass extends Model<SysSysClass> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//分类编码：将相同功能组合合为一类，由我们定义，与字系统由不同之处
	private String classCode;
	private String className;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysSysClass() {
	}

	/** minimal constructor */
	public SysSysClass(String classCode) {
		this.classCode = classCode;
	}

	/** full constructor */
	public SysSysClass(String classCode, String className, String remark,
			Date updateTime, String updateStaffId, String updateDepartId) {
		this.classCode = classCode;
		this.className = className;
		this.remark = remark;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
	}

	// Property accessors

	public String getClassCode() {
		return this.classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
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
		if (!(other instanceof SysSysClass))
			return false;
		SysSysClass castOther = (SysSysClass) other;

		return ((this.getClassCode() == castOther.getClassCode()) || (this
				.getClassCode() != null && castOther.getClassCode() != null && this
				.getClassCode().equals(castOther.getClassCode())))
				&& ((this.getClassName() == castOther.getClassName()) || (this
						.getClassName() != null
						&& castOther.getClassName() != null && this
						.getClassName().equals(castOther.getClassName())))
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
				+ (getClassCode() == null ? 0 : this.getClassCode().hashCode());
		result = 37 * result
				+ (getClassName() == null ? 0 : this.getClassName().hashCode());
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