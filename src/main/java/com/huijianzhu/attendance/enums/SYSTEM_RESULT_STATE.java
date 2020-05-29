package com.huijianzhu.attendance.enums;

/**
 * 描述：系统全局状态码
 * @author 刘梓江
 * @date   2020/5/21 13:13
 */
public enum SYSTEM_RESULT_STATE {
    SUCCESS(200,"本次操作成功"),
    ERROR(20004,"系统内部出现异常"),
    CHECK_ERROR(20003,"数据校验异常"),
    LOGIN_FAILURE(401,"登录失败,用户名密码错误"),
    LOGIN_DISABLE(402,"该账号已经被禁用"),
    LOGIN_NO_AUTH(403,"登录失败,需要权限"),
    INSERT_FAILURE(601,"添加失败"),
    UPDATE_FAILURE(602,"修改失败"),
    DELETE_FAILURE(603,"删除失败"),
    TARGET_NOT_EXITE(610, "目标信息不存在"),
    EQUIPMENT_EXITE(710, "设备存在");

    public Integer KEY;         //反馈的状态码
    public String VALUE;        //反馈的描述信息
    SYSTEM_RESULT_STATE(Integer state,String mess){
        this.KEY=state;
        this.VALUE=mess;
    }
}