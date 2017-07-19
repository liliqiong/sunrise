package com.bzkj.sunrise.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlUtil {
	
	public static String formartSql(String sql,Map<String, String> param){
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
	
	public static String countSql(String sql){
		String countSql="select count(1) ";
		Matcher m=Pattern.compile("(from.*)").matcher(sql);
		m.find();
		return countSql+m.group();
	}

}
