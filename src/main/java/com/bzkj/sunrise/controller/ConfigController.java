package com.bzkj.sunrise.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzkj.sunrise.dao.ConfEntityDao;
import com.bzkj.sunrise.entity.ConfEntity;
import com.bzkj.sunrise.service.ConfEntityService;
import com.bzkj.sunrise.util.AaAmap;
import com.bzkj.sunrise.util.SpringUtil;
import com.bzkj.sunrise.util.SqlUtil;
import com.bzkj.sunrise.util.Underline2Camel;



@Controller
@RequestMapping(value="/conf")
public class ConfigController {
	

	@Autowired
	ConfEntityService confEntityService;
	
	@Autowired
	ConfEntityDao confEntityDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value="/main")
	public String mian(Model model){
		return "test";
	}
	
	@SuppressWarnings("serial")
	@RequestMapping(value="/tree")
	@ResponseBody
	public Map<String, Object> tree(Integer parentId){
		Map<String, Object> map=new HashMap<>();
		map.put("success", true);
		List<Map<String,Object>> child=new ArrayList<Map<String,Object>>();
		child.add(new HashMap<String , Object>(){
			{  
			     put("id", 1);  
			     put("text", "目录1");  
			 }}  );
		child.add(new HashMap<String , Object>(){
			{  
			     put("id", 2);  
			     put("text", "目录2");  
			 }}  );
		map.put("children", child);
		return map;
	}
	
	@RequestMapping(value="/entity")
	@ResponseBody
	public ConfEntity getEneity(String entityName){
		System.out.println(entityName);
		return confEntityService.queryEntity(entityName);
	}
	
	@RequestMapping(value="/data")
	@ResponseBody
	public Map<String, Object> getData(HttpServletRequest request){
		Map<String, String[]> _param=request.getParameterMap();
		Map<String, String> queryParam=conparam(_param);
		String entityName=queryParam.get("entityName");
		int start=Integer.valueOf( queryParam.get("start"));
		int limit=Integer.valueOf( queryParam.get("limit"));
		String sql=confEntityDao.selectById(entityName).getQuerySql();
		sql=SqlUtil.formartSql(sql, queryParam);
		
		String countSql=SqlUtil.countSql(sql);
		System.out.println(countSql);
		sql=sql+" limit "+start+","+limit;
		int total=jdbcTemplate.queryForObject(countSql, Integer.class);
		List<Map<String, Object>> data=jdbcTemplate.queryForList(sql);
		List<Map<String, Object>> aAdata=new ArrayList<Map<String,Object>>();
		data.forEach(item->{
			aAdata.add(new AaAmap<String, Object>(item));
		});
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("data", aAdata);
		result.put("total",total);
		return result;
		
	}
	
	@RequestMapping(value="/create")
	@ResponseBody
	public Map<String, String> createEntity(HttpServletRequest request){
		Map<String, String> map=new HashMap<String, String>();
		Map<String, String[]> _param=request.getParameterMap();
		Map<String, String> data=conparam(_param);
		String entityName= data.get("entityName");
		data.remove(entityName);
		BaseMapper bm=(BaseMapper) SpringUtil.getBean(entityName+"Dao");
		entityName=upFist(entityName);
		Object entity=getEneity(entityName);
		Class clzz=getClass(entityName);
		
		data.forEach((K,V)->{
			Field f=ReflectionUtils.findField(clzz, K);
			ReflectionUtils.setField(f, entity, V);
		});
		System.out.println(entity);
		return map;
	}
	
	private Map<String, String> conparam(Map<String, String[]> _param){
		Map<String, String> param=new HashMap<String, String>();
		_param.forEach((K,V)->{
			String str="";
			if(V.length>1){
				for(int i=0;i<V.length;i++){
					if(V.length-1==i){
						str+= V[i];
					}else{
						str+= V[i]+",";
					}
				}
			}else{
				str= V[0];
			}
			param.put(K, str);
		});

		return param;
	}
	
	private Object getObj(String entityName){
		Class<?> clzz=null;
		try {
			clzz=Class.forName("com.bzkj.sunrise.entity."+entityName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object o=null;
		try {
			o=clzz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	private Class getClass(String entityName){
		Class clzz=null;
		try {
			clzz=Class.forName("com.bzkj.sunrise.entity."+entityName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clzz;
	}
	
	private String upFist(String str){
		String[] arr=str.split("");
		arr[0]=arr[0].toUpperCase();
		String result="";
		for (int i = 0; i < arr.length; i++) {
			result+=arr[i];
		}
		return result;
	}
}
