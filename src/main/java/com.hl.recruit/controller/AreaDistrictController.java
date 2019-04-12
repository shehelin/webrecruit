package com.hl.recruit.controller;

import com.hl.recruit.entity.AreaDistrict;
import com.hl.recruit.service.impl.AreaDistrictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区域字典
 *
 */
@RequestMapping("/areaDict")
@Controller
public class AreaDistrictController {

    @Autowired
    AreaDistrictServiceImpl areaDistrictService;

    @RequestMapping("/queryProvince")
    @ResponseBody
    public List<AreaDistrict> queryProvince(){
       return areaDistrictService.queryProvince();
    }

    @RequestMapping("/queryCity")
    @ResponseBody
    public List<AreaDistrict> queryCity(@RequestParam Map<String,Object> maps){

        return areaDistrictService.queryCity(maps);
    }

    @RequestMapping("/queryTown")
    @ResponseBody
    public List<AreaDistrict> queryTown(@RequestParam Map<String,Object> maps){
        return areaDistrictService.queryTown(maps);
    }

}
