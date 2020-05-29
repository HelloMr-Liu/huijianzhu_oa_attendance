package com.huijianzhu.attendance.definition;

import lombok.Data;

import javax.annotation.security.DenyAll;
import javax.validation.constraints.NotBlank;

/**
 * 描述：封装查询考勤人员信息对应的查询条件属性定义
 *
 * @author 刘梓江
 * @date 2020/5/25  14:16
 */
@Data
public class AtttendanceUserQueryDefinition {


    /**
     * 设备对应的权限标识
     */
    @NotBlank(message = "没有请求标识")
    private String token;

    /**
     * 当前起始页
     */
    private Integer pageNo;

    /**
     * 每页显示的条数默认500条
     */
    private Integer pageSize;

    /**
     * 部门编号信息
     */
    private String deptId;

    /**
     * 考勤人员名称
     */
    private String userName;

    /**
     * 是否离职 YES、NO
     */
    private String isDeparture;


    /**
     * 用户状态
     *     NORMAL_STATE("NORMAL",  "代表是正常状态"),
     *     ADD_STATE("ADD",  "代表是添加状态"),
     *     UPDATE_STATE("UPDATE",  "代表是修改状态"),
     *     DEL_STATE("DEL",  "代表是删除状态");
     */
    private String userState;

    /**
     * 文件类型 1入职文件 2：人员考勤文件
     */
    private String fileType;
}
