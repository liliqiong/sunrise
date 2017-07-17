package com.example.newsunrise;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.bzkj.sunrise.SunRiseApplication;
import com.bzkj.sunrise.dao.SysCurrentTokenDao;
import com.bzkj.sunrise.dao.SysStaffDao;
import com.bzkj.sunrise.entity.SysStaff;
import com.bzkj.sunrise.entity.SysSystemguimenu;
import com.bzkj.sunrise.service.MenuService;
import com.bzkj.sunrise.service.SysCurrentTokenService;
import com.bzkj.sunrise.service.SysStaffService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SunRiseApplication.class)
public class DemoApplicationTests {
	
	
	@Autowired
	SysCurrentTokenDao sysCurrentTokenDao;
	
	@Autowired
	SysStaffDao sysStaffDao;
	
	@Autowired
	SysStaffService sysStaffService;
	
	@Autowired
	MenuService menuService;
	
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
	public void contextLoads() {
		
		sysCurrentTokenDao.findByToken("6e957cf9-dc8a-4586-883a-fb1f3f7df9eb", "127.0.0.1");
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

}
