package com.example.newsunrise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class SomeTest {

	@Test
	public void test(){
		//gittest
		boolean a=ipIn("192.168.1.0","192.168.1.0","192.168.1.0");
		System.out.println(a);
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
