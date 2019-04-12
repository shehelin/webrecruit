/**
 * Copyright @ 2010-2015 Hex company All rights reserved
 * 系统名称：大数据平台二期
 * 模块名称：
 * @version版本信息：V1.0
 * @author:K0140
 * 
 */
package com.hl.recruit.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

/**
 * Copyright @ 2010-2015 Hex company All rights reserved
 * 系统名称：EtlMonitor
 * 模块名称：
 * @version版本信息：V1.0
 * @author:K0140
 * 
 */
public class WebApplicationContextUtil implements ApplicationContextAware {
    public static ApplicationContext getApplicationContext() {
        return WebApplicationContextUtil.applicationContext;
    }
    @Override
    public  void setApplicationContext(ApplicationContext applicationContext) {
        WebApplicationContextUtil.applicationContext = applicationContext;
    }

    private static ApplicationContext applicationContext;
	private static WebApplicationContext wac = null;
	/**
	 * 获取Spring容器
	 * @return
	 */
	public static WebApplicationContext getContext(){
		if(wac==null){
			wac = ContextLoader.getCurrentWebApplicationContext();
           String strs[] =wac.getBeanDefinitionNames() ;
            for(String str:strs){
                System.out.println( "Bean Name="+str );
            }
             //Object obj= wac.getBean("dictService") ;

          //  System.out.print( wac.containsBean("DictService") );
		}
		return wac;
	}
	/**
	 * 获取当前web的bean类
	 * @param beanId
	 * @return
	 */
	public static Object getBean(String beanId){

        //return getApplicationContext().getBean(beanId  ) ;
		return getContext().getBean(beanId) ;
	}
	/**
	 * 获取当前web的bean类n t
	 * @param
	 * @return
	 */
	public static Object getMessage(String property){
		return getContext().getMessage(property, null, Locale.CHINESE);
	}
	
}
