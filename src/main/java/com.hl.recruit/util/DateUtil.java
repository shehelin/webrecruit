/**
 * Copyright @ 2010-2015 Hex company All rights reserved
 * 系统名称：DCP
 * 模块名称：
 * @version版本信息：V1.0
 * @author:jiewang
 * 
 */
package com.hl.recruit.util;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.springframework.util.StringUtils;

import java.util.Date;

public class DateUtil {
	public static final String YYYYMMDD="yyyyMMdd";
	public static final String YYYY_MM_DDHHMISS="yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD="yyyy-MM-dd";
	/**
	 * 获取当日8位日期
	 * 
	 * @return String
	 * */
	public static String getCurrentDate(){
		return DateUtil.format(new Date(),DateUtil.YYYYMMDD);
	}
	/**
	 * 获取当日日期时分秒 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 * */
	public static String getCurrentTime(){
		return DateUtil.format(new Date(),DateUtil.YYYY_MM_DDHHMISS);
	}
	/**
	 * 日期格式转换
	 * 
	 * @param date
	 * @param patten
	 * @return String
	 * */
	public static String format(Date date,String patten){
		 java.text.DateFormat format2 = new java.text.SimpleDateFormat(patten);
		 
	     return format2.format(date);
	}
	/**
	 * 日期对象转换
	 * 
	 * @param dateStr
	 * @param patten
	 * @return String
	 * */
	public static Date parser(String dateStr,String patten){
		try{
			java.text.DateFormat format2 = new java.text.SimpleDateFormat(patten);
			Date date = format2.parse(dateStr) ;
			return date ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		return null ;
	}
	/**
	 * 获取当日日期没有时分秒对象
	 * 
	 * @return String
	 * */
	public static Date getCurrentDateNoTime(){
		String datestr = getNormalDate(new Date());
		return DateUtil.getDate(datestr) ;
	}
	/**
	 * 日期转换成标准的YYYY_MM_DD
	 * 
	 * @param date
	 * @return String
	 * */
	public static String getNormalDate(Date date){
		return DateUtil.format(date,DateUtil.YYYY_MM_DD);
	}
	/**
	 * 日期转换成标准的YYYYMMDD
	 * @param date
	 * @return String
	 * */
	public static String getNormalYYYYMMDDDate(Date date){
		return DateUtil.format(date,DateUtil.YYYYMMDD);
	}
	/**
	 * 毫秒转换成日期
	 * @param time
	 * @return Date
	 * */
	public static Date getDate(int time){
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = HSSFDateUtil.getJavaDate(time);//获取成DATE类型
          return dt ; 
	}
	/**
	 * 格式化数据库日期
	 * 
	 * @param date
	 * @return String
	 * */
	public static String getFormate(java.sql.Date date){
		if(date!=null){
			
			//DateUtil.
			return getNormalYYYYMMDDDate(date);
		}
		return null ;
	}
	/**
	 * 日期字符串转换成指定格式的日期
	 * 
	 * @param val
	 * @param patten
	 * @return String
	 * */
	public static String getYearMonth(String val ,String patten){
		if(!StringUtils.isEmpty(val)){
			try{
				String[] dateFormats = new String[]{
						"yyyy-MM",
						"yyyy年MM月",
						"yyyy/MM",
						"yyyyMM",
						"yyyy.MM",
						"yyyy年M月"
						
				};
				Date date = DateUtils.parseDate(val, dateFormats) ;
				
				String val2 = format(date,patten) ;
				return val2 ;
			}catch(Exception e){
				e.printStackTrace() ;
			}
	
		}
		return null ;
	}
	/**
	 * 判断日期是否是合法的年月格式
	 * 
	 * @param val
	 * @return boolean
	 * */
	public static boolean isYearMonth(String val){
		if(val.length()>=6){
			String newVal = val ;
			newVal = newVal.replaceAll("-", "");
			newVal = newVal.replaceAll("年", "");
			newVal = newVal.replaceAll("月", "");
			//newVal = newVal.replaceAll("日", "");
			newVal = newVal.replaceAll("/", "");
			newVal = newVal.replaceAll("\\.", "");
			if(newVal.length()>6){
				return false ;
			}
			if(NumberUtils.isNumber(newVal)){
				try{
					String[] dateFormats = new String[]{
							"yyyy-MM",
							"yyyy年MM月",
							"yyyy/MM",
							"yyyyMM",
							"yyyy.MM",
							"yyyy年M月"
							
					};
					Date date = DateUtils.parseDate(val, dateFormats) ;
					
					String val2 = format(date,"yyyyMM") ;
					String val3 = format(date,"yyyyM") ;
					if(!newVal.equals(val2)&&!newVal.equals(val3)){
						return false ;
					}
					
					return true ;
				}catch(Exception e){
					e.printStackTrace() ;
				}
		
			}
		}
		return false ;
	}
	/**
	 * 日期字符串转换成日期对象
	 * 
	 * @param dataVal
	 * @return Date
	 * */
	public static Date getDate(String dataVal){
		String str = dataVal;
		
		if(str!=null){
			String newVal = dataVal ;
			if(dataVal.length()>8){
				newVal = newVal.replaceAll("-", "");
				newVal = newVal.replaceAll("年", "");
				newVal = newVal.replaceAll("月", "");
				newVal = newVal.replaceAll("日", "");
				newVal = newVal.replaceAll("/", "");
				newVal = newVal.replaceAll("\\.", "");
				
			}
			try{
				String[] dateFormats = new String[]{
						"yyyy-MM-dd",
						"yyyy年MM月dd日",
						"yyyy/MM/dd",
						"yyyyMMdd",
						"yyyy.MM.dd"
				};
				Date date = DateUtils.parseDate(str, dateFormats) ;
				
				String val = format(date,"yyyyMMdd") ;
				if(!newVal.equals(val)){
					return null ;
				}
				
				return date ;
			}catch(Exception e){
				e.printStackTrace() ;
			}
		} 
		return null ;
	}
	/**
	 * 判断当前日期是否在有效日期内
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return boolean
	 * */
	public static boolean isValidDate(String beginDate,String endDate){
		Date cDate =getCurrentDateNoTime();
		Date bDate =DateUtil.getDate(beginDate);
		Date eDate =DateUtil.getDate(endDate);
		if(cDate.after(bDate)&&cDate.before(eDate)){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
//		DateUtil.getNormalDate(DateUtil
//				.getDate("20151301"));
		String time = DateUtil.getCurrentTime() ;
		System.out.println(time);
	}
	
}
