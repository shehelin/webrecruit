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

}
