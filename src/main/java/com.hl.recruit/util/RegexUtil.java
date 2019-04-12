/**
 * Copyright @ 2010-2015 Hex company All rights reserved
 * 系统名称：大数据平台二期
 * 模块名称：
 * @version版本信息：V1.0
 * @author:K0140
 * 
 */
package com.hl.recruit.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright @ 2010-2015 Hex company All rights reserved
 * 系统名称：DCP
 * 模块名称：
 * @version版本信息：V1.0
 * @author:K0140
 * 
 */
public class RegexUtil {
	/**
	 * 
	 * @param content
	 * @param regex
	 * @param groupIndex
	 * @return
	 */
	public static String getValue(String content,String regex,int groupIndex){
		Pattern pattern = Pattern.compile(regex,Pattern.DOTALL);
		Matcher matcher=pattern.matcher(content);
		int idx=0;
		//是否匹配
		
		if(matcher.find()){
			return matcher.group(groupIndex) ;
		}
		return null ;
	}
	/**
	 * 获取符合条件的模式值的前值或后值
	 * @param content
	 * @param regex
	 * @param isBefore
	 * @return
	 */
	public static String getRegexVal(String content,String regex,boolean isBefore){
		Pattern pattern = Pattern.compile(regex,Pattern.DOTALL);
		Matcher matcher=pattern.matcher(content);
		int idx=0;
		//是否匹配
		
		if(matcher.find()){
			int end = matcher.end() ;
			int start= matcher.start() ;
			if(isBefore){
				return content.substring(0,start) ;
			}else{
				return content.substring(end) ;
			}
		}
		return null ;
	}
	/**
	 * 
	 * @param content
	 * @param regex
	 * @return
	 */
	public static String[] getMatchers(String content,String regex){
		if(content==null){
			return null ;
		}
		Pattern pattern = Pattern.compile(regex,Pattern.DOTALL);
		Matcher matcher=pattern.matcher(content);
		int idx=0;
		List<String> strList = new ArrayList<String>();
		//是否匹配
		
		while(matcher.find()){
			String str = matcher.group(0) ;
			strList.add(str);
		}
		return ListUtil.listToStringArray(strList) ;
	}
	/**
	 * 
	 * @param content
	 * @param regex
	 * @return
	 */
	public static int countMatchers(String content,String regex){
		
		String[] rst = getMatchers(content,regex);
		if(rst==null){
			return 0;
		}else{
			return rst.length ;
		}
	}
	/**
	 * 是否符合正则表达式
	 * @param content
	 * @param regex
	 * @return
	 */
	public static boolean containRegex(String content,String regex){
		String[] arrs = getMatchers(content,regex);
		return !ArrayUtil.isEmpty(arrs) ;
	}
	/**
	 * 出现的位置
	 * @param str
	 * @param regex
	 * @param fromPos
	 * @return
	 */
	public static int getPosition(String str,String regex,int fromPos){
		String val = RegexUtil.getRegexVal(str.substring(fromPos), regex, true);
		if(val==null){
			return -1;
		}
		return val.length() + fromPos ;
	}
	/**
	 * 出现的位置
	 * @param str
	 * @param regex
	 * @param fromPos
	 * @return
	 */
	public static String getMatcherVal(String str,String regex,int fromPos){
		String val = RegexUtil.getValue(str.substring(fromPos), regex, 0);
		return val;
	}
	/**
	 * 是否符合正则表达式
	 * @param str
	 * @param regexs
	 * @return
	 */
	public static boolean isContains(String str,String[] regexs){
		for(String regex:regexs){
			if(RegexUtil.containRegex(str, regex) ){
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		String sql="string(565)" ;
		String num = RegexUtil.getValue(sql, "\\w+\\(\\s*(\\d+)\\s*\\)", 1);
		String type = RegexUtil.getValue(sql, "(\\w+)", 1);
		
		System.out.println(num);
	}
}
