package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

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
	@TableId
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
		SysStaffdataright other = (SysStaffdataright) obj;
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