package com.bzh.cloud.service.sunrise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzh.cloud.dao.sunrise.SysStafftempfuncrightDao;
import com.bzh.cloud.dao.sunrise.SysSystemguimenuDao;
import com.bzh.cloud.entity.sunrise.SysStafftempfuncright;
import com.bzh.cloud.entity.sunrise.SysSystemguimenu;

@Service
public class MenuAuthorService {
	
	public static Logger log=Logger.getLogger(MenuAuthorService.class);

	@Autowired
	SysSystemguimenuDao sysSystemguimenuDao;
	
	@Autowired
	SysStafftempfuncrightDao  sysStafftempfuncrightDao;
 
    @Autowired
    ConfigPropertiesService configPropertiesService;
	
	//根据staff_id获取当前用户的菜单
	public List<SysSystemguimenu> menuWithStaff(String staffId){
		Set<SysSystemguimenu> menuList=new HashSet<SysSystemguimenu>();
		
		//查询临时权限中的菜单
		List<SysStafftempfuncright> tempRight=sysSystemguimenuDao.allTempFuncRight(staffId);
		for (SysStafftempfuncright right : tempRight) {
			if("0".equals(right.getUseTag())){
				log.info("临时权限按次数使用");
				sysSystemguimenuDao.findMenuByTempOnTimes(staffId).forEach(M->System.out.println(M.getMenuId()));
				//临时权限按次数使用
				menuList.addAll(sysSystemguimenuDao.findMenuByTempOnTimes(staffId));
				//更新使用次数
				right.setUsedTimes(right.getUsedTimes()+1);
				sysStafftempfuncrightDao.updateById(right);
			}else{
				log.info("临时权限按次数使用");
				sysSystemguimenuDao.findMenuByTempOnDate(staffId).forEach(M->System.out.println(M.getMenuId()));
				//临时权限按时间段使用
				menuList.addAll(sysSystemguimenuDao.findMenuByTempOnDate(staffId));
			}
		}
		log.info("根据功能权限表查询菜单");
		sysSystemguimenuDao.findMenuByStaffIdWithFun(staffId).forEach(M->System.out.println(M.getMenuId()));
		//根据功能权限表查询菜单
		menuList.addAll(sysSystemguimenuDao.findMenuByStaffIdWithFun(staffId));
		
		log.info("根据角色查找菜单");
		sysSystemguimenuDao.findMenuByStaffIdWithRole(staffId).forEach(M->System.out.println(M.getMenuId()));
		//根据角色查找菜单
		menuList.addAll(sysSystemguimenuDao.findMenuByStaffIdWithRole(staffId));
		
		log.info("去除菜单定制隐藏显示");
		sysSystemguimenuDao.hiddenMenu(staffId).forEach(M->System.out.println(M.getMenuId()));
		//去除菜单定制隐藏显示
		menuList.removeAll(sysSystemguimenuDao.hiddenMenu(staffId));

		return new ArrayList<SysSystemguimenu>(menuList);
	}


}
