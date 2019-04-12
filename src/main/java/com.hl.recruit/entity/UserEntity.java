package com.hl.recruit.entity;

import java.io.Serializable;

/**
 * User class
 *
 * @author hl.she
 * @date 2019/03/08
 */
public class UserEntity  implements Serializable {
    private String userId;   //用户id
    private String userName; //用户名
    private String pwd;      //密码
    private String userStatus;//用户状态
    private String realName = "";  //真实姓名
    private String phone = "";     //手机号
    private String sex = "";       //性别
    private String email = "";     //邮箱
//    private String fileId;    //文件地址
    private String createTime;//创建时间

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
