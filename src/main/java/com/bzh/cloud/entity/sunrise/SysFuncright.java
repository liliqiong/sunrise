package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * 功能权限编码表
 * 
 * 保存菜单、按钮以及相关操作特权等权限信息
 */
public class SysFuncright extends Model<SysFuncright>{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//权限编码：对于菜单权限－子系统编码＋有意义的英文说明(界面名称或者功能简称)；对于界面控件操作权限－窗体类名＋按钮名
	private String rightCode;
	private String rightName;
	//分类编码：将相同功能组合为一类，由我们定义，与子系统有不同之处
	private String classCode;
	//0－菜单权限，1－界面控件权限，2－系统特权
	private String rightAttr;
	//模块编码：子系统编码＋三位序列报表组作为有意义编码，编码可以为30位
	private String modCode;
	private Integer orderIndex;
	private String remark;
	private Date updateTime;
	//更新员工：这些权限编码基本由程序员设定，因此无需要“更新部门”字段
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysFuncright() {
	}

	/** minimal constructor */
	public SysFuncright(String rightCode, String classCode) {
		this.rightCode = rightCode;
		this.classCode = classCode;
	}

	/** full constructor */
	public SysFuncright(String rightCode, String rightName, String classCode,
			String rightAttr, String modCode, Integer orderIndex,
			String remark, Date updateTime, String updateStaffId,
			String updateDepartId) {
		this.rightCode = rightCode;
		this.rightName = rightName;
		this.classCode = classCode;
		this.rightAttr = rightAttr;
		this.modCode = modCode;
		this.orderIndex = orderIndex;
		this.remark = remark;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
	}

	// Property accessors
	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getClassCode() {
		return this.classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getRightAttr() {
		return this.rightAttr;
	}

	public void setRightAttr(String rightAttr) {
		this.rightAttr = rightAttr;
	}

	public String getModCode() {
		return this.modCode;
	}

	public void setModCode(String modCode) {
		this.modCode = modCode;
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

	public String getUpdateDepartId() {
		return this.updateDepartId;
	}

	public void setUpdateDepartId(String updateDepartId) {
		this.updateDepartId = updateDepartId;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

}