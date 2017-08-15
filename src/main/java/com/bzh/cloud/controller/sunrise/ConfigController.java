package com.bzh.cloud.controller.sunrise;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzh.cloud.dao.sunrise.ConfEntityDao;
import com.bzh.cloud.entity.sunrise.ConfEntity;
import com.bzh.cloud.entity.sunrise.SysDataright;
import com.bzh.cloud.entity.sunrise.SysSystemguimenu;
import com.bzh.cloud.service.sunrise.ConfEntityService;
import com.bzh.cloud.service.sunrise.ValidEntityService;
import com.bzh.cloud.util.sunrise.AaAListMap;
import com.bzh.cloud.util.sunrise.AaAmap;
import com.bzh.cloud.util.sunrise.HttpUtil;
import com.bzh.cloud.util.sunrise.JSONUtil;
import com.bzh.cloud.util.sunrise.SpringUtil;
import com.bzh.cloud.util.sunrise.SqlUtil;


@Controller
@RequestMapping(value="/conf")
public class ConfigController {
	

	@Autowired
	ConfEntityService confEntityService;
	
	@Autowired
	ConfEntityDao confEntityDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ValidEntityService validEntityService;
	@Autowired
	RedisTemplate<String, ?> redisTemplate;
    @Resource(name = "redisTemplate")
    ValueOperations<String, List<SysSystemguimenu>> menuOps;
    @Resource(name = "redisTemplate")
    ValueOperations<String, List<SysDataright>> dataOps;
    @Resource(name = "redisTemplate")
    ValueOperations<String,String> strOps;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

	@RequestMapping(value="/main")
	public String mian(Model model){
		return "test";
	}
	

	@RequestMapping(value="/tree")
	@ResponseBody
	public Map<String, Object> tree(Integer parentId){
		Map<String, Object> map=new HashMap<>();
		map.put("success", true);
		
		String sql="select * from conf_tree where parent_id=?";
		List<Map<String,Object>> child=jdbcTemplate.queryForList(sql, parentId);
		map.put("children", new AaAListMap(child));
		return map;
	}
	
	@RequestMapping(value="/entity")
	@ResponseBody
	public ConfEntity getEneity(String entityName){
		System.out.println(entityName);
		return confEntityService.queryEntity(entityName);
	}
	
	@RequestMapping(value="/dataSql")
	@ResponseBody
	public List<Map<String, Object>> dataSql(String sql){
		System.out.println("dataSql:"+sql);
		return jdbcTemplate.queryForList(sql);
	}
	
	
	@RequestMapping(value="/checkUnique")
	@ResponseBody
	public Map<String, Object> checkUnique(HttpServletRequest request){
		Map<String, Object> map=new HashMap<>();
		Map<String, String[]> _param=request.getParameterMap();
		Map<String, String> queryParam=conparam(_param);
		String sql=queryParam.get("checkSql");
		sql=formatSql(sql, queryParam);
		System.out.println(sql);
		Matcher m=Pattern.compile("\\s*and\\s*").matcher(sql);
		if(!m.find()){
			map.put("success", false);
			map.put("msg", "属性不能为空");
			return map;
		}
		int flag=jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(flag);
		if(flag>0){
			map.put("success", false);
			map.put("msg", "属性已经存在");
			return map;
		}
		map.put("success", true);
		map.put("msg", "属性可用");
		return map;
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
		sql=sql+" limit "+start+","+limit;
		int total=jdbcTemplate.queryForObject(countSql, Integer.class);
		System.out.println("data:"+sql);
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/create")
	@ResponseBody
	public Map<String, Object> createEntity(String jsonStr,HttpServletRequest request){	
		System.out.println(jsonStr);
		String ip=null;
		try {
			ip=HttpUtil.getIpAddress(request);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String token=request.getHeader("Authorization");
		JSONObject jsonO = JSONObject.fromObject(jsonStr);
		Map<String, Object> map=validEntityService.vaild(jsonO,token,ip,true);
		if(!(boolean) map.get("success")){
			return map;
		}
		String entityName=jsonO.getString("entityName");
		//jsonO.put("id", UUID.randomUUID().toString());
		BaseMapper bm=(BaseMapper) SpringUtil.getBean(entityName+"Dao");
		//Object sr = JSONObject.toBean(jsonO,getClass(upFist(entityName)));
		Object sr =  JSONUtil.JsonToBean(getClass(upFist(entityName)), jsonStr);
		System.out.println(sr);
		try {
			bm.insert(sr);
		} catch (Exception e) {
			map.put("success", false);
			map.put("err", e.getMessage());
			e.printStackTrace();
			return map;
		}
		deleteRedisCache();
		return map;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/update")
	@ResponseBody
	public Map<String, Object> updateEntity(String jsonStr,HttpServletRequest request){	
		String ip=null;
		try {
			ip=HttpUtil.getIpAddress(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String token=request.getHeader("Authorization");
		JSONObject jsonO = JSONObject.fromObject(jsonStr);
		Map<String, Object> map=validEntityService.vaild(jsonO,token,ip,false);
		if(!(boolean) map.get("success")){
			return map;
		}
		String entityName=jsonO.getString("entityName");
		
		BaseMapper bm=(BaseMapper) SpringUtil.getBean(entityName+"Dao");
		Object sr =  JSONUtil.JsonToBean(getClass(upFist(entityName)), jsonStr);
		System.out.println(sr);
		try {
			bm.updateById(sr);
		} catch (Exception e) {
			map.put("success", false);
			map.put("err", e.getMessage());
			e.printStackTrace();
			return map;
		}
		
		deleteRedisCache();
		
		return map;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Map<String, String> delete(String jsonStr,HttpServletRequest request){	
		System.out.println(jsonStr);
		Map<String, String> map=new HashMap<String, String>();
		JSONObject jsonO = JSONObject.fromObject(jsonStr);
		String entityName=jsonO.getString("entityName");
		BaseMapper bm=(BaseMapper) SpringUtil.getBean(entityName+"Dao");
		String id=jsonO.getString("id");
		bm.deleteById(id);
		map.put("success", "true");
		deleteRedisCache();
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
	
	@SuppressWarnings("unused")
	private Object getObj(String entityName){
		Class<?> clzz=null;
		try {
			clzz=Class.forName("com.bzh.cloud.entity.sunrise."+entityName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Object o=null;
		try {
			o=clzz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@SuppressWarnings("rawtypes")
	private Class getClass(String entityName){
		Class clzz=null;
		try {
			clzz=Class.forName("com.bzh.cloud.entity.sunrise."+entityName);
		} catch (ClassNotFoundException e) {
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
	
	

	
	private String formatSql(String sql,Map<String, String> param){  
        Matcher m=Pattern.compile("and\\s*\\w+.?\\w+\\s*(?:[=<>]|>=|<=)\\s*(:\\s*(\\w+))\\s*").matcher(sql);
        while(m.find()){
        	if(  null==param.get(m.group(2)) || ( param.get(m.group(2))).matches("\\s*|null|-1")   ){         	
                sql=sql.replace(m.group(), "");
            }else{
            	sql=sql.replace(m.group(1), "'"+param.get(m.group(2))+"'");
            }
        }
		Matcher m2=Pattern.compile("and\\s*\\w+.?\\w+\\s*(?:[=<>]|>=|<=)\\s*to_date\\('(:\\s*(\\w+))'\\s*,\\s*'yyyy-mm-dd (?:HH|hh)24:(?:MI|mi):(?:SS|ss)'\\s*\\)\\s*").matcher(sql);
        while(m2.find()){
        	if(null==param.get(m2.group(2)) || ( param.get(m2.group(2))).matches("\\s*|null|-1")  ){         	
                sql=sql.replace(m2.group(), "");
            }else{
            	sql=sql.replace(m2.group(1), param.get(m2.group(2)));
            }
        }
		Matcher m3=Pattern.compile("and\\s*\\w+.?\\w+\\s*between\\s*to_date\\('(:\\s*(\\w+))'\\s*,\\s*'yyyy-mm-dd (?:HH|hh)24:(?:MI|mi):(?:SS|ss)'\\s*\\)\\s*and\\s*to_date\\('(:\\s*(\\w+))'\\s*,\\s*'yyyy-mm-dd (?:HH|hh)24:(?:MI|mi):(?:SS|ss)'\\s*\\)\\s*").matcher(sql);
        while(m3.find()){
           	if(null==param.get(m3.group(2)) || ( param.get(m3.group(2))).matches("\\s*|null|-1") 
           			|| null==param.get(m3.group(4)) || ( param.get(m3.group(4))).matches("\\s*|null|-1")){         	
                sql=sql.replace(m3.group(), "");
            }else{
            	sql=sql.replace(m3.group(1), param.get(m3.group(2)));
            	sql=sql.replace(m3.group(3), param.get(m3.group(4)));
            }       	
        }
        
        Matcher m4=Pattern.compile("and\\s*\\w+.?\\w+\\s*(?:[=<>]|>=|<=)\\s*to_date\\((:\\s*(\\w+))\\s*,\\s*'yyyy-mm-dd (?:HH|hh)24:(?:MI|mi):(?:SS|ss)'\\s*\\)\\s*").matcher(sql);
        while(m4.find()){
        	if(  null==param.get(m4.group(2)) || ( param.get(m4.group(2))).matches("\\s*|null|-1")   ){         	
                sql=sql.replace(m4.group(), "");
            }else{
            	sql=sql.replace(m4.group(1), "'"+param.get(m4.group(2))+"'");
            }
        }
        
		Matcher m5=Pattern.compile("and\\s*\\w+.?\\w+\\s*between\\s*to_date\\((:\\s*(\\w+))\\s*,\\s*'yyyy-mm-dd (?:HH|hh)24:(?:MI|mi):(?:SS|ss)'\\s*\\)\\s*and\\s*to_date\\((:\\s*(\\w+))\\s*,\\s*'yyyy-mm-dd (?:HH|hh)24:(?:MI|mi):(?:SS|ss)'\\s*\\)\\s*").matcher(sql);
        while(m5.find()){
           	if(null==param.get(m5.group(2)) || ( param.get(m5.group(2))).matches("\\s*|null|-1") 
           			|| null==param.get(m5.group(4)) || ( param.get(m5.group(4))).matches("\\s*|null|-1")){         	
                sql=sql.replace(m5.group(), "");
            }else{
            	sql=sql.replace(m5.group(1), "'"+param.get(m5.group(2))+"'");
            	sql=sql.replace(m5.group(3), "'"+param.get(m5.group(4))+"'");
            }       	
        }   
        
        Matcher m6=Pattern.compile("and\\s*\\w+.?\\w+\\s*in\\s*\\((:\\s*(\\w+))\\s*\\)").matcher(sql);
        while(m6.find()){
        	if(  null==param.get(m6.group(2)) || ( param.get(m6.group(2))).matches("\\s*|null|-1")   ){         	
                sql=sql.replace(m6.group(), "");
            }else{
            	String[] s=param.get(m6.group(2)).split(",");
            	String str="";
            	for (int i = 0; i < s.length; i++) {
					str+="'"+s[i]+"',";
				}
            	str=str.substring(0, str.length()-1);
            	sql=sql.replace(m6.group(1), str);
            }
        }
        return sql;
	}
	
	private void deleteRedisCache(){
		Set<String> menuK=menuOps.getOperations().keys("menu_*");
		Set<String> dataK=dataOps.getOperations().keys("data_*");
		menuOps.getOperations().delete(menuK);
		menuOps.getOperations().delete(dataK);
	}
}
