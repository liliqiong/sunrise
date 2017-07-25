package com.bzh.cloud.dao.sunrise;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzh.cloud.entity.sunrise.SysStafftempdataright;

public interface SysStafftempdatarightDao extends
		BaseMapper<SysStafftempdataright> {
	
	
	
	/**
	 * 根据staffId查询
	 */
	@Select("select * from sys_stafftempdataright where staff_id=#{staffId}")
	public List<SysStafftempdataright> findByStaffId(String staffId);
}
