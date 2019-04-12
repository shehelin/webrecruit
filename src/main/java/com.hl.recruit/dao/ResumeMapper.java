package com.hl.recruit.dao;

import com.hl.recruit.entity.ResumeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ResumeMapper interface
 *
 * @author hl.she
 * @date 2019/03/27
 */
@Repository
public interface ResumeMapper {
    /**
     * 增加简历信息
     * @param resumeEntity
     * @return
     */
    int addResume(ResumeEntity resumeEntity);

    /**
     * 删除简历信息
     * @param resumeEntity
     * @return
     */
    int delResume(ResumeEntity resumeEntity);

    /**
     * 修改简历信息
     * @param resumeEntity
     * @return
     */
    int updateResume(ResumeEntity resumeEntity);

    /**
     * 简历信息
     * @param maps
     * @return
     */
    List<ResumeEntity> queryResume(Map maps);

    /**
     * 查询简历总记录
     * @return
     */
    int queryResumeCount();

    /**
     * 插简历是否存在
     * @param userId
     * @return
     */
    int queryResumeCountById(String userId);
}
