package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 
 * 员工功能权限表
 * 
 * 保存员工的所有功能权限/角色信息
 */
public class SysStafffuncright extends Model<SysStafffuncright>{

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
	// Fields

	private String staffId;
	//权限或角色编码：可能是单个的权限编码，也可能是角色编码
	private String rightCode;
	
	
	//权限属性：0－功能权限，1－功能角色权限
	private String rightAttr;
	//权限标志：0－无效，1－有效
	private String rightTag;
	private String remark;
	private Date accreditTime;
	private String accreditStaffId;

	// Constructors

	/** default constructor */
	public SysStafffuncright() {
	}




	public String getRightAttr() {
		return this.rightAttr;
	}

	public void setRightAttr(String rightAttr) {
		this.rightAttr = rightAttr;
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




	public String getStaffId() {
		return staffId;
	}




	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}




	public String getRightCode() {
		return rightCode;
	}




	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}




	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return id;
	}

}