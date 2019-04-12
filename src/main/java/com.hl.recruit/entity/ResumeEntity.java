package com.hl.recruit.entity;

import java.io.Serializable;

/**
 * ResumeEntity class
 * 简历信息
 * @author hl.she
 * @date 2019/03/26
 */
public class ResumeEntity implements Serializable {
    private String resumeId;                //简历id uu
    private String userId;                  //userid关联
    private String fileId;                  //文件id
    private String name;                    //姓名
    private String sex;                     //性别
    private String nation;                  //民族
    private String birthDate;               //出生日期
    private String birthArea;               //户籍
    private String localArea;               //所在地
    private String graduation;              //毕业院校
    private String educationLevel;          //教育学历
    private String major;                   //专业
    private String politicStatus;           //社会地位-团员
    private String phone;                   //联系电话
    private String email;                   //联系邮箱
    private String jobName;                 //求职意向岗位
    private String skill;                   //技能
    private String experience;              //经验

    public String getLocalArea() {
        return localArea;
    }

    public void setLocalArea(String localArea) {
        this.localArea = localArea;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthArea() {
        return birthArea;
    }

    public void setBirthArea(String birthArea) {
        this.birthArea = birthArea;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPoliticStatus() {
        return politicStatus;
    }

    public void setPoliticStatus(String politicStatus) {
        this.politicStatus = politicStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
