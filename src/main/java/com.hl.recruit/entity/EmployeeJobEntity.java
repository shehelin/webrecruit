package com.hl.recruit.entity;

import java.io.Serializable;

/**
 * EmployeeJobEntity class
 * 求职信息
 * @author hl.she
 * @date 2019/03/26
 */
public class EmployeeJobEntity implements Serializable {
    private String empId;               //求职信息uuid
    private String userId;              //userId
    private String empName;             //求职姓名
    private String empJob;              //期望岗位
    private String empSalary;           //期望薪资
    private String empArea;             //期望地址
    private String remark;              //备注
    private String createTime;          //发布日期 创建时间

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(String empSalary) {
        this.empSalary = empSalary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEmpArea() {
        return empArea;
    }

    public void setEmpArea(String empArea) {
        this.empArea = empArea;
    }
}
