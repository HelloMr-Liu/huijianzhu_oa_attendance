package com.huijianzhu.attendance.service;

import com.huijianzhu.attendance.definition.AttendanceUserClockDefinition;
import com.huijianzhu.attendance.vo.SystemResult;

/**
 * 描述：操作用户打卡业务接口
 *
 * @author 刘梓江
 * @date 2020/5/27  15:01
 */
public interface UserClockService {


    /**
     * 用户打卡
     * @param definition 封装对应的用户打卡信息
     * @return
     */
    public SystemResult userClock(AttendanceUserClockDefinition definition);
}