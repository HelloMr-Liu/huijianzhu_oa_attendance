package com.huijianzhu.attendance.enums.table;

/**
 * 描述：用户扩展表的字段状态
 *
 * @author 刘梓江
 * @date 2020/5/27  11:55
 */

public enum OA_USER_EXPAND_TABLE_STATE {

    YES_Departure("YES","代表当前是离职状态"),
    NO_Departure("NO",  "代表当前是非离职状态"),
    NORMAL_STATE("NORMAL",  "代表是正常状态"),
    ADD_STATE("ADD",  "代表是添加状态"),
    UPDATE_STATE("UPDATE",  "代表是修改状态"),
    DEL_STATE("DEL",  "代表是删除状态");
    public String KEY;       //反馈的值
    public String VALUE;     //反馈的描述信息
    OA_USER_EXPAND_TABLE_STATE(String state,String mess){
        this.KEY=state;
        this.VALUE=mess;
    }
}