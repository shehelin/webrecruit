package com.hl.recruit.controller;

import com.hl.recruit.entity.EmpRelCom;
import com.hl.recruit.entity.EmployeeJobEntity;
import com.hl.recruit.service.impl.EmployeeJobServiceImpl;
import com.hl.recruit.util.DataFinalStaticUtil;
import com.hl.recruit.util.Page;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EmployeeJobController class
 *
 * @author hl.she
 * @date 2019/04/04
 */
@Controller
@RequestMapping("/employeeJob")
public class EmployeeJobController {

    @Autowired
    private EmployeeJobServiceImpl employeeJobService;

    @RequestMapping("/employeeUser")
    public ModelAndView employeeUser(){
        ModelAndView view = new ModelAndView();
        view.setViewName("employeeJob/employeeUser");
        return view;
    }

    @RequestMapping("/employeeCompany")
    public ModelAndView employeeCompany(){
        ModelAndView view = new ModelAndView();
        view.setViewName("employeeJob/employeeCompany");
        return view;
    }

    @RequestMapping("/addEmployeeView")
    public ModelAndView addEmployeeView(){
        ModelAndView view = new ModelAndView();
        view.setViewName("employeeJob/addEmployee");
        return view;
    }

    @RequestMapping("/addEmployeeJob")
    @ResponseBody
    public boolean addEmployeeJob(EmployeeJobEntity employeeJobEntity, EmpRelCom empRelCom){
        try{
           return employeeJobService.addEmployeeJob(employeeJobEntity,empRelCom);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/queryEmployeeJob")
    @ResponseBody
    public Map queryEmployeeJob(@RequestParam Map<String,Object> maps, Page page){
        String pageIndex = maps.get("page").toString();
        String pageSize  = maps.get("limit").toString();
        int index = Integer.parseInt(pageIndex);
        int size =Integer.parseInt(pageSize);
        page.setPageIndex(index-1);
        page.setPageSize(size);
        List list = employeeJobService.queryEmployeeJob(maps,page);
        Map map = new HashMap<String,Object>(4);
        map.put("code",0);
        map.put("data",list);
        map.put("msg","");
        map.put("count",page.getTotalCount());
        return map;
    }

    @RequestMapping("/queryEmpRelCompany")
    @ResponseBody
    public Map queryEmpRelCompany(@RequestParam Map<String,Object> maps,Page page,HttpServletRequest request){
        String pageIndex = maps.get("page").toString();
        String pageSize  = maps.get("limit").toString();
        int index = Integer.parseInt(pageIndex);
        int size =Integer.parseInt(pageSize);
        page.setPageIndex(index-1);
        page.setPageSize(size);
        List list = employeeJobService.queryEmpRelCompany(maps,page);
        Map map = new HashMap<String,Object>(4);
        map.put("code",0);
        map.put("data",list);
        map.put("msg","");
        map.put("count",page.getTotalCount());
        return map;
    }

    @RequestMapping("/updateEmployeeJob")
    @ResponseBody
    public boolean updateEmployeeJob(EmployeeJobEntity employeeJobEntity) {
        return false;
    }

    @RequestMapping("/delEmployeeJob")
    @ResponseBody
    public boolean delEmployeeJob(String empId){
        try{
            return employeeJobService.delEmployeeJob(empId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @RequestMapping("/updateRelStatus")
    @ResponseBody
    public boolean updateRelStatus(EmpRelCom empRelCom) {
        if(empRelCom.getStatus().equals("1")){
            empRelCom.setStatus(DataFinalStaticUtil.EMP_COM_REL_STATUS_1);
        }else if(empRelCom.getStatus().equals("2")){
            empRelCom.setStatus(DataFinalStaticUtil.EMP_COM_REL_STATUS_2);
        }
        return employeeJobService.updateRelStatus(empRelCom);
    }

}
