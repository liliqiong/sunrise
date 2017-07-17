package com.bzkj.sunrise.dao;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzkj.sunrise.entity.SysStafftermipaddr;

public interface SysStafftermipaddrDao extends BaseMapper<SysStafftermipaddr> {
	
	@Select("select * from sys_stafftermipaddr where staff_id=#{staffId}")
	public SysStafftermipaddr findByStaffId(String staffId);
}
