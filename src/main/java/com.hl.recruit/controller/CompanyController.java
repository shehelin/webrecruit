package com.hl.recruit.controller;

import com.hl.recruit.entity.CompanyEntity;
import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.service.impl.CompanyServiceImpl;
import com.hl.recruit.util.BaseResponse;
import com.hl.recruit.util.Page;
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
 * CompanyController class
 *
 * @author hl.she
 * @date 2019/04/04
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;

    @RequestMapping("/")
    public ModelAndView company(){
        ModelAndView view = new ModelAndView();
        view.setViewName("company/company");
        return view;
    }

    @RequestMapping("/doCompany")
    @ResponseBody
    public BaseResponse doCompany(CompanyEntity companyEntity, HttpServletRequest request){
        BaseResponse baseResponse = new BaseResponse();
        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("user");
        if(companyService.doCompany(companyEntity,userEntity)){
            baseResponse.setStatus(200);
        }else{
            baseResponse.setStatus(400);
        }
        return baseResponse;
    }

    @RequestMapping("/queryCompanyById")
    @ResponseBody
    public List<CompanyEntity> queryCompany(HttpServletRequest request){
        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("user");
        Map<String,String> maps = new HashMap();
        maps.put("userId", userEntity.getUserId());
        List<CompanyEntity> companyList = companyService.queryCompanyById(maps);
        return companyList;
    }


    /**
     * 企业管理
     * @param maps
     * @param page
     * @return
     */
    @RequestMapping("/queryPageCompany")
    @ResponseBody
    public Map queryPageCompany(Map maps, Page page){
        String pageIndex = maps.get("page").toString();
        String pageSize  = maps.get("limit").toString();
        int index = Integer.parseInt(pageIndex);
        int size =Integer.parseInt(pageSize);
        page.setPageIndex(index-1);
        page.setPageSize(size);
        List<CompanyEntity> list = companyService.queryPageCompany(page,maps);
        Map map = new HashMap<String,Object>(4);
        map.put("code",0);
        map.put("data",list);
        map.put("msg","");
        map.put("count",page.getTotalCount());
        return map;
    }

}
