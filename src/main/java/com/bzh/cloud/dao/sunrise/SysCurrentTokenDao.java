package com.bzh.cloud.dao.sunrise;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzh.cloud.entity.sunrise.SysCurrentToken;


public interface SysCurrentTokenDao extends BaseMapper<SysCurrentToken>{
	
	@Select("select * from sys_current_token where staff_id=#{staffId} and expiration_time>now()")
	public SysCurrentToken findByStaffId(@Param("staffId")String StaffId);
	
	@Select("select * from sys_current_token where token=#{token} and request_ip=#{requestIp}  and expiration_time>now()")
	public SysCurrentToken findByToken(@Param("token")String token,@Param("requestIp")String requestIp);	
	
	@Delete("delete from sys_current_token where staff_id=#{staffId}")
	public int deleteByStaffId(@Param("staffId")String staffId);
	
	@Update("update sys_current_token "
			+ "set staff_id=#{staffId}, "
			+ "expiration_time=#{expirationTime},request_ip=#{requestIp} "
			+ "where token=#{token}")
	public void updateOne(SysCurrentToken sysCurrentToken);
}
