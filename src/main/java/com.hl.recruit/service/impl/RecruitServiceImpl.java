package com.hl.recruit.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hl.recruit.dao.RecruitMapper;
import com.hl.recruit.dto.UserComDto;
import com.hl.recruit.entity.RecruitEntity;
import com.hl.recruit.service.RecruitService;
import com.hl.recruit.util.DateUtil;
import com.hl.recruit.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * RecruitServiceImpl class
 *
 * @author hl.she
 * @date 2019/04/08
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    RecruitMapper recruitMapper;

    @Override
    public boolean addRecruit(RecruitEntity recruitEntity) {
        int count = 0;
        try{
            count = recruitMapper.addRecruit(recruitEntity);
            if(count > 0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean delRecruit(RecruitEntity recruitEntity) {
        int count = 0;
        try{
            count = recruitMapper.delRecruit(recruitEntity);
            if(count > 0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean updateRecruit(RecruitEntity recruitEntity) {
        int count = 0;
        try{
            count = recruitMapper.updateRecruit(recruitEntity);
            if(count > 0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public List<UserComDto> queryRecruit(Page page, Map maps) {
        try {
            PageBounds pageBounds = page.toPageBounds();
            if(maps.containsKey("beginTime") && maps.containsKey("endTime")){
                if(maps.get("beginTime").toString().compareTo(maps.get("endTime").toString())>0){
                    return new ArrayList<UserComDto>();
                }
            }
            List list = recruitMapper.queryRecruit(maps,pageBounds);
            page.setTotalCount(queryRecruitCount(maps));
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<UserComDto>();
        }
    }

    @Override
    public List<UserComDto> queryRecruitDetail(Map maps) {
        try {
            List list = recruitMapper.queryRecruitDetail(maps);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<UserComDto>();
        }
    }

    @Override
    public int queryRecruitCount(Map maps) {
        return recruitMapper.queryRecruitCount(maps);
    }

}
