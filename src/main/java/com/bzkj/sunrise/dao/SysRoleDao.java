package com.bzkj.sunrise.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzkj.sunrise.entity.SysRole;

public interface SysRoleDao extends BaseMapper<SysRole> {
	
	//根据staffId查找角色，再根据角色查找菜单
	
}
