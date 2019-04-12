package com.hl.recruit.controller;

import com.github.pagehelper.PageHelper;
import com.hl.recruit.dto.UserComDto;
import com.hl.recruit.entity.RecruitEntity;
import com.hl.recruit.service.RecruitService;
import com.hl.recruit.service.impl.RecruitServiceImpl;
import com.hl.recruit.util.DateUtil;
import com.hl.recruit.util.Page;
import com.hl.recruit.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RecruitController class
 *
 * @author hl.she
 * @date 2019/04/04
 */
@Controller
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    RecruitServiceImpl recruitService;

    @RequestMapping("/")
    public ModelAndView recruit(){
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/recruit");
        return view;
    }

    @RequestMapping("/my")
    public ModelAndView myRecruit(){
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/myRecruit");
        return view;
    }

    @RequestMapping("/queryRecruit")
    @ResponseBody
    public Map queryRecruit(@RequestParam Map<String,Object> maps, Page page, HttpServletRequest request){
         String pageIndex = request.getParameter("page");
         String pageSize  = request.getParameter("limit");
         int index = Integer.parseInt(pageIndex);
         int size =Integer.parseInt(pageSize);
        page.setPageIndex(index-1);
        page.setPageSize(size);
        List list = recruitService.queryRecruit(page,maps);
        Map map = new HashMap<String,Object>(4);
        map.put("code",0);
        map.put("data",list);
        map.put("msg","");
        map.put("count",page.getTotalCount());
        return map;
    }

    @RequestMapping("/queryRecruitById")
    @ResponseBody
    public List<UserComDto> queryRecruitById(@RequestParam Map<String,Object> maps, HttpServletRequest request){
        List list = recruitService.queryRecruitDetail(maps);
        return list;
    }

    @RequestMapping("/delRecruit")
    @ResponseBody
    public boolean delRecruit(RecruitEntity recruitEntity) {
       return recruitService.delRecruit(recruitEntity);
    }

    @RequestMapping("/updateRecruit")
    @ResponseBody
    public boolean updateRecruit(RecruitEntity recruitEntity) {
        return recruitService.updateRecruit(recruitEntity);
    }

    @RequestMapping("/addRecruit")
    @ResponseBody
    public boolean addRecruit(RecruitEntity recruitEntity) {
        recruitEntity.setRecruitId(Util.uuid());
        recruitEntity.setCreateTime(DateUtil.getCurrentTime());
        return recruitService.addRecruit(recruitEntity);
    }
}
