/**
 * Copyright @ 2010-2015 Hex company All rights reserved
 * 系统名称：DCP
 * 模块名称：
 * @version版本信息：V1.0
 * @author:jiewang
 * 
 */
package com.hl.recruit.util;

import org.springframework.util.StringUtils;

public class ArrayUtil {
	/**
	 * 判断数组内是否含有某个值
	 * 
	 * @param array
	 * @param val
	 * @param ignoreCase 是否忽略大小写
	 * @return boolean
	 * */
	public static boolean contains(String[] array,String val,boolean ignoreCase){
		//数组,val 参数是否为空,
		if(StringUtils.isEmpty(val)||isEmpty(array)){
			return false;
		}
		//遍历数组
		for(String str:array){
			//ignoreCase为True
			if(ignoreCase){
				if(str.equalsIgnoreCase(val)){
					return true ;
				}
			}else{
				if(str.equals(val)){
					return true ;
				}
			}
		}
		return false;
	}
	/**
	 * 一个数组在另一个出现数组内值的次数
	 * 
	 * @param str
	 * @param arrs
	 */
	public static int matchCount(String[] srcArrs, String[] arrs,boolean ignoreCase) {
		if(ArrayUtil.isEmpty(srcArrs)||ArrayUtil.isEmpty(arrs)){
			return 0;
		}
		// 是否存在
		int count = 0;
		for (int i = 0; i < srcArrs.length; i++) {
			if (ArrayUtil.contains(arrs, srcArrs[i],ignoreCase)) {
				count++;
			}
		}
		return count;
	}
	/**
	 * 判断数组是否为空
	 * 
	 * @param array
	 * @return boolean
	 * */
	public static <T> boolean isEmpty(final T[] array){
		//是否为空
		if(array==null ||array.length==0){
			return true ;
		}
		return false ;
	}
	/**
	 * 判断数组内是否含有某个值
	 * 
	 * @param array
	 * @param val
	 * @return boolean
	 * */
	public static <T> boolean contains( final T[] array, final T v ) {
	    //遍历数组
		for ( final T e : array )
	        //e是否在数组中
			if ( e == v || v != null && v.equals( e ) )
	            return true;
	    return false;
	}
	/**
	 * 数组用分隔符拼接成字符串
	 * 
	 * @param array
	 * @param splitStr
	 * @return String
	 * */
	public static String concat( String[] array,String splitStr) {
		//判断是否为null
		if(splitStr==null){
			splitStr="";
		}
	    StringBuffer sb = new StringBuffer();
		//遍历该数组
	    for ( String str : array ){
			sb.append(str).append(splitStr);
	    }
	    //数组长度是否为空
	    if(sb.length()>0){
	    	return sb.substring(0,sb.length()-splitStr.length());
	    }
	    return "";
	}
	/**
	 * 打印String 数组内容
	 * @param arrs
	 */
	public static void print(String[] arrs){
		int index = 0;
		//循环
		for(String str:arrs){
			System.out.println("pos:" + (++index) +" value="+ str);
		}
	}
	/**
	 * 数组中提取数组
	 * @param arrs
	 * @param start
	 * @param end
	 * @return
	 */
	public static String[] getArray(String[] arrs,int start,int end){
		System.out.println(arrs.length);
		if(arrs!=null &&arrs.length>=end){
			String[] retVal = new String[end-start+1];
			System.arraycopy(arrs, start, retVal, 0, end-start+1) ;
			return retVal;
		}
		return null ;
	}
	public static void main(String[] args) {
		String[] arrs = new String[]{"111","222","333","444"};
		String[] val = getArray(arrs,1,3);
	}
}
