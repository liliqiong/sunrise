package com.bzkj.sunrise.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzkj.sunrise.entity.SysStafftempfuncright;
import com.bzkj.sunrise.entity.SysSystemguimenu;


public interface SysSystemguimenuDao extends BaseMapper<SysSystemguimenu> {
	
	//根据staff_id获取对应的菜单
	//功能权限
	@Select("SELECT m.* FROM sys_stafffuncright sfr,sys_funcright fr,sys_systemguimenu m "+
			"WHERE sfr.staff_id=#{staffId} AND sfr.`RIGHT_ATTR`='0' "+
			"AND sfr.`RIGHT_CODE`=fr.`RIGHT_CODE` "+
			"AND m.`RIGHT_CODE`=fr.`RIGHT_CODE`")
	public List<SysSystemguimenu> findMenuByStaffIdWithFun(String staffId);
	
	//根据staff_id获取对应的菜单
	//角色权限
	@Select("SELECT m.* FROM sys_stafffuncright sfr,sys_role r,sys_rolefuncright rf,sys_funcright fr,"
			+ "sys_systemguimenu m "+
			"WHERE sfr.staff_id=#{staffId} AND sfr.`RIGHT_ATTR`='1' "+
			"and sfr.right_code=r.role_code and r.role_attr='0' and r.VALIDFLAG='0'"+
			"and r.role_code=rf.role_code and rf.right_code=fr.right_code "+
			"AND m.`RIGHT_CODE`=fr.`RIGHT_CODE` ")
	public List<SysSystemguimenu> findMenuByStaffIdWithRole(String staffId);
	
	//根据员工临时权限表获取对应的菜单(按次数)
	@Select("SELECT m.* FROM sys_stafftempfuncright tmp,sys_funcright fr,sys_systemguimenu m "+
			"WHERE tmp.staff_id=#{staffId} AND tmp.`use_tag`='0' and tmp.times>tmp.used_times "+
			"AND tmp.`RIGHT_CODE`=fr.`RIGHT_CODE` "+
			"AND m.`RIGHT_CODE`=fr.`RIGHT_CODE`")
	public List<SysSystemguimenu> findMenuByTempOnTimes(String staffId);
	
	//根据员工临时权限表获取对应的菜单(按时间段)
	@Select("SELECT m.* FROM sys_stafftempfuncright tmp,sys_funcright fr,sys_systemguimenu m "+
			"WHERE tmp.staff_id=#{staffId} AND tmp.`use_tag`='1' and tmp.start_date<now() and tmp.end_date>now() "+
			"AND tmp.`RIGHT_CODE`=fr.`RIGHT_CODE` "+
			"AND m.`RIGHT_CODE`=fr.`RIGHT_CODE`")
	public List<SysSystemguimenu> findMenuByTempOnDate(String staffId);
	
	//查询临时权限
	@Select("select * from sys_stafftempfuncright where staff_id=#{staffId}")
	public List<SysStafftempfuncright> allTempFuncRight(String staffId);
	
	//菜单定制隐藏显示
	@Select("select m.* from sys_hidemenuitem h,sys_systemguimenu m where h.staff_id=#{staffId}"+
			" and m.menu_id=h.menu_id")
	public List<SysSystemguimenu> hiddenMenu(String staffId);
}
