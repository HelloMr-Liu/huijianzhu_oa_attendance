package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.OaAttendanceTime;

public interface OaAttendanceTimeMapper {
    int deleteByPrimaryKey(Integer timeId);

    int insert(OaAttendanceTime record);

    int insertSelective(OaAttendanceTime record);

    OaAttendanceTime selectByPrimaryKey(Integer timeId);

    int updateByPrimaryKeySelective(OaAttendanceTime record);

    int updateByPrimaryKey(OaAttendanceTime record);
}