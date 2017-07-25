package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * 员工登录IP限制表
 * 
 * 保存限制员工登录的机器IP地址信息
 */
public class SysStafftermipaddr extends Model<SysStafftermipaddr> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String staffId;
	private String ipStart;
	//IP终止地址：如果是固定IP，填写和起始IP相同
	private String ipEnd;
	//系统限制标记：0－不能登录IP，1－只能登录IP段
	private String sysTag;
	//受限原因',备注
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysStafftermipaddr() {
	}

	/** minimal constructor */
	public SysStafftermipaddr(String staffId, String ipStart, String ipEnd,
			String sysTag) {
		this.staffId = staffId;
		this.ipStart = ipStart;
		this.ipEnd = ipEnd;
		this.sysTag = sysTag;
	}

	/** full constructor */
	public SysStafftermipaddr(String staffId, String ipStart, String ipEnd,
			String sysTag, String remark, Date updateTime,
			String updateStaffId, String updateDepartId) {
		this.staffId = staffId;
		this.ipStart = ipStart;
		this.ipEnd = ipEnd;
		this.sysTag = sysTag;
		this.remark = remark;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
	}

	// Property accessors

	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getIpStart() {
		return this.ipStart;
	}

	public void setIpStart(String ipStart) {
		this.ipStart = ipStart;
	}

	public String getIpEnd() {
		return this.ipEnd;
	}

	public void setIpEnd(String ipEnd) {
		this.ipEnd = ipEnd;
	}

	public String getSysTag() {
		return this.sysTag;
	}

	public void setSysTag(String sysTag) {
		this.sysTag = sysTag;
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
		if (!(other instanceof SysStafftermipaddr))
			return false;
		SysStafftermipaddr castOther = (SysStafftermipaddr) other;

		return ((this.getStaffId() == castOther.getStaffId()) || (this
				.getStaffId() != null && castOther.getStaffId() != null && this
				.getStaffId().equals(castOther.getStaffId())))
				&& ((this.getIpStart() == castOther.getIpStart()) || (this
						.getIpStart() != null && castOther.getIpStart() != null && this
						.getIpStart().equals(castOther.getIpStart())))
				&& ((this.getIpEnd() == castOther.getIpEnd()) || (this
						.getIpEnd() != null && castOther.getIpEnd() != null && this
						.getIpEnd().equals(castOther.getIpEnd())))
				&& ((this.getSysTag() == castOther.getSysTag()) || (this
						.getSysTag() != null && castOther.getSysTag() != null && this
						.getSysTag().equals(castOther.getSysTag())))
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
				+ (getStaffId() == null ? 0 : this.getStaffId().hashCode());
		result = 37 * result
				+ (getIpStart() == null ? 0 : this.getIpStart().hashCode());
		result = 37 * result
				+ (getIpEnd() == null ? 0 : this.getIpEnd().hashCode());
		result = 37 * result
				+ (getSysTag() == null ? 0 : this.getSysTag().hashCode());
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