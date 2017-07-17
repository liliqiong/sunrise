package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 *员工临时数据权限表
 *
 *员工临时数据权限表：只记录有效临时权限信息，失效后搬到历史表(分配权限时判断)
 */
public class SysStafftempdataright extends Model<SysStafftempdataright>{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String staffId;
	private String dataCode;
	//数据类型：0－资源权限，1－数据特权(行列数等)，2－产品权限，3－资费权限，4－服务权限
	private String dataType;
	private String rightClass;
	private String operSpecial;
	private Date accreditTime;
	private String accreditStaffId;
	//用标志：0－按次数使用，1－按时间范围使用
	private String useTag;
	private Integer times;
	private Integer usedTimes;
	private Date startDate;
	private Date endDate;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysStafftempdataright() {
	}

	/** minimal constructor */
	public SysStafftempdataright(String staffId, String dataCode,
			String dataType, String useTag, Date updateTime) {
		this.staffId = staffId;
		this.dataCode = dataCode;
		this.dataType = dataType;
		this.useTag = useTag;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public SysStafftempdataright(String staffId, String dataCode,
			String dataType, String rightClass, String operSpecial,
			Date accreditTime, String accreditStaffId, String useTag,
			Integer times, Integer usedTimes, Date startDate, Date endDate,
			String remark, Date updateTime, String updateStaffId,
			String updateDepartId) {
		this.staffId = staffId;
		this.dataCode = dataCode;
		this.dataType = dataType;
		this.rightClass = rightClass;
		this.operSpecial = operSpecial;
		this.accreditTime = accreditTime;
		this.accreditStaffId = accreditStaffId;
		this.useTag = useTag;
		this.times = times;
		this.usedTimes = usedTimes;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public String getUseTag() {
		return this.useTag;
	}

	public void setUseTag(String useTag) {
		this.useTag = useTag;
	}

	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getUsedTimes() {
		return this.usedTimes;
	}

	public void setUsedTimes(Integer usedTimes) {
		this.usedTimes = usedTimes;
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
		if (!(other instanceof SysStafftempdataright))
			return false;
		SysStafftempdataright castOther = (SysStafftempdataright) other;

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
				&& ((this.getRightClass() == castOther.getRightClass()) || (this
						.getRightClass() != null
						&& castOther.getRightClass() != null && this
						.getRightClass().equals(castOther.getRightClass())))
				&& ((this.getOperSpecial() == castOther.getOperSpecial()) || (this
						.getOperSpecial() != null
						&& castOther.getOperSpecial() != null && this
						.getOperSpecial().equals(castOther.getOperSpecial())))
				&& ((this.getAccreditTime() == castOther.getAccreditTime()) || (this
						.getAccreditTime() != null
						&& castOther.getAccreditTime() != null && this
						.getAccreditTime().equals(castOther.getAccreditTime())))
				&& ((this.getAccreditStaffId() == castOther
						.getAccreditStaffId()) || (this.getAccreditStaffId() != null
						&& castOther.getAccreditStaffId() != null && this
						.getAccreditStaffId().equals(
								castOther.getAccreditStaffId())))
				&& ((this.getUseTag() == castOther.getUseTag()) || (this
						.getUseTag() != null && castOther.getUseTag() != null && this
						.getUseTag().equals(castOther.getUseTag())))
				&& ((this.getTimes() == castOther.getTimes()) || (this
						.getTimes() != null && castOther.getTimes() != null && this
						.getTimes().equals(castOther.getTimes())))
				&& ((this.getUsedTimes() == castOther.getUsedTimes()) || (this
						.getUsedTimes() != null
						&& castOther.getUsedTimes() != null && this
						.getUsedTimes().equals(castOther.getUsedTimes())))
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
				+ (getStaffId() == null ? 0 : this.getStaffId().hashCode());
		result = 37 * result
				+ (getDataCode() == null ? 0 : this.getDataCode().hashCode());
		result = 37 * result
				+ (getDataType() == null ? 0 : this.getDataType().hashCode());
		result = 37
				* result
				+ (getRightClass() == null ? 0 : this.getRightClass()
						.hashCode());
		result = 37
				* result
				+ (getOperSpecial() == null ? 0 : this.getOperSpecial()
						.hashCode());
		result = 37
				* result
				+ (getAccreditTime() == null ? 0 : this.getAccreditTime()
						.hashCode());
		result = 37
				* result
				+ (getAccreditStaffId() == null ? 0 : this.getAccreditStaffId()
						.hashCode());
		result = 37 * result
				+ (getUseTag() == null ? 0 : this.getUseTag().hashCode());
		result = 37 * result
				+ (getTimes() == null ? 0 : this.getTimes().hashCode());
		result = 37 * result
				+ (getUsedTimes() == null ? 0 : this.getUsedTimes().hashCode());
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