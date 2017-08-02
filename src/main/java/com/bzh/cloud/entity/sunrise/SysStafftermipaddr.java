package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 员工登录IP限制表
 * 
 * 保存限制员工登录的机器IP地址信息
 */
public class SysStafftermipaddr extends Model<SysStafftermipaddr> {

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
	private String ipStart;
	//IP终止地址：如果是固定IP，填写和起始IP相同
	private String ipEnd;
	//系统限制标记：0－不能登录IP，1－只能登录IP段
	private String sysTag;
	//受限原因',备注
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysStafftermipaddr() {
	}

	/** minimal constructor */
	public SysStafftermipaddr(String staffId, String ipStart, String ipEnd,
			String sysTag) {
		this.staffId = staffId;
		this.ipStart = ipStart;
		this.ipEnd = ipEnd;
		this.sysTag = sysTag;
	}

	/** full constructor */
	public SysStafftermipaddr(String staffId, String ipStart, String ipEnd,
			String sysTag, String remark, Date updateTime,
			String updateStaffId, String updateDepartId) {
		this.staffId = staffId;
		this.ipStart = ipStart;
		this.ipEnd = ipEnd;
		this.sysTag = sysTag;
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

	public String getIpStart() {
		return this.ipStart;
	}

	public void setIpStart(String ipStart) {
		this.ipStart = ipStart;
	}

	public String getIpEnd() {
		return this.ipEnd;
	}

	public void setIpEnd(String ipEnd) {
		this.ipEnd = ipEnd;
	}

	public String getSysTag() {
		return this.sysTag;
	}

	public void setSysTag(String sysTag) {
		this.sysTag = sysTag;
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
		SysStafftermipaddr other = (SysStafftermipaddr) obj;
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