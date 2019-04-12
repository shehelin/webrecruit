package com.hl.recruit.dao;

import com.hl.recruit.dto.UserComDto;
import com.hl.recruit.entity.CompanyEntity;
import com.hl.recruit.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CompanyMapper interface
 *
 * @author hl.she
 * @date 2019/03/27
 */
@Repository
public interface CompanyMapper {

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
    int deleteCompanyById(CompanyEntity companyEntity);

    /**
     * 修改企业信息
     * @param companyEntity userId
     * @return
     */
    int updateCompanyById(CompanyEntity companyEntity);

    /**
     * 增加企业信息
     * @param companyEntity userId,comId
     * @return
     */
    int addCompany(CompanyEntity companyEntity);

    /**
     * 企业信息count
     * @return
     */
    int queryCompanyCount();

    /**
     * 企业信息byId
     * @param maps
     * @return
     */
    List<CompanyEntity> queryCompanyById(Map maps);
}

