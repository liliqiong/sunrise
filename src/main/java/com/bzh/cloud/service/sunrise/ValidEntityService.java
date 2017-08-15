package com.bzh.cloud.service.sunrise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bzh.cloud.dao.sunrise.ConfFieldsDao;
import com.bzh.cloud.entity.sunrise.ConfFields;
import com.bzh.cloud.entity.sunrise.SysCurrentToken;
/**
 * 
 * @author syu
 * 验证跟新和新建的数据是否合法
 */

@Service
public class ValidEntityService {
	
    @Autowired
    SysStaffService sysStaffService;
    
    @Autowired
    ConfFieldsDao confFieldsDao;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> vaild(JSONObject jobj,String token,String ip,boolean isCreate){
		Map<String, Object> map=new HashMap<String, Object>();
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		map.put("success", true);
		map.put("info", list);
		//map.put("msg", "成功");

		SysCurrentToken cToken=sysStaffService.verifyToken(token,ip);
		if(cToken==null){
			map.put("success", false);
			map.put("info", "当前ticket无效，请重新登录");
			return map;
		}
		
		String entityName=jobj.getString("entityName");
		System.out.println(entityName);
		List<Map<String, Object>> relatedList=jdbcTemplate.
				queryForList("select field_name,related_field from conf_related where entity_name=? "
						+ "group by field_name,related_field",entityName);
		Map<String, String> sqlMap=new HashMap<String, String>();
		List<ConfFields> fields=confFieldsDao.findByentityName(entityName);
		List<String> disableList=new ArrayList<String>();
		
		relatedList.forEach((M)->{
			String fieldName=(String) M.get("field_name");
			String value=jobj.getString((String) M.get("related_field"));
			System.out.println(entityName+"   "+value);
			String disableField=jdbcTemplate.queryForObject("select GROUP_CONCAT(disable_field) from conf_related"
					+ " where entity_name=? and related_value=? " +
					"   group by entity_name,related_value", String.class,
					entityName,value);
			disableList.add(disableField);
			String dataSql=null;
			try {
				dataSql=
						jdbcTemplate.queryForObject("select data_sql from conf_related where entity_name=? "
						+ "and field_name=? and related_field=? and related_value=?", String.class,
						entityName,(String) M.get("field_name"),(String) M.get("related_field"),value);
			} catch (Exception e) {
				return;
			}					
			sqlMap.put(fieldName, dataSql);

		});
		String temp="";
		for(int i=0;i<disableList.size();i++){
			if(i==0){
				temp=disableList.get(i);
			}else{
				temp+=","+disableList.get(i);
			}
			
		}
		final String disableField=temp;
		fields.forEach((C)->{	
			System.out.println(C);
			Map<String, String> msg=new HashMap<String, String>();
			String fieldName=C.getFieldName();
			if(!StringUtils.isEmpty(disableField) && disableField.contains(fieldName)){
				return;
			}
			System.out.println("value:"+jobj.getString(fieldName));
			//不能为空
			if("1".equals(C.getAllowBlank())){
				if(StringUtils.isEmpty(jobj.getString(fieldName))){
					map.put("success", false);
					msg.put("field", fieldName);
					msg.put("msg", "字段不能为空");				
				}
			}
			//关联性
			if(!StringUtils.isEmpty(C.getDataSql())){
				Integer n=0;
				String sql=C.getDataSql();
				if(sqlMap.containsKey(fieldName)){
					sql=sqlMap.get(fieldName);
				}
				Matcher m=Pattern.compile("select\\s+((\\w+)\\s+text\\s*,\\s*(\\w+)\\s+value)\\s+from\\s+\\w+")
						.matcher(sql);
				if(m.find()){
					sql=sql.replace(m.group(1), "count(1)");
					if(sql.contains("where")){
						sql+=" and "+m.group(3)+"=?";
					}else{
						sql+=" where "+m.group(3)+"=?";
					}				
				}else{
					Matcher m2=Pattern.
						compile("select\\s+text\\s*,\\s*value\\s+from\\s+conf_data\\s+where\\s+data_group\\s*=\\s*(\\d+)")
						.matcher(sql);
					m2.find();
					sql="select count(1) from conf_data where data_group="+m2.group(1)+" and value=?";
				}
				n=jdbcTemplate.queryForObject(sql, Integer.class, jobj.getString(fieldName));
				if(n<1){
					map.put("success", false);
					msg.put("field", fieldName);
					msg.put("msg", "值:"+jobj.getString(fieldName)+"关联错误");
				}
			}
			//唯一性验证
			if(!StringUtils.isEmpty(C.getCheckSql()) && isCreate){
				String sql=C.getCheckSql();
				Matcher m=Pattern
					.compile("select\\s+count\\(1\\)\\s+from\\s+\\w+\\s+where\\s+1=1\\s+and\\s+\\w+=(:(\\w+))")
					.matcher(sql);
				m.find();
				sql=sql.replace(m.group(1), "?");
				Integer n=jdbcTemplate.queryForObject(sql, Integer.class, jobj.getString(m.group(2)));
				if(n>0){
					map.put("success", false);;	
					msg.put("field", fieldName);
					msg.put("msg", "值:"+jobj.getString(fieldName)+"不唯一");
				}
			}
			if(!msg.isEmpty()){
				list.add(msg);
			}
		});
		return map;
	}

}
