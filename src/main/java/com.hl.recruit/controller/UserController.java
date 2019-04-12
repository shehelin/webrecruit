package com.hl.recruit.controller;

import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * UserController class
 *
 * @author hl.she
 * @date 2019/03/08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService ;

    @RequestMapping(value = "/updatePwd")
    public ModelAndView updatePwd(){
        ModelAndView view = new ModelAndView();
        view.setViewName("user/updatePwd");
        return view;
    }

    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUser(){
        ModelAndView view = new ModelAndView();
        view.setViewName("user/updateUser");
        return view;
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public boolean userRegister(UserEntity user){
       return userService.reigisterUser(user);
    }

    @RequestMapping("/doUpdateUser")
    @ResponseBody
    public boolean doUpdateUser(UserEntity user){
        return userService.updateUserById(user);
    }

    @RequestMapping("/doUpdatePwd")
    @ResponseBody
    public boolean updatePwd(UserEntity user){
        return userService.updatePwd(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(UserEntity user){
        return userService.deleteUserById(user);
    }


    @RequestMapping("/queryUserById")
    @ResponseBody
    public UserEntity queryUserById(UserEntity user, HttpServletRequest request){
        user = userService.queryUserById(user);
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user",user);
        return user;
    }

}
