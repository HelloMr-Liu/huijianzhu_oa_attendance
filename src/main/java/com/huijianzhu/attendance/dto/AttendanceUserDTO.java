package com.huijianzhu.attendance.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：映射考勤用户信息类
 *
 * @author 刘梓江
 * @date 2020/5/26  17:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceUserDTO {


    /**
     * 用户id
     */
    private String staffId;


    /**
     * 用户名称
     */
    private String name;


    /**
     * 部门id
     */
    @JSONField(serialize=false)
    private String deptId;


    /**
     * 文件名称
     */
    @JSONField(serialize=false)
    private String fileName;


    /**
     * 基本数据1
     */
    private String faceData;


    /**
     * 基本数据2
     */
    @JSONField(serialize=false)
    private String baseData2;


    /**
     * 用户状态  (ADD,UPDATE,DELETE)
     */
    private String status;
}
