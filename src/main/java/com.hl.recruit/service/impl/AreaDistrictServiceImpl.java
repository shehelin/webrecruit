package com.hl.recruit.service.impl;

import com.hl.recruit.dao.AreaDistrictMapper;
import com.hl.recruit.entity.AreaDistrict;
import com.hl.recruit.entity.Dict;
import com.hl.recruit.service.AreaDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AreaDistrictServiceImpl implements AreaDistrictService {

    @Autowired
    AreaDistrictMapper areaDistrictMapper;

    @Override
    public List<AreaDistrict> queryProvince() {
        return areaDistrictMapper.queryProvince();
    }

    @Override
    public List<AreaDistrict> queryCity(Map maps) {
       return areaDistrictMapper.queryCity(maps);
    }

    @Override
    public List<AreaDistrict> queryTown(Map maps) {
       return areaDistrictMapper.queryTown(maps);
    }

    @Override
    public boolean addDictType(Dict dict) {
        try{
            return areaDistrictMapper.addDictType(dict) > 0 ? true:false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addDict(Dict dict) {
        try{
            return areaDistrictMapper.addDict(dict) > 0 ? true:false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delDictType(Dict dict) {
        try{

            if( areaDistrictMapper.delDictType(dict) > 0 ? true:false){
                return areaDistrictMapper.delDict(dict)>0?true:false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }


    @Override
    public List<Dict> queryDictType(Map maps) {
        try{
            return areaDistrictMapper.queryDictType(maps);
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<Dict>();
        }

    }

    @Override
    public List<Dict> queryDict(Map maps) {
        try{
            return areaDistrictMapper.queryDict(maps);
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<Dict>();
        }
    }
}
