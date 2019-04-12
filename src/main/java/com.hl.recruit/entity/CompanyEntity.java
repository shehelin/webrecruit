package com.hl.recruit.entity;

import java.io.Serializable;

/**
 * CompanyEntity class
 * 企业信息
 * @author hl.she
 * @date 2019/03/26
 */
public class CompanyEntity implements Serializable {
    private String comId;   //企业编号手写
    private String userId;  //关联企业用户
    private String comName; //企业名称
    private String comType; //企业类型
    private String comInfo; //企业信息
    private String remark;  //备注
    private String comAddress; //地址
    private String comTel;    //企业电话
    private String createTime; //创建时间

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getComInfo() {
        return comInfo;
    }

    public void setComInfo(String comInfo) {
        this.comInfo = comInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getComTel() {
        return comTel;
    }

    public void setComTel(String comTel) {
        this.comTel = comTel;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
