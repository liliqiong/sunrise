package com.bzkj.sunrise.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bzkj.sunrise.dao.SysDatarightDao;
import com.bzkj.sunrise.dao.SysStafftempdatarightDao;
import com.bzkj.sunrise.entity.SysDataright;
import com.bzkj.sunrise.entity.SysStafftempdataright;


@Service
public class DataAthorService {
	
	@Autowired
	SysStafftempdatarightDao sysStafftempdatarightDao;
	
	@Autowired
	SysDatarightDao sysDatarightDao;
	
	
	//根据staff_id获取当前用户的菜单
	@SuppressWarnings("serial")
	public List<SysDataright> menuWithStaff(String staffId){
		Set<SysDataright> menuList=new HashSet<SysDataright>();
		//查询临时权限
		List<SysStafftempdataright> tempRight=sysStafftempdatarightDao.findByStaffId(staffId);
		for (SysStafftempdataright right : tempRight) {
			if("0".equals(right.getUseTag())){
				//临时权限按次数使用
				menuList.addAll(sysDatarightDao.findWithTempOnTime(staffId));
				//更新使用次数
				right.setUsedTimes(right.getUsedTimes()+1);
				sysStafftempdatarightDao.update(right, new Wrapper<SysStafftempdataright>() {
					@Override
					public String getSqlSegment() {
						System.out.println("111111111111111111111");
						return null;
					}
				});
			}else{
				//临时权限按时间段使用
				menuList.addAll(sysDatarightDao.findWithTempOnDate(staffId));
			}
		}
		//根据数据权限
		menuList.addAll(sysDatarightDao.findWithRight(staffId));				
		//根据角色
		menuList.addAll(sysDatarightDao.findWithRole(staffId));
				
		return new ArrayList<SysDataright>(menuList);
	}

}
