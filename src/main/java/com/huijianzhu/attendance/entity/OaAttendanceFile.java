package com.huijianzhu.attendance.entity;

import java.util.Date;

public class OaAttendanceFile {
    private String fileId;

    private String fileName;

    private String filePath;

    private String fileType;

    private String uniquenessId;

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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getUniquenessId() {
        return uniquenessId;
    }

    public void setUniquenessId(String uniquenessId) {
        this.uniquenessId = uniquenessId == null ? null : uniquenessId.trim();
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