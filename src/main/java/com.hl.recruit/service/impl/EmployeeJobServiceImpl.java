package com.hl.recruit.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hl.recruit.dao.EmpRelComMapper;
import com.hl.recruit.dao.EmployeeJobMapper;
import com.hl.recruit.dto.EmpRelComDto;
import com.hl.recruit.entity.EmpRelCom;
import com.hl.recruit.entity.EmployeeJobEntity;
import com.hl.recruit.service.EmployeeJobService;
import com.hl.recruit.util.DateUtil;
import com.hl.recruit.util.Page;
import com.hl.recruit.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * EmployeeJobServiceImpl class
 *
 * @author hl.she
 * @date 2019/04/11
 */
@Service
public class EmployeeJobServiceImpl implements EmployeeJobService {

    @Autowired
    private EmpRelComMapper empRelComMapper;
    @Autowired
    private EmployeeJobMapper employeeJobMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addEmployeeJob(EmployeeJobEntity employeeJobEntity, EmpRelCom empRelCom) throws Exception {
        String uuid = Util.uuid();
        employeeJobEntity.setEmpId(uuid);
        employeeJobEntity.setCreateTime(DateUtil.getCurrentTime());
        int count = employeeJobMapper.addEmployeeJob(employeeJobEntity);
        if (count > 0){
            empRelCom.setEmpId(uuid);
            empRelCom.setRelId(uuid);
            return addEmpRel(empRelCom);
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addEmpRel(EmpRelCom empRelCom) throws Exception{
        int count = empRelComMapper.addRel(empRelCom);
        if(count > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<EmpRelComDto> queryEmployeeJob(Map maps, Page page) {
        try {
            PageBounds pageBounds = page.toPageBounds();
            List list = employeeJobMapper.queryEmployeeJob(maps,pageBounds);
            page.setTotalCount(queryEmpCount(maps));
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<EmpRelComDto>();
        }
    }

    @Override
    public List<EmpRelComDto> queryEmpRelCompany(Map maps ,Page page) {
        try {
            PageBounds pageBounds = page.toPageBounds();
            List list = employeeJobMapper.queryEmpRelCompany(maps,pageBounds);
            page.setTotalCount(queryEmpCount(maps));
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<EmpRelComDto>();
        }
    }

    @Override
    public int queryEmpCount(Map maps) {
        return employeeJobMapper.queryEmpCount(maps);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delEmployeeJob(String empId) throws Exception{
              int count = employeeJobMapper.delEmployeeJob(empId);
              if(count > 0){
                 return delRel(empId);
               }
              return false;
    }

    @Override
    public boolean updateEmployeeJob(EmployeeJobEntity employeeJobEntity) {
        int count = 0;
        try{
            count = employeeJobMapper.updateEmployeeJob(employeeJobEntity);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        if(count > 0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delRel(String empId) throws Exception{
        int  count = empRelComMapper.delRel(empId);
        if(count > 0){
            return true ;
        }
        return false;
    }

    @Override
    public boolean updateRelStatus(EmpRelCom empRelCom) {
        int count = 0;
        try{
            count = empRelComMapper.updateRelStatus(empRelCom);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        if(count > 0){
            return true;
        }
        return false;
    }

}
