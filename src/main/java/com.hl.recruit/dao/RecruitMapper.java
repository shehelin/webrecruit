package com.hl.recruit.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hl.recruit.dto.UserComDto;
import com.hl.recruit.entity.RecruitEntity;
import com.hl.recruit.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * RecruitMapper interface
 *
 * @author hl.she
 * @date 2019/03/27
 */
@Repository
public interface RecruitMapper {
    /**
     * 增加招聘信息
     * @param recruitEntity
     * @return
     */
    int addRecruit(RecruitEntity recruitEntity);

    /**
     * 删除招聘信息
     * @param recruitEntity
     * @return
     */
    int delRecruit(RecruitEntity recruitEntity);

    /**
     * 修改招聘信息
     * @param recruitEntity
     * @return
     */
    int updateRecruit(RecruitEntity recruitEntity);

    /**
     * 分页查询招聘信息
     * @param pageBounds
     * @param maps
     * @return
     */
    List<UserComDto> queryRecruit(Map maps, PageBounds pageBounds);

    /**
     * 查询详情
     * @param maps
     * @return
     */
    List<UserComDto> queryRecruitDetail(Map maps);

    /**
     * 查询记录数
     * @param maps
     * @return
     */
    int queryRecruitCount(Map maps);

    /**
     * 分页查询招聘信息-企业用户
     * @param pageBounds
     * @param maps
     * @return
     */
    List<UserComDto> queryMyRecruit(Map maps, PageBounds pageBounds);


    /** 2019-04-17
     * 修改审核状态
     * @param recruitEntity
     * @return
     */
    int updateStatus(RecruitEntity recruitEntity);

    /**
     * 修改有效状态
     * @param recruitEntity
     * @return
     */
    int updateValid(RecruitEntity recruitEntity);

    /**
     * 查询过期的时间
     * @return
     */
    List<RecruitEntity> queryEndTime();

}
