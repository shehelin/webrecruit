package com.hl.recruit.controller;

import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.service.impl.UserServiceImpl;
import com.hl.recruit.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
/**
 * LoginController class
 *
 * @author hl.she
 * @date 2019/04/04
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserServiceImpl userService ;

    /**
     * user/login
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView enterPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("login/login");
        return view;
    }

    /**
     * 进入首页
     * @return
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        ModelAndView view = new ModelAndView();
        view.setViewName("index/index");
        return view;
    }

/**
     * admin/login.jsp
     * @return
     */
    @RequestMapping(value = "/admin")
    public ModelAndView goAdminLogin() {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/login");
        return view;
    }

    /**
     * admin/login.jsp
     * @return
     */
    @RequestMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView view = new ModelAndView();
        view.setViewName("register/register");
        return view;
    }



    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse userLogin(UserEntity user, HttpServletRequest request){
        BaseResponse baseResponse=new BaseResponse();
        try {
            user = userService.login(user);
            if(user !=null){
                baseResponse.setStatus(200);
                request.getSession().setAttribute("user", user);
                baseResponse.setContent(user);
            }else{
                baseResponse.setStatus(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.STATUS_500;
        }
        return baseResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/doAdminLogin", method = RequestMethod.POST)
    public BaseResponse doAdminLogin(HttpServletRequest request,UserEntity user) {
        BaseResponse baseResponse=new BaseResponse();
        try {
            user = userService.login(user);
            if(user !=null){
                baseResponse.setStatus(200);
                request.getSession().setAttribute("user", user);
                baseResponse.setContent(user);
            }else{
                baseResponse.setStatus(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.STATUS_500;
        }
        return baseResponse;
    }
}



//    BaseResponse baseResponse=new BaseResponse();
////        Subject currentUser = SecurityUtils.getSubject();
////        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserId(), user.getPwd());
////        token.setRememberMe(false);
//  try {
////            currentUser.login(token);
//          if(userService.login(user)==null){
//          baseResponse.setStatus(401);
//          }
//          } catch (Exception e) {
//          e.printStackTrace();
//          return BaseResponse.STATUS_500;
//          }
////
////        if(currentUser.isAuthenticated()){
////            user = userService.queryUserById(user);
////            currentUser.getSession().setAttribute("user", user);
////            baseResponse.setStatus(200);
////
////        }
//          if(currentUser.isAuthenticated()){
//          user = userService.queryUserById(user);
//          currentUser.getSession().setAttribute("user", user);
//          baseResponse.setStatus(200);
//
//          }
//          baseResponse.setContent(user);
//          return baseResponse;