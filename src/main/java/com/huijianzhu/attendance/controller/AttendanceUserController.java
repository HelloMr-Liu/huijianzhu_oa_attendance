package com.huijianzhu.attendance.controller;

import com.huijianzhu.attendance.definition.AttendanceUserClockDefinition;
import com.huijianzhu.attendance.definition.AtttendanceUserQueryDefinition;
import com.huijianzhu.attendance.service.AttendanceUserService;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 描述：考勤人员信息请求接口控制器
 *
 * @author 刘梓江
 * @date 2020/5/27  12:00
 */
@Slf4j
@Validated
@RestController
@SuppressWarnings("all")
@RequestMapping("/labour/gate")
public class AttendanceUserController {

    /**
     * 注入：操作考勤用户信息业务接口
     */
    @Autowired
    private AttendanceUserService attendanceUserService;

    /**
     * 指定查询条件,获取考勤人员对应的操作状态后的信息集
     * @param query
     * @return
     */
    @PostMapping("/personnelList")
    public SystemResult findAllQuery(@Valid  AtttendanceUserQueryDefinition query){
        SystemResult allQuery = attendanceUserService.findAllQuery(query);
        return allQuery;
    }

    /**
     * 获取所有有效人员对应的信息数据集
     * @param query
     * @return
     */
    @PostMapping("/managerPersonList")
    public SystemResult findAll(@Valid  AtttendanceUserQueryDefinition query){
        SystemResult allQuery = attendanceUserService.findAll(query);
        return allQuery;
    }
}
