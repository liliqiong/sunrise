package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *数据权限编码表
 *
 *保存数据权限信息，包含资源、数据特权等相关权限集合
 */
public class SysDataright extends Model<SysDataright> {


    /**
	 * 
	 */
	@TableId
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private static final long serialVersionUID = 1L;
	//数据编码： 产品、资费和服务等权限采用其对应的参数编码，其它类型权限采用有意义的字母表示
	private String dataCode;
	private String dataName;
	//权限类型
	private String rightType;
	private Integer orderIndex;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	
	//权限级别 从关联查询中获取
	//0－无权限，1－个人权限，2－营业厅权限，3－业务区权限，4－地州权限，5－全省权限
	private String rightClass;
	
	//操作权限，从关联查询中获取
	//0－可同级操作，1－可越级操作
	private String operSpecial;
	
	//数据类型，从关联查询中回去
	//0－资源权限，1－数据特权(行列数等)，2－产品权限，3－资费权限，4－服务权限
	private String dataType;

	// Constructors

	/** default constructor */
	public SysDataright() {
	}

	/** minimal constructor */
	public SysDataright(String dataCode, String rightType) {
		this.dataCode = dataCode;
		this.rightType = rightType;
	}

	/** full constructor */
	public SysDataright(String dataCode, String dataName, String rightType,
			Integer orderIndex, String remark, Date updateTime,
			String updateStaffId) {
		this.dataCode = dataCode;
		this.dataName = dataName;
		this.rightType = rightType;
		this.orderIndex = orderIndex;
		this.remark = remark;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
	}

	// Property accessors
	public String getDataCode() {
		return this.dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}

	public String getDataName() {
		return this.dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getRightType() {
		return this.rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public Integer getOrderIndex() {
		return this.orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
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

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getRightClass() {
		return rightClass;
	}

	public void setRightClass(String rightClass) {
		this.rightClass = rightClass;
	}

	public String getOperSpecial() {
		return operSpecial;
	}

	public void setOperSpecial(String operSpecial) {
		this.operSpecial = operSpecial;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
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
		SysDataright other = (SysDataright) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}