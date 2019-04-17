package com.hl.recruit.service;

import com.hl.recruit.dto.UserComDto;
import com.hl.recruit.entity.CompanyEntity;
import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.util.Page;

import java.util.List;
import java.util.Map;

/**
 * CompanyService interface
 *
 * @author hl.she
 * @date 2019/03/27
 */
public interface CompanyService {
    /**
     * all
     * @return
     */
    List<CompanyEntity> queryAllCompany();

    /**
     * 条件查询
     * @param page
     * @param maps
     * @return
     */
    List<CompanyEntity> queryPageCompany(Page page, Map maps);

    /**
     * 结合user-Com详情
     * @param maps
     * @return
     */
    List<UserComDto> queryUserComDetail(Map maps);

    /**
     * 删除企业信息
     * @param companyEntity userId,comId
     * @return
     */
    boolean deleteCompanyById(CompanyEntity companyEntity);

    /**
     * 修改企业信息
     * @param companyEntity userId
     * @return
     */
    boolean updateCompanyById(CompanyEntity companyEntity);

    /**
     * 增加企业信息
     * @param companyEntity userId,comId
     * @return
     */
    boolean addCompany(CompanyEntity companyEntity);

    /**
     * 增-改整合
     * @param companyEntity
     * @param userEntity
     * @return
     */
    boolean doCompany(CompanyEntity companyEntity, UserEntity userEntity);

    /**
     * 查询单个企业信息
     * @return
     */
    List<CompanyEntity> queryCompanyById(Map maps);

    int queryCompanyCount(Map maps);


    /**
     *  修改审核状态
     * @param companyEntity
     * @return
     */
    boolean updateStatus(CompanyEntity companyEntity);

}
