package com.bzh.cloud.controller.sunrise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bzh.cloud.dao.sunrise.SysStaffDao;
import com.bzh.cloud.dao.sunrise.SysStafftempfuncrightDao;
import com.bzh.cloud.dao.sunrise.SysSystemguimenuDao;
import com.bzh.cloud.entity.sunrise.SysCurrentToken;
import com.bzh.cloud.entity.sunrise.SysDataright;
import com.bzh.cloud.entity.sunrise.SysStaff;
import com.bzh.cloud.entity.sunrise.SysStafftempfuncright;
import com.bzh.cloud.entity.sunrise.SysSystemguimenu;
import com.bzh.cloud.service.sunrise.ConfigPropertiesService;
import com.bzh.cloud.service.sunrise.DataAthorService;
import com.bzh.cloud.service.sunrise.LoginLimitService;
import com.bzh.cloud.service.sunrise.MenuAuthorService;
import com.bzh.cloud.service.sunrise.SysStaffService;
import com.bzh.cloud.util.sunrise.HttpUtil;

@RestController
//@RequestMapping(value = "/api")
public class AuthorController {
	public static Logger log=Logger.getLogger(AuthorController.class);
	
    @Autowired
    SysStaffDao sysStaffDao;
    
    @Autowired
    SysStaffService sysStaffService;
    
    @Autowired
    SysSystemguimenuDao sysSystemguimenuDao;
    @Autowired
    SysStafftempfuncrightDao sysStafftempfuncrightDao;
       
    @Autowired
    MenuAuthorService menuAuthorService;
    @Autowired
    DataAthorService dataAthorService;
    @Autowired
    LoginLimitService loginLimitService;
    @Resource(name = "redisTemplate")
    ValueOperations<String, List<SysSystemguimenu>> menuOps;
    @Resource(name = "redisTemplate")
    ValueOperations<String, List<SysDataright>> dataOps;
    @Autowired
    ConfigPropertiesService configPropertiesService;
	
    
	//根据token获取菜单
	@RequestMapping(value = "/menu/get", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMenu(HttpServletRequest request) throws Exception {
		String token=request.getHeader("Authorization");
		String ip=HttpUtil.getIpAddress(request);
		Map<String, Object> map=new HashMap<String, Object>();
		SysCurrentToken cToken=sysStaffService.verifyToken(token,ip);
		if(cToken==null){
			map.put("success", false);
			map.put("msg", "当前ticket无效，请重新登录");
			return map;
		}
		
		String staffId=cToken.getStaffId();
		List<SysSystemguimenu> menus=menuOps.get("menu_"+token);
		if(menus==null || menus.size()==0){
			 menus=menuAuthorService.menuWithStaff(staffId);
				menuOps.set("menu_"+token,menus,
						configPropertiesService.getTokenExpirationTime(), TimeUnit.MINUTES);
				log.info("添加菜单到redis！！！");
				//menuOps.getOperations().delete("menu_"+token);
			 
		}else{
			//TODO 跟新临时权限使用次数
			log.info("跟新临时权限使用次数");
			List<SysStafftempfuncright> tempRight=sysSystemguimenuDao.allTempFuncRight(staffId);
			tempRight.stream().filter(R->"0".equals(R.getUseTag())).forEach(R->{
				System.out.println(R.getId()+"++++");
				R.setUsedTimes(R.getUsedTimes()+1);
				sysStafftempfuncrightDao.updateById(R);
			});
		}
		map.put("success", true);
		map.put("menu", menus);
		return map;
		
	}	
	
	//根据token获取数据权限
	@RequestMapping(value = "/data/get", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getData(HttpServletRequest request) throws Exception {
		String token=request.getHeader("Authorization");
		String ip=HttpUtil.getIpAddress(request);
		Map<String, Object> map=new HashMap<String, Object>();
		SysCurrentToken cToken=sysStaffService.verifyToken(token,ip);
		if(cToken==null){ 
			map.put("success", false);
			map.put("msg", "当前ticket无效，请重新登录");
			return map;
		}
		
		String staffId=cToken.getStaffId();
		List<SysDataright> datas=dataOps.get("data_"+token);
		if(datas==null || datas.size()==0){
			datas=dataAthorService.dataWithStaff(staffId);
			dataOps.set("data_"+token,datas, 
					configPropertiesService.getTokenExpirationTime(), TimeUnit.MINUTES);
			log.info("添加数据到redis");
		}else{
			//TODO 跟新临时权限使用次数
		}
		map.put("success", true);
		map.put("data", datas);
		return map;
	
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getAuthor(String id,String passwd,HttpServletRequest request) throws Exception {
		Map<String, String> map=new HashMap<String, String>();

		SysStaff staff=sysStaffService.verifyStaff(id, passwd);

		if(staff==null){
			map.put("success", "false");
			map.put("msg", "验证用户信息失败");
			return map;
		}
		//跟新redis超时时间 
		String ip=HttpUtil.getIpAddress(request);
		//验证登录时间
		if(!loginLimitService.verifyTimeLimit(staff.getStaffId())){
			map.put("success", "false");
			map.put("msg", "当前时间段限制登录");
			return map;			
		}
		
		//验证登录IP
		if(!loginLimitService.verifyIpLimit(staff.getStaffId(), ip)){
			map.put("success", "false");
			map.put("msg", "您的IP:"+ip+" 限制登录");
			return map;			
		}
		//查看用户是否已经登录
		SysCurrentToken cToken=sysStaffService.verifyLogin(staff.getStaffId());
		if(cToken!=null){
			//用户在当前IP登录
			if(ip.equals(cToken.getRequestIp())){
				map.put("success", "true");
				map.put("ticket", cToken.getToken());	
				return map;
			}else{
				map.put("success", "false");
				map.put("msg", "用户已经在IP:"+cToken.getRequestIp()+" 上登录");		
				return map;
			}
		}
			
		//新建一个token返回给用户
		SysCurrentToken token=sysStaffService.createToken(staff.getStaffId(), ip);
		map.put("success", "true");
		map.put("ticket", token.getToken());
		return map;
		
	}	
	
	//注册
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> register(String jsonStr){
		Map<String, Object> map=new HashMap<String, Object>();
		return map;
	}

}
