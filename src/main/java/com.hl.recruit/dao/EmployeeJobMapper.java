package com.hl.recruit.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hl.recruit.dto.EmpRelComDto;
import com.hl.recruit.entity.EmployeeJobEntity;
import com.hl.recruit.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * EmployeeJobMapper interface
 *
 * @author hl.she
 * @date 2019/03/27
 */
@Repository
public interface EmployeeJobMapper {

    /**
     * 增加求职信息
     * @param employeeJobEntity
     * @return
     */
    int addEmployeeJob(EmployeeJobEntity employeeJobEntity);

    /**
     * 删除求职信息
     * @param empId
     * @return
     */
    int delEmployeeJob(String empId);

    /**
     * 修改求职信息
     * @param employeeJobEntity
     * @return
     */
    int updateEmployeeJob(EmployeeJobEntity employeeJobEntity);

    /**
     * 查询求职信息
     * @param maps
     * @return
     */
    List<EmpRelComDto> queryEmployeeJob(Map maps, PageBounds pageBounds);

    /**
     * 关联企业的应聘信息
     * @param maps
     * @return
     */
    List<EmpRelComDto> queryEmpRelCompany(Map maps, PageBounds pageBounds);

    /**
     * 查询记录数
     * @param maps
     * @return
     */
    int queryEmpCount(Map maps);



}
