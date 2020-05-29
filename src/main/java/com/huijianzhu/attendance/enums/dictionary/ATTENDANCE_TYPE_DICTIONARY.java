package com.huijianzhu.attendance.enums.dictionary;

/**
 * 描述：考勤类型字典信息
 *
 * @author 刘梓江
 * @date 2020/5/27  14:34
 */
public enum ATTENDANCE_TYPE_DICTIONARY {

    NORMAL_TYPE("001","正常"),
    LATE_TYPE("002","迟到"),
    LEAVE_EARLY_TYPE("003","早退"),
    OVERTIME_TYPE("004","加班"),
    LEAVE_TYPE("005","请假");

    public String KEY;       //反馈的值
    public String VALUE;     //反馈的描述信息
    ATTENDANCE_TYPE_DICTIONARY(String state,String mess){
        this.KEY=state;
        this.VALUE=mess;
    }
}