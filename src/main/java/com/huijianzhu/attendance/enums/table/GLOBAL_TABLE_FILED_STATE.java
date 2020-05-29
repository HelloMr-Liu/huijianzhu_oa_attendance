package com.huijianzhu.attendance.enums.table;

/**
 * 描述： 全局表字段信息状态
 * @author 刘梓江
 * @date   2020/5/21 13:07
 */
public enum GLOBAL_TABLE_FILED_STATE {
    YES_DEL("1","代表当前记录被删除"),
    NO_DEL("0",  "代表当前记录没有被删除");
    public String KEY;       //反馈的值
    public String VALUE;     //反馈的描述信息
    GLOBAL_TABLE_FILED_STATE(String state,String mess){
        this.KEY=state;
        this.VALUE=mess;
    }
}