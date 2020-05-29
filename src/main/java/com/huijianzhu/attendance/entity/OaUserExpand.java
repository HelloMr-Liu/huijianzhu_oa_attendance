package com.huijianzhu.attendance.entity;

import java.util.Date;

public class OaUserExpand {
    private String userId;

    private String isDeparture;

    private String operatingState;

    private String fileId;

    private Date updateTime;

    private String r1;

    private String r2;

    private String r3;

    private String r4;

    private String r5;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getIsDeparture() {
        return isDeparture;
    }

    public void setIsDeparture(String isDeparture) {
        this.isDeparture = isDeparture == null ? null : isDeparture.trim();
    }

    public String getOperatingState() {
        return operatingState;
    }

    public void setOperatingState(String operatingState) {
        this.operatingState = operatingState == null ? null : operatingState.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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