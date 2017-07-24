package com.bzkj.sunrise.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.bzkj.sunrise.dao.SysStafftempfuncrightDao;
import com.bzkj.sunrise.dao.SysSystemguimenuDao;
import com.bzkj.sunrise.entity.SysStafftempfuncright;
import com.bzkj.sunrise.entity.SysSystemguimenu;

@Service
public class MenuAuthorService {
	
	public static Logger log=Logger.getLogger(MenuAuthorService.class);

	@Autowired
	SysSystemguimenuDao sysSystemguimenuDao;
	
	@Autowired
	SysStafftempfuncrightDao  sysStafftempfuncrightDao;
    @Resource(name = "redisTemplate")
    ValueOperations<String, List<SysSystemguimenu>> menuOps;
    @Autowired
    ConfigPropertiesService configPropertiesService;
	
	//根据staff_id获取当前用户的菜单
	public List<SysSystemguimenu> menuWithStaff(String staffId){
		Set<SysSystemguimenu> menuList=new HashSet<SysSystemguimenu>();
		List<SysSystemguimenu> redisResult=menuOps.get("menu_"+staffId);
		if(redisResult!=null && redisResult.size()>0){
			log.info("从redis获取菜单！！！");
			return redisResult;
		}
		
		//查询临时权限中的菜单
		List<SysStafftempfuncright> tempRight=sysSystemguimenuDao.allTempFuncRight(staffId);
		for (SysStafftempfuncright right : tempRight) {
			if("0".equals(right.getUseTag())){
				//临时权限按次数使用
				menuList.addAll(sysSystemguimenuDao.findMenuByTempOnTimes(staffId));
				//更新使用次数
				right.setUsedTimes(right.getUsedTimes()+1);
				sysStafftempfuncrightDao.updateById(right);
			}else{
				//临时权限按时间段使用
				menuList.addAll(sysSystemguimenuDao.findMenuByTempOnDate(staffId));
			}
		}
		//根据功能权限表查询菜单
		menuList.addAll(sysSystemguimenuDao.findMenuByStaffIdWithFun(staffId));
				
		//根据角色查找菜单
		menuList.addAll(sysSystemguimenuDao.findMenuByStaffIdWithRole(staffId));
		
		//去除菜单定制隐藏显示
		menuList.removeAll(sysSystemguimenuDao.hiddenMenu(staffId));
		menuOps.set("menu_"+staffId, new ArrayList<SysSystemguimenu>(menuList), 
				configPropertiesService.getTokenExpirationTime(), TimeUnit.MINUTES);
		log.info("添加菜单到redis！！！");
		return new ArrayList<SysSystemguimenu>(menuList);
	}


}
