package com.hl.recruit.service;

import com.hl.recruit.dto.EmpRelComDto;
import com.hl.recruit.entity.EmpRelCom;
import com.hl.recruit.entity.EmployeeJobEntity;
import com.hl.recruit.util.Page;

import java.util.List;
import java.util.Map;

/**
 * EmployeeJobService interface
 *
 * @author hl.seh
 * @date 2019/04/11
 */
public interface EmployeeJobService {

    /**
     * 添加申请求职信息功能
     * @param employeeJobEntity
     * @param empRelCom
     * @return
     * @throws Exception
     */
    boolean addEmployeeJob(EmployeeJobEntity employeeJobEntity, EmpRelCom empRelCom) throws Exception;

    /**
     * 添加申请职位映射关系
     * @param empRelCom
     * @return
     * @throws Exception
     */
    boolean addEmpRel(EmpRelCom empRelCom) throws Exception;

    /**
     * 查询求职信息
     * @param maps
     * @return
     */
    List<EmpRelComDto> queryEmployeeJob(Map maps, Page page);

    /**
     * 关联企业的应聘信息
     * @param maps
     * @return
     */
    List<EmpRelComDto> queryEmpRelCompany(Map maps, Page page);

    /**
     * 查询两种用户的的记录数
     * @param maps
     * @return
     */
    int queryEmpCount(Map maps);

    /**
     * 删除求职信息
     * @param empId
     * @return
     */
    boolean delEmployeeJob(String empId) throws Exception;

    /**
     * 修改求职信息
     * @param employeeJobEntity
     * @return
     */
    boolean updateEmployeeJob(EmployeeJobEntity employeeJobEntity) ;


    /**
     * 删除关联
     * @param empId
     * @return
     */
    boolean delRel(String empId) throws Exception;

    /**
     * 修改关联-审核-状态
     * @param empRelCom
     * @return
     */
    boolean updateRelStatus(EmpRelCom empRelCom);

}
