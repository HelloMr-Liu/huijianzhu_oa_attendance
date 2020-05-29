package com.huijianzhu.attendance.enums.table;

/**
 * 描述：考勤文件表字段状态信息
 * @author 刘梓江
 * @date 2020/5/22  16:38
 */

public enum ATTENDANCE_FILE_TABLE_STATE {
    FILE_TYPE_1("1","代表当前的文件类型是入职文件信息"),
    FILE_TYPE_2("2",  "代表当前的文件类型是考勤文件信息");
    public String KEY;       //反馈的值
    public String VALUE;     //反馈的描述信息
    ATTENDANCE_FILE_TABLE_STATE(String state,String mess){
        this.KEY=state;
        this.VALUE=mess;
    }
}