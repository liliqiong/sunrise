package com.bzkj.sunrise.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzkj.sunrise.entity.SysStafftempdataright;

public interface SysStafftempdatarightDao extends
		BaseMapper<SysStafftempdataright> {
	
	
	
	/**
	 * 根据staffId查询
	 */
	@Select("select * from sys_stafftempdataright where staff_id=#{staffId}")
	public List<SysStafftempdataright> findByStaffId(String staffId);
}
