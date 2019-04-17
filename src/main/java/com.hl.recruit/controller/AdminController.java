package com.hl.recruit.controller;

import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.service.UserService;
import com.hl.recruit.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * AdminController class
 *
 * @author hl.she
 * @date 2019/04/04
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	UserService userService;
	
	/**
	 * 进入首页
	 * @return
	 */
	@RequestMapping(value = "/goMain")
	public ModelAndView goMain() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/main");
		return view;
	}
	/**
	 * 进入数据录入页面
	 * @return
	 */
	@RequestMapping(value = "/goCompany")
	public ModelAndView goCompany() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/companyManager");
		return view;
	}
	/**
	 * 进入数据录入页面
	 * @return
	 */
	@RequestMapping(value = "/goRecruit")
	public ModelAndView goRecruit() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/recruitManager");
		return view;
	}

	/**
	 * 基础信息管理
	 * @return
	 */
	@RequestMapping(value = "/goDict")
	public ModelAndView goInfos() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/DictInfos");
		return view;
	}



	/**
	 * 退出
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView logout() {
		UserEntity user = UserUtil.getUser();
		if(user!=null) {
			// 记录退出		
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}
	
//	@ResponseBody
//	@RequestMapping(value="findComList")
//	public JqueryDto findComList(HttpServletRequest request, HttpServletResponse response, String param){
//
////	Company  c=companyService.findByUid(user.getId());
//
//	//查询分数LIST
//	Pager pager = PagerUtils.getPager(request);
//
//		return userService.findAllCompanys(pager, param);
//	}

	/**
	 * 用户信息管理-TODO-分页
	 * @param userEntity
	 * @return
	 */
	@RequestMapping("/findUser")
	@ResponseBody
	public UserEntity findUser(UserEntity userEntity) {
		return userService.queryUser(userEntity);
	}



//	//查询分数LIST
//	Pager	pager = PagerUtils.getPager(request);
//
//		return userService.findAllEmps(pager,param);
//	}
//
}
