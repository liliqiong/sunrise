package com.bzh.cloud.dao.sunrise; 
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper; 
import com.bzh.cloud.entity.sunrise.SysDataright;
public interface SysDatarightDao extends BaseMapper<SysDataright>{
	
	/**
	 * 根据员工临时数据权限表获取数据
	 * (按次数)
	 */
	@Select("SELECT d.*,t.data_type,t.right_class,t.oper_special FROM sys_dataright d,sys_stafftempdataright t WHERE t.`USE_TAG`='0' "
			+ "AND t.`TIMES`>t.`USED_TIMES` AND t.`DATA_CODE`=d.`DATA_CODE` "
			+ "AND t.`STAFF_ID`=#{staffId}")
	public List<SysDataright> findWithTempOnTime(String staffId);
	
	/**
	 * 根据员工临时数据权限表获取数据
	 * (按时间范围)
	 */	
	@Select("SELECT d.*,t.data_type,t.right_class,t.oper_special FROM sys_dataright d,sys_stafftempdataright t WHERE t.`USE_TAG`='1' "
			+ "AND t.`START_DATE`<NOW() AND t.`END_DATE`>NOW() "
			+ "AND t.`DATA_CODE`=d.`DATA_CODE` AND t.`STAFF_ID`=#{staffId}")
	public List<SysDataright> findWithTempOnDate(String staffId);
	
	/**
	 * 根据员工数据权限表获取
	 */
	@Select("SELECT d.*,t.data_type,t.right_class,t.oper_special "
			+ "FROM sys_dataright d,SYS_STAFFDATARIGHT t WHERE t.RIGHT_TAG='0' AND t.right_attr='0' "
			+ "AND t.`DATA_CODE`=d.`DATA_CODE` AND t.`STAFF_ID`=#{staffId}")
	public List<SysDataright> findWithRight(String staffId);
	
	/**
	 * 根据角色编码表获取
	 */
	@Select("SELECT d.*,t.data_type,t.right_class,t.oper_special FROM "
			+ "sys_dataright d,sys_role r,SYS_ROLEDATARIGHT rr, SYS_STAFFDATARIGHT t "
			+ "WHERE t.RIGHT_TAG='0' AND t.right_attr='1' "+ 
			"AND t.`DATA_CODE`=r.role_code AND r.role_code=rr.role_code AND rr.data_code=d.`DATA_CODE` "
			+ "AND t.`STAFF_ID`=#{staffId}")
	public List<SysDataright> findWithRole(String staffId);
}
