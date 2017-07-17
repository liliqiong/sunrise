package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;


/**
 *部门/组织编码表
 *
 *
 */

public class SysDepart extends Model<SysDepart> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private String departId;
	
	
	
	private String departCode;
	private String departName;
	//有效标记：0－有效，1－失效（注销）
	private String validflag;
	private String parentDepartId;
	//部门管理者：部门经理
	private String managerStaffId;
	//序号：树状结构信息生成时的显示顺序(同级部门/组织的优先级关系)
	private Integer orderNo;
	private Date startDate;
	private Date endDate;
	private String remark;

	// Constructors

	/** default constructor */
	public SysDepart() {
	}

	/** minimal constructor */
	public SysDepart(String departId, String departCode, String validflag,
			Integer orderNo, Date startDate) {
		this.departId = departId;
		this.departCode = departCode;
		this.validflag = validflag;
		this.orderNo = orderNo;
		this.startDate = startDate;
	}

	/** full constructor */
	public SysDepart(String departId, String departCode, String departName,
			String validflag, String parentDepartId, String managerStaffId,
			Integer orderNo, Date startDate, Date endDate, String remark) {
		this.departId = departId;
		this.departCode = departCode;
		this.departName = departName;
		this.validflag = validflag;
		this.parentDepartId = parentDepartId;
		this.managerStaffId = managerStaffId;
		this.orderNo = orderNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remark = remark;
	}

	// Property accessors

	public String getDepartId() {
		return this.departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}


	public String getDepartCode() {
		return this.departCode;
	}

	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}


	public String getDepartName() {
		return this.departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getValidflag() {
		return this.validflag;
	}

	public void setValidflag(String validflag) {
		this.validflag = validflag;
	}

	public String getParentDepartId() {
		return this.parentDepartId;
	}

	public void setParentDepartId(String parentDepartId) {
		this.parentDepartId = parentDepartId;
	}


	public String getManagerStaffId() {
		return this.managerStaffId;
	}

	public void setManagerStaffId(String managerStaffId) {
		this.managerStaffId = managerStaffId;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
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

	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.departId;
	}

}