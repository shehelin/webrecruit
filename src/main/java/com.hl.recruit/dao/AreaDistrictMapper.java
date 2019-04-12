package com.hl.recruit.dao;

import com.hl.recruit.entity.AreaDistrict;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AreaDistrictMapper {
    /**
     * 省 1级
     * @param
     * @return
     */
    List<AreaDistrict> queryProvince();

    /**
     * 市 2级
     * @param maps
     * @return
     */
    List<AreaDistrict> queryCity(Map maps);

    /**
     * 县区 3级
     * @return
     */
    List<AreaDistrict> queryTown(Map maps);
}
