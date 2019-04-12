package com.hl.recruit.dao;

import com.hl.recruit.entity.EmpRelCom;
import org.springframework.stereotype.Repository;

/**
 * EmpRelComMapper interface
 *
 * @author hl.she
 * @date 2019/03/27
 */
@Repository
public interface EmpRelComMapper{

    /**
     * 添加关联
     * @param empRelCom
     * @return
     */
     int addRel(EmpRelCom empRelCom);

    /**
     * 删除关联
     * @param empRelCom
     * @return
     */
     int delRel(EmpRelCom empRelCom);

    /**
     * 修改关联-审核-状态
     * @param empRelCom
     * @return
     */
     int updateRelStatus(EmpRelCom empRelCom);




}
