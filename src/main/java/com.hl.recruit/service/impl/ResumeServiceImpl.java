package com.hl.recruit.service.impl;

import com.hl.recruit.dao.ResumeMapper;
import com.hl.recruit.entity.ResumeEntity;
import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.util.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * ResumeServiceImpl class
 *
 * @author hl.she
 * @date 2019/04/07
 */
@Service
public class ResumeServiceImpl {
    @Autowired
    ResumeMapper resumeMapper;

    private final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

    /**
     * 增加简历信息
     * @param resumeEntity
     * @return
     */
    public boolean addResume(ResumeEntity resumeEntity, UserEntity userEntity){
        try {
            resumeEntity.setResumeId(Util.uuid());
            resumeEntity.setUserId(userEntity.getUserId());
            resumeEntity.setName(userEntity.getRealName());
            resumeEntity.setSex(userEntity.getSex());
            resumeEntity.setPhone(userEntity.getPhone());
            resumeEntity.setEmail(userEntity.getEmail());
            int count =  resumeMapper.addResume(resumeEntity);
            if (count>0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
          LOGGER.error(e.getMessage());
          return false;
        }
        return false;
    }

    /**
     * 修改简历信息
     * @param resumeEntity
     * @return
     */
    public boolean updateResume(ResumeEntity resumeEntity){
        try{
            int count = resumeMapper.updateResume(resumeEntity);
            if(count > 0){
                return true;
            }
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return false;
        }
        return false;

    }

    /**
     * 简历信息
     * @param maps
     * @return
     */
    public List<ResumeEntity> queryResume(Map maps,UserEntity userEntity){
        boolean flag = false;
        if(queryResumeCountById(userEntity.getUserId()) == 0){
            ResumeEntity resumeEntity = new ResumeEntity();
            try{
              addResume(resumeEntity,userEntity);
            }catch (Exception e){
                e.printStackTrace();
                LOGGER.error(e.getMessage());
            }

        }
        return resumeMapper.queryResume(maps);
    }

    /**
     * 查询简历总记录
     * @return
     */
    public int queryResumeCount(){
        return resumeMapper.queryResumeCount();
    }

    public int queryResumeCountById(String userId){
        return resumeMapper.queryResumeCountById(userId);
    }

    /**
     * 操作简历，没有添加，有修改
     * @return x
     */
    public boolean  setResume(ResumeEntity resumeEntity, UserEntity userEntity){
        boolean flag = false;
        if(queryResumeCountById(userEntity.getUserId()) == 0){
          flag =  addResume(resumeEntity,userEntity);
        }else{
            flag =  updateResume(resumeEntity);
        }

         return flag;
    }

    /**
     * 根据Id查询简历
     * @param maps
     * @return
     */
    public List<ResumeEntity> queryResumeById(Map maps) {
        return resumeMapper.queryResume(maps);
    }
}
