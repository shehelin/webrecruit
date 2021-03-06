package com.hl.recruit.controller;

import com.hl.recruit.entity.AreaDistrict;
import com.hl.recruit.entity.Dict;
import com.hl.recruit.service.impl.AreaDistrictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区域字典
 * --数据字典
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


    @RequestMapping("/queryDictType")
    @ResponseBody
    public List<Dict> queryDictType(@RequestParam Map<String,Object> maps){
        return areaDistrictService.queryDictType(maps);
    }

    @RequestMapping("/queryDictTypes")
    @ResponseBody
    public Map queryDictTypes(@RequestParam Map<String,Object> maps){
        List<Dict> dictTypeList = areaDistrictService.queryDictType(maps);
        Map map = new HashMap<String,Object>(4);
        map.put("code",0);
        map.put("data",dictTypeList);
        map.put("msg","");
        return map;
    }

    @RequestMapping("/queryDict")
    @ResponseBody
    public List<Dict> queryDict(@RequestParam Map<String,Object> maps){
        return areaDistrictService.queryDict(maps);
    }

    @RequestMapping("/queryDicts")
    @ResponseBody
    public Map queryDicts(@RequestParam Map<String,Object> maps){
        List<Dict> dictList = areaDistrictService.queryDict(maps);
        Map map = new HashMap<String,Object>(4);
        map.put("code",0);
        map.put("data",dictList);
        map.put("msg","");
        return map;
    }

    @RequestMapping("/addDictType")
    @ResponseBody
    public boolean addDictType(Dict dict){
        return areaDistrictService.addDictType(dict);
    }

    @RequestMapping("/addDict")
    @ResponseBody
    public boolean addDict(Dict dict){
        return areaDistrictService.addDict(dict);
    }

    @RequestMapping("/delDictType")
    @ResponseBody
    public boolean delDictType(Dict dict){
        return areaDistrictService.delDictType(dict);
    }



}
