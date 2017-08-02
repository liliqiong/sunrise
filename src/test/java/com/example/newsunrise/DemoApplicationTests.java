package com.example.newsunrise;


import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.bzh.cloud.dao.sunrise.SysCurrentTokenDao;
import com.bzh.cloud.dao.sunrise.SysStaffDao;
import com.bzh.cloud.entity.sunrise.SysStaff;
import com.bzh.cloud.entity.sunrise.SysSystemguimenu;
import com.bzh.cloud.service.sunrise.MenuAuthorService;
import com.bzh.cloud.service.sunrise.SysCurrentTokenService;
import com.bzh.cloud.service.sunrise.SysStaffService;
import com.bzh.cloud.util.sunrise.Underline2Camel;
import com.bzh.colud.sunrise.SunRiseApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SunRiseApplication.class)
public class DemoApplicationTests {
	
	
	@Autowired
	SysCurrentTokenDao sysCurrentTokenDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SysStaffDao sysStaffDao;
	
	@Autowired
	SysStaffService sysStaffService;
	
	@Autowired
	MenuAuthorService menuService;
	
//    @Autowired
//    private RedisTemplate<String,SysStaff> redisTemplate;
//    @Resource(name = "redisTemplate")
//    private ValueOperations<String, SysStaff> vOps;
	

	private int[] getGroup(String match){
		int[] arr=new int[4];
		String exp="(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
		Matcher m=Pattern.compile(exp).matcher(match);
		m.find();
		for (int i = 1; i <= arr.length; i++) {
			arr[i-1]=Integer.valueOf(m.group(i));
		}
		return arr;
	}

	@Test
	public void contextLoads(){
//       SysStaff sta=sysStaffService.verifyStaff("syu", "123456");
//       vOps.set("mykey4", sta);
//
//        System.out.println(vOps.get("mykey4"));
	}
	
	@Test
	public void test(){
		//SysStaff st1=sysStaffDao.findById("1");
		SysStaff st2=sysStaffDao.findByParam("staff_name", "syu");
		
		//System.out.println(st1);
		System.out.println("--------------------");
		System.out.println(st2);
	}
	
	@Test
	public void sysStaffService(){
		int[] a=getGroup("127.0.0.1");
		System.out.println(a[0]);
	}
	
	@Test
	public void menuService(){
		List<SysSystemguimenu> list=menuService.menuWithStaff("syu");
		for (SysSystemguimenu sysSystemguimenu : list) {
			System.out.println(sysSystemguimenu);
		}
	}              
	
	@Test
	public void fields(){
		List<Map<String,Object>> list=
				jdbcTemplate.queryForList("select * from conf_fields"
						+ " where entity_name<>'sysRole' order by entity_name,column_index");
		for (Map<String, Object> map : list) {
			String sql="update conf_fields set entity_name=?,field_name=?,field_type=? "
					+ "where entity_name=? and column_index=? ";
			String fieldType="";
			switch((String)map.get("field_type")){
			    case "varchar":
			    	fieldType="string";
			    	break;
			    case "char":
			    	fieldType="string";
			    	break;
			    case "date":
			    	fieldType="date";
			    	break;
			    case "int":
			    	fieldType="int";
			    	break;
			    case "timestamp":
			    	fieldType="data";
			    	break;
			}
			String ent=(String) map.get("entity_name");
			String fie=(String) map.get("field_name").toString().toLowerCase();
			String entA=Underline2Camel.underline2Camel(ent, true);
			String fieA=Underline2Camel.underline2Camel(fie, true);
			Integer columnIndex=(Integer) map.get("column_index");
			System.out.println("fieldType:"+fieldType+" ent:"+ent+" fie:"+fie+" entA:"+entA+" fieA:"+fieA);
			jdbcTemplate.update(sql, entA,fieA,fieldType,ent,columnIndex);
		}
	}
	


}
