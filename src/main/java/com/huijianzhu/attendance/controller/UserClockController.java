package com.huijianzhu.attendance.controller;

import com.huijianzhu.attendance.definition.AttendanceUserClockDefinition;
import com.huijianzhu.attendance.service.UserClockService;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 描述：用户打卡请求接口
 *
 * @author 刘梓江
 * @date 2020/5/27  17:10
 */
@Slf4j
@Validated
@RestController
@SuppressWarnings("all")
@RequestMapping("/clock")
public class UserClockController {

    /**
     * 注入：操作用户打卡业务接口
     */
    @Autowired
    private UserClockService userClockService;

    /**
     * 用户打卡
     * @param definition 封装对应的用户打卡信息
     * @return
     */
    @PostMapping("/user/clock")
    public SystemResult userClock(@Valid  AttendanceUserClockDefinition definition){
        SystemResult systemResult = userClockService.userClock(definition);
        return  systemResult;
    }
}
