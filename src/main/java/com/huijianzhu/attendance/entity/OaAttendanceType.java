package com.huijianzhu.attendance.entity;

import java.util.Date;

public class OaAttendanceType {
    private Integer typeId;

    private String typeNo;

    private String typeName;

    private String isDelete;

    private Date createTime;

    private Date updateTime;

    private String updateUserId;

    private String updateUserName;

    private String r1;

    private String r2;

    private String r3;

    private String r4;

    private String r5;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo == null ? null : typeNo.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1 == null ? null : r1.trim();
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2 == null ? null : r2.trim();
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3 == null ? null : r3.trim();
    }

    public String getR4() {
        return r4;
    }

    public void setR4(String r4) {
        this.r4 = r4 == null ? null : r4.trim();
    }

    public String getR5() {
        return r5;
    }

    public void setR5(String r5) {
        this.r5 = r5 == null ? null : r5.trim();
    }
}