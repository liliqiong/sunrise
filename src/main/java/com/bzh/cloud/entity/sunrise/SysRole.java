package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 角色编码表
 * 保存角色编码参数信息
 *
 */

@TableName("sys_role")
public class SysRole extends Model<SysRole>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	@TableId
	private String id;
	//角色编码
	private String roleCode;
	private String dataCode;
	private String roleName;
	//数据类型 0-资源权限 1-数据特权（行列数）9-网别 P-产品权限 D-资源权限 S-服务权限 K-包权限
	private String dataType;
	//'角色属性：0－功能权限角色，1－资源数据权限角色，2－数据特权角色 可扩展',
	private String roleAttr;
	private String remark;
	
	//'有效0 ；无效1
	private String validflag;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;



	/** default constructor */
	public SysRole() {
	}



	// Property accessors
	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleAttr() {
		return this.roleAttr;
	}

	public void setRoleAttr(String roleAttr) {
		this.roleAttr = roleAttr;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValidflag() {
		return this.validflag;
	}
	            
	public void setValidflag(String validflag) {
		this.validflag = validflag;
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
		return this.getId();
	}
	
	

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	@Override
	public String toString() {
		return "SysRole [id=" + id + ", roleCode=" + roleCode + ", dataCode="
				+ dataCode + ", roleName=" + roleName + ", dataType="
				+ dataType + ", roleAttr=" + roleAttr + ", remark=" + remark
				+ ", validflag=" + validflag + ", updateTime=" + updateTime
				+ ", updateStaffId=" + updateStaffId + ", updateDepartId="
				+ updateDepartId + "]";
	}



	public String getDataCode() {
		return dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}