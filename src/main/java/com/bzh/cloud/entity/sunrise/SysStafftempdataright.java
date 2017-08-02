package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

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
	@TableId
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SysStafftempdataright other = (SysStafftempdataright) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return id;
	}

}