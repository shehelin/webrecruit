package com.hl.recruit.service.impl;

import com.hl.recruit.dao.AreaDistrictMapper;
import com.hl.recruit.entity.AreaDistrict;
import com.hl.recruit.service.AreaDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
}
