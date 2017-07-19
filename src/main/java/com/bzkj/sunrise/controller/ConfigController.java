package com.bzkj.sunrise.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bzkj.sunrise.dao.ConfEntityDao;
import com.bzkj.sunrise.entity.ConfEntity;
import com.bzkj.sunrise.service.ConfEntityService;
import com.bzkj.sunrise.util.AaAmap;
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
}
