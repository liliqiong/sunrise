package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *终端IP地址表
 *
 *保存登录BOSS系统的员工终端机器IP地址信息
 */
public class SysTermipaddr extends Model<SysTermipaddr> {

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
	private String ipStart;
	private String ipEnd;

	//网段：IP地址第二个点号与第三个点号之间的值
	private String netSeg;
	//IP起始值：对应IP起始地址最后一个点号后的值
	private String addrStart;
	//IP终止值：对应IP终止地址最后一个点号后的值
	private String addrEnd;
	private String termName;
	//允许登录标志：0－不允许登录，1－允许登录
	private String logTag;
	private String departId;
	//强制归属标志：0－不强制，1－强制,员工登录后,强制为IP地址所归属的部门和地域
	private String forceTag;
	private String remark;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;

	// Constructors

	/** default constructor */
	public SysTermipaddr() {
	}

	/** minimal constructor */

	public String getNetSeg() {
		return this.netSeg;
	}

	public void setNetSeg(String netSeg) {
		this.netSeg = netSeg;
	}

	public String getAddrStart() {
		return this.addrStart;
	}

	public void setAddrStart(String addrStart) {
		this.addrStart = addrStart;
	}

	public String getAddrEnd() {
		return this.addrEnd;
	}

	public void setAddrEnd(String addrEnd) {
		this.addrEnd = addrEnd;
	}

	public String getTermName() {
		return this.termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getLogTag() {
		return this.logTag;
	}

	public void setLogTag(String logTag) {
		this.logTag = logTag;
	}

	public String getDepartId() {
		return this.departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getForceTag() {
		return this.forceTag;
	}

	public void setForceTag(String forceTag) {
		this.forceTag = forceTag;
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

	
	public String getIpStart() {
		return ipStart;
	}

	public void setIpStart(String ipStart) {
		this.ipStart = ipStart;
	}

	public String getIpEnd() {
		return ipEnd;
	}

	public void setIpEnd(String ipEnd) {
		this.ipEnd = ipEnd;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return id;
	}

}