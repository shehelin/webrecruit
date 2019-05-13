package com.hl.recruit.entity;


/**
 * EmpRelCom class
 * 申请
 * @author hl.she
 * @date 2019/03/26
 */
public class EmpRelCom {
    private String relId;
    private String empId;
    private String comId;
    private String status = "0";


    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
