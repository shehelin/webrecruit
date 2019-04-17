package com.hl.recruit.service;

import com.hl.recruit.dto.UserComDto;
import com.hl.recruit.entity.RecruitEntity;
import com.hl.recruit.util.Page;

import java.util.List;
import java.util.Map;

public interface RecruitService {
    /**
     * 增加招聘信息
     * @param recruitEntity
     * @return
     */
    boolean addRecruit(RecruitEntity recruitEntity);

    /**
     * 删除招聘信息
     * @param recruitEntity
     * @return
     */
    boolean delRecruit(RecruitEntity recruitEntity);

    /**
     * 修改招聘信息
     * @param recruitEntity
     * @return
     */
    boolean updateRecruit(RecruitEntity recruitEntity);

    /**
     * 分页查询招聘信息
     * @param page
     * @param maps
     * @return
     */
    List<UserComDto> queryRecruit(Page page, Map maps);

    /**
     * 查询详情信息
     * @param maps
     * @return
     */
    List<UserComDto> queryRecruitDetail(Map maps);

    /**
     * 查询页数
     * @param maps
     * @return
     */
    int queryRecruitCount(Map maps);

    /**
     * 分页查询招聘信息-企业
     * @param page
     * @param maps
     * @return
     */
    List<UserComDto> queryMyRecruit(Page page, Map maps);

    /**
     * 2019-04-17
     *  修改审核状态
     * @param recruitEntity
     * @return
     */
    boolean updateStatus(RecruitEntity recruitEntity);



    /**
     * 自动查询过期的时间
     * @return
     */
    void AutoQueryEndTime();


}
