package com.bzh.cloud.dao.sunrise;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzh.cloud.entity.sunrise.SysRole;

public interface SysRoleDao extends BaseMapper<SysRole> {
	
	//根据staffId查找角色，再根据角色查找菜单
	
}
