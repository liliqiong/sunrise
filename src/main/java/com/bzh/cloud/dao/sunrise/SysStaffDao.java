package com.bzh.cloud.dao.sunrise;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzh.cloud.entity.sunrise.SysStaff;


public interface SysStaffDao extends BaseMapper<SysStaff> {
	
	public SysStaff findById(String id);
	@Select("select f.*,d.staff_passwd from sys_staff f,sys_staffpasswd d where f.${param} = #{value} "
			+ "and f.staff_id=d.staff_id and dimission_tag='0' "
			+ "and start_date<now() and end_date>now()")
	public SysStaff findByParam(@Param("param")String param,@Param("value")String value);
}
