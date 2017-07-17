package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;


/**
 *数据权限编码表
 *
 *保存数据权限信息，包含资源、数据特权等相关权限集合
 */
public class SysDataright extends Model<SysDataright> {


    /**
	 * 
	 */
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
		return null;
	}

}