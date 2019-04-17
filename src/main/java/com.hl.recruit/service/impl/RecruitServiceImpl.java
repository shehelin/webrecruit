package com.hl.recruit.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hl.recruit.dao.RecruitMapper;
import com.hl.recruit.dto.UserComDto;
import com.hl.recruit.entity.RecruitEntity;
import com.hl.recruit.service.RecruitService;
import com.hl.recruit.util.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

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

    private static final Logger logger = Logger.getLogger(RecruitServiceImpl.class);
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
    public List<UserComDto> queryMyRecruit(Page page, Map maps) {
        try {
            PageBounds pageBounds = page.toPageBounds();
            if(maps.containsKey("beginTime") && maps.containsKey("endTime")){
                if(maps.get("beginTime").toString().compareTo(maps.get("endTime").toString())>0){
                    return new ArrayList<UserComDto>();
                }
            }
            List list = recruitMapper.queryMyRecruit(maps,pageBounds);
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



    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateStatus(RecruitEntity recruitEntity) {
       int count = 0;

       count += recruitMapper.updateStatus(recruitEntity) ;
       count += recruitMapper.updateValid(recruitEntity) ;
       if(count == 2){
           return true;
       }else{
            return false;
       }
    }

    @Override
    @Scheduled(cron="0 0 0 * * ?") //每天凌晨0点自动扫描到期任务
    @Transactional(rollbackFor = Exception.class)
    public void AutoQueryEndTime() {
        try{
            logger.info("开始扫描招聘到期时间任务");
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String localTime = format.format(date);
            Date localDate = format.parse(localTime);
            List<RecruitEntity> list = recruitMapper.queryEndTime();
            for(RecruitEntity recruit : list){
                Date endTime = format.parse(recruit.getEndTime());
                if(localDate.compareTo(endTime) <= 0){ continue; }
                recruit.setValid("2");
                recruitMapper.updateValid(recruit);
            }
            logger.info("-----------扫描结束");
        }catch (Exception e){
            logger.info("报错-----"+e.getMessage());
        }
    }


}
