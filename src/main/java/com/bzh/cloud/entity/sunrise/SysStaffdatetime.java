package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 */
public class SysStaffdatetime extends Model<SysStaffdatetime> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String limitId;
	private String staffId;
	private String sysTag;
	private Date startDate;
	private Date endDate;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysStaffdatetime() {
	}

	/** minimal constructor */
	public SysStaffdatetime(String limitId, String sysTag) {
		this.limitId = limitId;
		this.sysTag = sysTag;
	}

	/** full constructor */
	public SysStaffdatetime(String limitId, String staffId, String sysTag,
			Date startDate, Date endDate, String remark, Date updateTime,
			String updateStaffId, String updateDepartId) {
		this.limitId = limitId;
		this.staffId = staffId;
		this.sysTag = sysTag;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remark = remark;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
	}

	// Property accessors

	public String getLimitId() {
		return this.limitId;
	}

	public void setLimitId(String limitId) {
		this.limitId = limitId;
	}

	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getSysTag() {
		return this.sysTag;
	}

	public void setSysTag(String sysTag) {
		this.sysTag = sysTag;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
		if (!(other instanceof SysStaffdatetime))
			return false;
		SysStaffdatetime castOther = (SysStaffdatetime) other;

		return ((this.getLimitId() == castOther.getLimitId()) || (this
				.getLimitId() != null && castOther.getLimitId() != null && this
				.getLimitId().equals(castOther.getLimitId())))
				&& ((this.getStaffId() == castOther.getStaffId()) || (this
						.getStaffId() != null && castOther.getStaffId() != null && this
						.getStaffId().equals(castOther.getStaffId())))
				&& ((this.getSysTag() == castOther.getSysTag()) || (this
						.getSysTag() != null && castOther.getSysTag() != null && this
						.getSysTag().equals(castOther.getSysTag())))
				&& ((this.getStartDate() == castOther.getStartDate()) || (this
						.getStartDate() != null
						&& castOther.getStartDate() != null && this
						.getStartDate().equals(castOther.getStartDate())))
				&& ((this.getEndDate() == castOther.getEndDate()) || (this
						.getEndDate() != null && castOther.getEndDate() != null && this
						.getEndDate().equals(castOther.getEndDate())))
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
				+ (getLimitId() == null ? 0 : this.getLimitId().hashCode());
		result = 37 * result
				+ (getStaffId() == null ? 0 : this.getStaffId().hashCode());
		result = 37 * result
				+ (getSysTag() == null ? 0 : this.getSysTag().hashCode());
		result = 37 * result
				+ (getStartDate() == null ? 0 : this.getStartDate().hashCode());
		result = 37 * result
				+ (getEndDate() == null ? 0 : this.getEndDate().hashCode());
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