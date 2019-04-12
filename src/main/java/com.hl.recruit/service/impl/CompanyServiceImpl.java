package com.hl.recruit.service.impl;

import com.hl.recruit.dao.CompanyMapper;
import com.hl.recruit.dto.UserComDto;
import com.hl.recruit.entity.CompanyEntity;
import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.service.CompanyService;
import com.hl.recruit.util.DateUtil;
import com.hl.recruit.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CompanyServiceImpl class
 *
 * @author hl.she
 * @date 2019/03/08
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;


    @Override
    public List<CompanyEntity> queryAllCompany() {
        return companyMapper.queryAllCompany();
    }

    @Override
    public List<CompanyEntity> queryPageCompany(Page page, Map maps) {
        return companyMapper.queryPageCompany(page,maps);
    }

    @Override
    public List<UserComDto> queryUserComDetail(Map maps) {
       return companyMapper.queryUserComDetail(maps);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteCompanyById(CompanyEntity companyEntity) {
        int count = companyMapper.deleteCompanyById(companyEntity);
        if(count > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCompanyById(CompanyEntity companyEntity) {
        int count = companyMapper.updateCompanyById(companyEntity);
        if(count > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addCompany(CompanyEntity companyEntity) {
        int count = companyMapper.addCompany(companyEntity);
        if(count > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean doCompany(CompanyEntity companyEntity, UserEntity userEntity) {
        Map maps = new HashMap<String,String>();
        maps.put("userId",userEntity.getUserId());
        companyEntity.setUserId(userEntity.getUserId());
        companyEntity.setCreateTime(DateUtil.getCurrentTime());
        List<CompanyEntity> companyList = queryCompanyById(maps);
        if(companyList == null || companyList.size() == 0){
          return addCompany(companyEntity);
        }else{
            return updateCompanyById(companyEntity);
        }
    }

    @Override
    public List<CompanyEntity> queryCompanyById(Map maps) {
        return companyMapper.queryCompanyById(maps);
    }
}
