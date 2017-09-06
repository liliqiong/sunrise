package com.example.newsunrise;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.bzh.cloud.util.sunrise.Underline2Camel;

public class SomeTest {

	@Test
	public void test(){
		//gittest
		for(int a=0;a<100;a++){
			UUID s=UUID.randomUUID();
			System.out.println(s);
		}
	}
	
	@Test
	public void test2(){
		//gittest
		String s="sys_staff";
		s=Underline2Camel.underline2Camel(s, true);
		System.out.println(s);
	}
	
	@Test
	public void test3(){
		String sql="select * from sysddd where 1=1 and a>b";
		Matcher m=Pattern.compile("(from.*)").matcher(sql);
		m.find();
		System.out.println(m.group());
	}
	
	private boolean ipIn(String start,String end,String ip){
		int[] startArr=getGroup(start);
		int[] endArr=getGroup(end);
		int[] ipArr=getGroup(ip);
		for (int i = 0; i <4; i++) {
			if(startArr[i]>ipArr[i] || endArr[i]<ipArr[i]){
				return false;
			}
		}
		return true;
	}
	
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
	public void test4() throws ClassNotFoundException{
		Class<?> cl=Class.forName("com.bzkj.sunrise.entity.SysRole");
		System.out.println(cl);
	}
	
	
	@Test
	public void test5(){
		Encoder en= Base64.getEncoder();
		Decoder de= Base64.getDecoder();
		String ss="{\"id\":\"syu\"}";
		
		String codess=en.encodeToString(ss.getBytes());
		System.out.println(codess);
		String dess=new String(de.decode(codess));
		System.out.println(dess);
		
		JSONObject jsonO = JSONObject.fromObject(dess);
		String entityName=jsonO.getString("id");
		System.out.println(entityName);
	}

	@Test
	public void redisTest(){
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
 
        // 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }
       System.out.println(jedis.get("kknd"));
	}
	
	@Test
	public void test6(){
		byte[] b=new byte[]{-84, -19, 0, 5, 116, 0, 41, 109, 101, 110, 117, 95, 51, 51, 49, 52, 57, 56, 51, 98, 45, 54, 53, 99, 101, 45, 52, 97, 101, 100, 45, 57, 55, 54, 49, 45, 97, 57, 98, 53, 57, 98, 101, 57, 98, 56, 49, 97};
		String s=new String(b);
		System.out.println(s);
	}
	
	
	@Test
	public void t8(){
		Arrays.stream(new int[] {1, 2, 3})
		.map(n -> {System.out.println(n);return n;} )
	    .map(n -> 2 * n + 1)
	    .average()
	    .ifPresent(System.out::println); 
	}
}
