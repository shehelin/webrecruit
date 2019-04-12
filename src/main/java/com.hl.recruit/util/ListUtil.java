/**
 * Copyright @ 2010-2015 Hex company All rights reserved
 * 系统名称：DCP
 * 模块名称：
 * @version版本信息：V1.0
 * @author:jiewang
 * 
 */
package com.hl.recruit.util;

import java.util.*;

public class ListUtil {
	/**
	 * List去重
	 * @param list
	 * */
	public static void removeDuplicate(List list) {
		HashSet set = new HashSet(list);
		list.clear();
		list.addAll(set);

	}

	/**
	 * 判断是否为空
	 * @param lists
	 * @return boolean
	 * */
	public static boolean isEmpty(List[] lists) {
		//判断是否为空
		if (lists == null) {
			return true;
		}
		//循环
		for (List list : lists) {
			//判断是否为空，或size=0
			if (list == null || list.size() == 0) {
				return true;
			}
		}
        
		return false;
	}
	/**
	 * 判断是否为空
	 * @param list
	 * @return boolean
	 * */
	public static boolean isEmpty(List list) {
		//判断是否为空
		if (list == null||list.size()==0) {
			return true;
		}
		
		return false;
	}
	/**
	 * 判断是否为空
	 * @param list
	 * @return boolean
	 * */
	public static String[] listToStringArray(List<String> list) {
		//判断是否为空 
		if(isEmpty(list)){
			 return null;
		 }
		 String[] arrs = new String[list.size()];
		 list.toArray(arrs);
		 return arrs;
	}
	/**
	 * 判断是否存在该对象
	 * @param list
	 * @param value
	 * @return
	 */
	public static boolean contains(List list,Object value){
		//循环
		for(Object object:list){
			//判断
			if(object.equals(value)){
				return true;
			}
		}
		return false;
	}
	/**
	 * List对象相减
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List minus(List list1,List list2){
		List retList = new ArrayList<String>();
		//循环
		for(Object table:list1){
			//是否包含
			if(!ListUtil.contains(list2, table)){
				retList.add(table) ;
			}
		}
		return retList;
	}
	
	/**
	 * String类型的list　打印
	 * @param list
	 * 
	 * */
	public static void printList(List list){
		//循环
		for(Object obj:list){
			System.out.println(obj);
		}
	}
	/**
	 * List对象转换，把list对象内的值用map封装
	 * @param list
	 * @param key
	 * @return List
	 * */
    public static List List2Map(List list ,String key){
        List retList = new ArrayList() ;
        //循环
        for(Object obj:list){
            Map map = new HashMap();
            map.put(key,obj) ;
            retList.add(map);
        }
        return retList ;
    }
}
