package com.bzkj.sunrise.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;


/**
 *员工编码表
 *
 *保存所有登陆云平台的员工工号信息
 */

public class SysStaff extends Model<SysStaff> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	//员工编码：在任何时间内唯一，离职的员工打上标记，不直接删除
	@TableId
	private String staffId;
	private String departId;
	private String staffName;
	//岗位编码：对应岗位参数表，类似角色功能，给权限分配提供方便
	private String jobCode;
	private String managerInfo;
	//员工性别：0－男，1－女
	private String sex;
	//必须校验唯一性，用户可以用工号登陆，也可以用email登陆，还可以用手机号登陆
	private String email;
	private String userPid;
	//电话号码
	private String serialNumber;
	//离职标志：0－正常，1－已经离职
	private String dimissionTag;
	private Date birthday;
	private String custHobyy;
	//员工管理者：员工的上级
	private String managerStaffId;
	//员工登录标记：0－正常，1－虚拟（不允许登录，便于权限控制）
	private String loginFlag;
	private String remark;
	//起始有效时间
	private Date startDate;
	//终止有效时间
	private Date endDate;
	private Date updateTime;
	private String updateStaffId;
	private String updateDepartId;
	
	private String staffPasswd;

	// Constructors

	/** default constructor */
	public SysStaff() {
	}

	/** minimal constructor */
	public SysStaff(String staffId, String sex, String userPid,
			String dimissionTag, String loginFlag, Date startDate, Date endDate) {
		this.staffId = staffId;
		this.sex = sex;
		this.userPid = userPid;
		this.dimissionTag = dimissionTag;
		this.loginFlag = loginFlag;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/** full constructor */
	public SysStaff(String staffId, String departId, String staffName,
			String jobCode, String managerInfo, String sex, String email,
			String userPid, String serialNumber, String dimissionTag,
			Date birthday, String custHobyy, String managerStaffId,
			String loginFlag, String remark, Date startDate, Date endDate,
			Date updateTime, String updateStaffId, String updateDepartId) {
		this.staffId = staffId;
		this.departId = departId;
		this.staffName = staffName;
		this.jobCode = jobCode;
		this.managerInfo = managerInfo;
		this.sex = sex;
		this.email = email;
		this.userPid = userPid;
		this.serialNumber = serialNumber;
		this.dimissionTag = dimissionTag;
		this.birthday = birthday;
		this.custHobyy = custHobyy;
		this.managerStaffId = managerStaffId;
		this.loginFlag = loginFlag;
		this.remark = remark;
		this.startDate = startDate;
		this.endDate = endDate;
		this.updateTime = updateTime;
		this.updateStaffId = updateStaffId;
		this.updateDepartId = updateDepartId;
	}


	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getDepartId() {
		return this.departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	
	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	
	public String getJobCode() {
		return this.jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	
	public String getManagerInfo() {
		return this.managerInfo;
	}

	public void setManagerInfo(String managerInfo) {
		this.managerInfo = managerInfo;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPid() {
		return this.userPid;
	}

	public void setUserPid(String userPid) {
		this.userPid = userPid;
	}


	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	
	public String getDimissionTag() {
		return this.dimissionTag;
	}

	public void setDimissionTag(String dimissionTag) {
		this.dimissionTag = dimissionTag;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCustHobyy() {
		return this.custHobyy;
	}

	public void setCustHobyy(String custHobyy) {
		this.custHobyy = custHobyy;
	}


	public String getManagerStaffId() {
		return this.managerStaffId;
	}

	public void setManagerStaffId(String managerStaffId) {
		this.managerStaffId = managerStaffId;
	}

	
	public String getLoginFlag() {
		return this.loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	protected Serializable pkVal() {
		return staffId;
	}
	
	

	public String getStaffPasswd() {
		return staffPasswd;
	}

	public void setStaffPasswd(String staffPasswd) {
		this.staffPasswd = staffPasswd;
	}

	public String toString() {
		return "SysStaff [staffId=" + staffId + ", departId=" + departId
				+ ", staffName=" + staffName + ", jobCode=" + jobCode
				+ ", managerInfo=" + managerInfo + ", sex=" + sex + ", email="
				+ email + ", userPid=" + userPid + ", serialNumber="
				+ serialNumber + ", dimissionTag=" + dimissionTag
				+ ", birthday=" + birthday + ", custHobyy=" + custHobyy
				+ ", managerStaffId=" + managerStaffId + ", loginFlag="
				+ loginFlag + ", remark=" + remark + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", updateTime=" + updateTime
				+ ", updateStaffId=" + updateStaffId + ", updateDepartId="
				+ updateDepartId + "]";
	}
	
	
	

}