package com.huijianzhu.attendance.entity;

public class OaAttendanceFileWithBLOBs extends OaAttendanceFile {
    private String baseData1;

    private String baseData2;

    public String getBaseData1() {
        return baseData1;
    }

    public void setBaseData1(String baseData1) {
        this.baseData1 = baseData1 == null ? null : baseData1.trim();
    }

    public String getBaseData2() {
        return baseData2;
    }

    public void setBaseData2(String baseData2) {
        this.baseData2 = baseData2 == null ? null : baseData2.trim();
    }
}