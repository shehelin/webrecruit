package com.hl.recruit.dto;

import com.hl.recruit.entity.CompanyEntity;
import com.hl.recruit.entity.RecruitEntity;
import com.hl.recruit.entity.UserEntity;

/**
 * UserComDto class
 * 用户企业关联详情
 * @author  hl.she
 * create 2019.03.27
 */
public class UserComDto {

    private String comId;   //企业编号手写
    private String userId;  //关联企业用户
    private String comName; //企业名称
    private String comType; //企业类型
    private String comInfo; //企业信息
    private String remark;  //备注
    private String comAddress; //地址
    private String comTel;    //企业电话
    private String userName; //用户名
    private String pwd;      //密码
    private String userStatus;//用户状态
    private String realName = "";  //真实姓名
    private String phone = "";     //手机号
    private String sex = "";       //性别
    private String email = "";     //邮箱
    private String recruitId;                    //招聘信息id
    private String jobName;                      //招聘岗位
    private String jobNumber;                   //人数
    private String jobArea;                     //工作地址
    private String recruitCondition;            //招聘条件
    private String minSalary;                   //最低薪资
    private String maxSalary;                   //最高薪资区间
    private String beginTime;                   //开始时间
    private String endTime;                     //结束时间
    private String createTime;                  //创建时间
    private String jobProvince;                 //省
    private String jobCity;                     //市
    private String jobTown;                     //区/县
    private String status;


    private CompanyEntity companyEntity;
    private UserEntity userEntity;
    private RecruitEntity recruitEntity;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public RecruitEntity getRecruitEntity() {
        return recruitEntity;
    }

    public void setRecruitEntity(RecruitEntity recruitEntity) {
        this.recruitEntity = recruitEntity;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(String recruitId) {
        this.recruitId = recruitId;
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

    public String getJobArea() {
        return jobArea;
    }

    public void setJobArea(String jobArea) {
        this.jobArea = jobArea;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
