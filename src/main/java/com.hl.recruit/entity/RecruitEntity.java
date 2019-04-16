package com.hl.recruit.entity;

import java.io.Serializable;

/**
 * RecruitEntity class
 * 招聘信息
 * @author hl.she
 * @date 2019/03/26
 */
public class RecruitEntity implements Serializable {
    private String recruitId;                    //招聘信息id
    private String userId;                       //userId
    private String comId;                        //企业id
    private String jobName;                      //招聘岗位
    private String jobNumber;                   //人数
    private String jobArea;                     //工作地址
    private String jobProvince;                 //省
    private String jobCity;                     //市
    private String jobTown;                     //区/县
    private String recruitCondition;            //招聘条件
    private String minSalary;                   //最低薪资
    private String maxSalary;                   //最高薪资区间
    private String beginTime;                   //开始时间
    private String endTime;                     //结束时间
    private String createTime;                  //创建时间
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(String recruitId) {
        this.recruitId = recruitId;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getRecruitCondition() {
        return recruitCondition;
    }

    public void setRecruitCondition(String recruitCondition) {
        this.recruitCondition = recruitCondition;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getJobArea() {
        return jobArea;
    }

    public void setJobArea(String jobArea) {
        this.jobArea = jobArea;
    }

    public String getJobProvince() {
        return jobProvince;
    }

    public void setJobProvince(String jobProvince) {
        this.jobProvince = jobProvince;
    }

    public String getJobCity() {
        return jobCity;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity;
    }

    public String getJobTown() {
        return jobTown;
    }

    public void setJobTown(String jobTown) {
        this.jobTown = jobTown;
    }
}
