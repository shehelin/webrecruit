package com.hl.recruit.entity;

import java.io.Serializable;

/**
 * 地区字典
 * @author hl.she
 * 2019-04-04
 */
public class AreaDistrict implements Serializable {
    private String id;
    private String pId;
    private String district;
    private String level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
