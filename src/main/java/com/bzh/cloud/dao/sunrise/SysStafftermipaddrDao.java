package com.bzh.cloud.dao.sunrise;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzh.cloud.entity.sunrise.SysStafftermipaddr;

public interface SysStafftermipaddrDao extends BaseMapper<SysStafftermipaddr> {
	
	@Select("select * from sys_stafftermipaddr where staff_id=#{staffId}")
	public SysStafftermipaddr findByStaffId(String staffId);
}
