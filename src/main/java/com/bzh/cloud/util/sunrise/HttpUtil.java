package com.bzh.cloud.util.sunrise;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

public class HttpUtil {
	
	private static Logger logger = Logger.getLogger(HttpUtil.class);  
	public static String getIpAddr(HttpServletRequest request) throws Exception {
		logger.setAdditivity(false);
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}
	
	   public final static String getIpAddress(HttpServletRequest request) throws IOException { 
		  
	        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址  
	  
	        String ip = request.getHeader("X-Forwarded-For");  
	        if (logger.isInfoEnabled()) {  
	            //logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);  
	        }  
	  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("Proxy-Client-IP");  
	                if (logger.isInfoEnabled()) {  
	                    //logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);  
	                }  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("WL-Proxy-Client-IP");  
	                if (logger.isInfoEnabled()) {  
	                    //logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);  
	                }  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_CLIENT_IP");  
	                if (logger.isInfoEnabled()) {  
	                    //logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);  
	                }  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	                if (logger.isInfoEnabled()) {  
	                    //logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);  
	                }  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getRemoteAddr();  
	                if (logger.isInfoEnabled()) {  
	                    //logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);  
	                }  
	            }  
	        } else if (ip.length() > 15) {  
	            String[] ips = ip.split(",");  
	            for (int index = 0; index < ips.length; index++) {  
	                String strIp = (String) ips[index];  
	                if (!("unknown".equalsIgnoreCase(strIp))) {  
	                    ip = strIp;  
	                    break;  
	                }  
	            }  
	        }  
	        return ip;  
	    }  

}
