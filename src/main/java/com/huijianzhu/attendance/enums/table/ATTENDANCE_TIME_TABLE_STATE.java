package com.huijianzhu.attendance.enums.table;

/**
 * 描述：考勤时间表字段状态信息
 *
 * @author 刘梓江
 * @date 2020/5/26  11:21
 */
public enum ATTENDANCE_TIME_TABLE_STATE {
    YES_DEFAULT("YES_DEFAULT","代表当前是默认"),
    NO_DEFAULT("NO_DEFAULT",  "代表当前不是默认");
    public String KEY;       //反馈的值
    public String VALUE;     //反馈的描述信息
    ATTENDANCE_TIME_TABLE_STATE(String state,String mess){
        this.KEY=state;
        this.VALUE=mess;
    }
}