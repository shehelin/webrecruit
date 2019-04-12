package com.hl.recruit.controller;

import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.service.UserService;
import com.hl.recruit.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping(value = "/goAdmin")
	public ModelAndView enterPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/adminManager");
		return view;
	}
	/**
	 * 进入数据录入页面
	 * @return
	 */
	@RequestMapping(value = "/goEmps")
	public ModelAndView goEmps() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/emps");
		return view;
	}
	/**
	 * 进入数据录入页面
	 * @return
	 */
	@RequestMapping(value = "/goComs")
	public ModelAndView goComs() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/coms");
		return view;
	}
	
	@RequestMapping(value = "/goJobs")
	public ModelAndView goJobs() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/jobs");
		return view;
	}
	@RequestMapping(value = "/goInfos")
	public ModelAndView goInfos() {
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/infos");
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
//	@ResponseBody
//	@RequestMapping(value="findEmpList")
//	public JqueryDto findEmpList(HttpServletRequest request, HttpServletResponse response, String param){
//
////	Company  c=companyService.findByUid(user.getId());
//
//	//查询分数LIST
//	Pager	pager = PagerUtils.getPager(request);
//
//		return userService.findAllEmps(pager,param);
//	}
//
}
