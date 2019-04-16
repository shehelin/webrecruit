package com.hl.recruit.dao;

import com.hl.recruit.entity.AreaDistrict;
import com.hl.recruit.entity.Dict;
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


    /**
     * 获取数据字典类型
     * @param maps
     * @return
     */
    List<Dict> queryDictType(Map maps);

    /**
     * 获取数据字典值
     * @param maps
     * @return
     */
    List<Dict> queryDict(Map maps);

    /**
     * 添加字典类型
     * @param dict
     * @return
     */
    int addDictType(Dict dict);

    /**
     * 添加字典值
     * @param dict
     * @return
     */
    int addDict(Dict dict);

    /**
     * 删除字典类型
     * @param dict
     * @return
     */
    int delDictType(Dict dict);

    /**
     * 删除字典值
     * @param dict
     * @return
     */
    int delDict(Dict dict);

}
