package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 *员工数据权限表
 *保存员工所有数据权限/角色信息
 */
public class SysStaffdataright extends Model<SysStaffdataright> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String staffId;
	//权限或角色编码：可能是单个的权限编码，也可能是角色编码
	private String dataCode;
	//数据类型：0－资源权限，1－数据特权(行列数等)
	private String dataType;
	//权限属性：0－数据权限，1－数据角色权限
	private String rightAttr;
	//权限级别：当权限属性是0时有效，操作特权类似
	private String rightClass;
	private String operSpecial;
	//权限标志：0－无效，1－有效
	private String rightTag;
	private String remark;
	private Date accreditTime;
	private String accreditStaffId;


	/** default constructor */
	public SysStaffdataright() {
	}

	/** minimal constructor */
	public SysStaffdataright(String staffId, String dataCode,
			String dataType, String rightAttr, String rightTag) {
		this.staffId = staffId;
		this.dataCode = dataCode;
		this.dataType = dataType;
		this.rightAttr = rightAttr;
		this.rightTag = rightTag;
	}

	/** full constructor */
	public SysStaffdataright(String staffId, String dataCode,
			String dataType, String rightAttr, String rightClass,
			String operSpecial, String rightTag, String remark,
			Date accreditTime, String accreditStaffId) {
		this.staffId = staffId;
		this.dataCode = dataCode;
		this.dataType = dataType;
		this.rightAttr = rightAttr;
		this.rightClass = rightClass;
		this.operSpecial = operSpecial;
		this.rightTag = rightTag;
		this.remark = remark;
		this.accreditTime = accreditTime;
		this.accreditStaffId = accreditStaffId;
	}

	// Property accessors

	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getDataCode() {
		return this.dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getRightAttr() {
		return this.rightAttr;
	}

	public void setRightAttr(String rightAttr) {
		this.rightAttr = rightAttr;
	}

	public String getRightClass() {
		return this.rightClass;
	}

	public void setRightClass(String rightClass) {
		this.rightClass = rightClass;
	}

	public String getOperSpecial() {
		return this.operSpecial;
	}

	public void setOperSpecial(String operSpecial) {
		this.operSpecial = operSpecial;
	}

	public String getRightTag() {
		return this.rightTag;
	}

	public void setRightTag(String rightTag) {
		this.rightTag = rightTag;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getAccreditTime() {
		return this.accreditTime;
	}

	public void setAccreditTime(Date accreditTime) {
		this.accreditTime = accreditTime;
	}

	public String getAccreditStaffId() {
		return this.accreditStaffId;
	}

	public void setAccreditStaffId(String accreditStaffId) {
		this.accreditStaffId = accreditStaffId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysStaffdataright))
			return false;
		SysStaffdataright castOther = (SysStaffdataright) other;

		return ((this.getStaffId() == castOther.getStaffId()) || (this
				.getStaffId() != null && castOther.getStaffId() != null && this
				.getStaffId().equals(castOther.getStaffId())))
				&& ((this.getDataCode() == castOther.getDataCode()) || (this
						.getDataCode() != null
						&& castOther.getDataCode() != null && this
						.getDataCode().equals(castOther.getDataCode())))
				&& ((this.getDataType() == castOther.getDataType()) || (this
						.getDataType() != null
						&& castOther.getDataType() != null && this
						.getDataType().equals(castOther.getDataType())))
				&& ((this.getRightAttr() == castOther.getRightAttr()) || (this
						.getRightAttr() != null
						&& castOther.getRightAttr() != null && this
						.getRightAttr().equals(castOther.getRightAttr())))
				&& ((this.getRightClass() == castOther.getRightClass()) || (this
						.getRightClass() != null
						&& castOther.getRightClass() != null && this
						.getRightClass().equals(castOther.getRightClass())))
				&& ((this.getOperSpecial() == castOther.getOperSpecial()) || (this
						.getOperSpecial() != null
						&& castOther.getOperSpecial() != null && this
						.getOperSpecial().equals(castOther.getOperSpecial())))
				&& ((this.getRightTag() == castOther.getRightTag()) || (this
						.getRightTag() != null
						&& castOther.getRightTag() != null && this
						.getRightTag().equals(castOther.getRightTag())))
				&& ((this.getRemark() == castOther.getRemark()) || (this
						.getRemark() != null && castOther.getRemark() != null && this
						.getRemark().equals(castOther.getRemark())))
				&& ((this.getAccreditTime() == castOther.getAccreditTime()) || (this
						.getAccreditTime() != null
						&& castOther.getAccreditTime() != null && this
						.getAccreditTime().equals(castOther.getAccreditTime())))
				&& ((this.getAccreditStaffId() == castOther
						.getAccreditStaffId()) || (this.getAccreditStaffId() != null
						&& castOther.getAccreditStaffId() != null && this
						.getAccreditStaffId().equals(
								castOther.getAccreditStaffId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStaffId() == null ? 0 : this.getStaffId().hashCode());
		result = 37 * result
				+ (getDataCode() == null ? 0 : this.getDataCode().hashCode());
		result = 37 * result
				+ (getDataType() == null ? 0 : this.getDataType().hashCode());
		result = 37 * result
				+ (getRightAttr() == null ? 0 : this.getRightAttr().hashCode());
		result = 37
				* result
				+ (getRightClass() == null ? 0 : this.getRightClass()
						.hashCode());
		result = 37
				* result
				+ (getOperSpecial() == null ? 0 : this.getOperSpecial()
						.hashCode());
		result = 37 * result
				+ (getRightTag() == null ? 0 : this.getRightTag().hashCode());
		result = 37 * result
				+ (getRemark() == null ? 0 : this.getRemark().hashCode());
		result = 37
				* result
				+ (getAccreditTime() == null ? 0 : this.getAccreditTime()
						.hashCode());
		result = 37
				* result
				+ (getAccreditStaffId() == null ? 0 : this.getAccreditStaffId()
						.hashCode());
		return result;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

}