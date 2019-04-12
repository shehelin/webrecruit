package com.hl.recruit.controller;

import com.hl.recruit.entity.ResumeEntity;
import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.service.impl.ResumeServiceImpl;
import com.hl.recruit.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ResumeController class
 *
 * @author hl.she
 * @date 2019/04/04
 */
@Controller
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    ResumeServiceImpl resumeService ;

    @RequestMapping("/")
    public ModelAndView resume(){
        ModelAndView view = new ModelAndView();
        view.setViewName("resume/resume");
        return view;
    }

    @RequestMapping("/setResume")
    @ResponseBody
    public BaseResponse setResume(ResumeEntity resumeEntity, HttpServletRequest request){
        BaseResponse baseResponse = new BaseResponse();
        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("user");
        if(resumeService.setResume(resumeEntity,userEntity)){
            baseResponse.setStatus(200);
        }else{
            baseResponse.setStatus(400);
        }
      return baseResponse;
    }

    @RequestMapping("/queryResume")
    @ResponseBody
    public Map queryResume(ResumeEntity resumeEntity, HttpServletRequest request){
        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("user");
        Map<String,String> maps = new HashMap();
        maps.put("userId", userEntity.getUserId());
        List<ResumeEntity> resumeList = resumeService.queryResume(maps,userEntity);
        Map<String,Object> map = new HashMap();
        map.put("data",resumeList);
        return map;
    }
}
