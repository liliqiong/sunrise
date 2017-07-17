package com.bzkj.sunrise.dao;



import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzkj.sunrise.entity.SysStaffdatetime;

public interface SysStaffdatetimeDao extends BaseMapper<SysStaffdatetime> {
	
	
	@Select("select count(1) from sys_staffdatetime where staff_id=#{staffId} "
			+ "and sys_tag='0' and start_date<now() and end_date>now()")
	public int checkTimeLimit(@Param("staffId")String StaffId);
	

}
