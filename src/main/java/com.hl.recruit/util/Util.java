/**
 * Copyright @ 2010-2015 Hex company All rights reserved
 * 系统名称：DCP
 * 模块名称：
 * @version版本信息：V1.0
 * @author:jiewang
 * 
 */
package com.hl.recruit.util;

import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.UUID;

public class Util {
	/**
	 * md5加密
	 * 
	 * @param str
	 * @return String
	 * */
	public static String MD5(String key){
		if(key!=null){
			return DigestUtils.md5DigestAsHex(key.getBytes()) ;
		}
		return null ;
	}
	/**
	 * 获得32位uuid
	 * 
	 * @param str
	 * @return String
	 * */
	public static String uuid(){
		return UUID.randomUUID().toString().replaceAll("-", "") ;
	}
	/**
	 * 获得系统换行符
	 * 
	 * @return String
	 * */
	public static String getLineSeparator(){
		return System.getProperty("line.separator") ;
	}
	/**
	 * 根据需要获取系统换行符字符串
	 * @param num 需要个数
	 * @return 多个换行符字符串
	 */
	public static String getMutiLineSeparator(int num){
		String lineSeparator = "";
		for(int i=0;i<num;i++){
			lineSeparator += getLineSeparator();
		}
		return lineSeparator;
	}
	public static void main(String[] args) {
		
		String result = DigestUtils.md5DigestAsHex("000000".getBytes()) ;
		System.out.println(result);
		String uuid=Util.uuid();
		System.out.println(uuid + "  length=" + uuid.length());
	}
	/**
	 * 数组转换成str
	 * @param bytes
	 * @param charEncode
	 * @return String
	 * */
	public static String byteToStr(byte[] bytes,String charEncode){
		if(bytes!= null){
			try{
				return new String(bytes,charEncode);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return null;
	}
	/**
	 * 转换成byte数组
	 * @param str
	 * @param charEncode
	 * @return byte[]
	 * */
	public static byte[] toBytes(String str,String charEncode){
		if(str!= null){
			try{
				return str.getBytes(charEncode);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return null;
	}
	/**
	 * 转小写
	 * @param str
	 * @return
	 */
	
	public static String toLower(String str){
		if(GFStringUtil.isEmpty(str)){
			return str;
		}else{
			return str.toLowerCase();
		}
	}
	public static Object getBean(String beanId){
		return WebApplicationContextUtil.getBean(beanId);
	}


	//只保留最后一个句号
	public static String strLastPeriod(String str){
		ArrayList<Integer> indexs = new ArrayList<>();
		int index = -1;
		while (true){
			index = str.indexOf(".", index+1);
			if(index>0){
				indexs.add(index);
			}else {
				break;
			}
		}
		if (indexs.size()>1){
			StringBuffer sb = new StringBuffer(str);
			char[] chars = str.toCharArray();
			for (int i = indexs.size()-2;i>=0;i--){
				sb.deleteCharAt(indexs.get(i));
			}
			str = sb.toString();
		}
		return str;
	}
}
