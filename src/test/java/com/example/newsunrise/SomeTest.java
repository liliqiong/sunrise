package com.example.newsunrise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.bzkj.sunrise.util.Underline2Camel;

public class SomeTest {

	@Test
	public void test(){
		//gittest
		boolean a=ipIn("192.168.1.0","192.168.1.0","192.168.1.0");
		System.out.println(a);
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

}
