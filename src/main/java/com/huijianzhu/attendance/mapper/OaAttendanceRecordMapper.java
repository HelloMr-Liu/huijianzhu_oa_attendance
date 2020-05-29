package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.OaAttendanceRecord;

public interface OaAttendanceRecordMapper {
    int deleteByPrimaryKey(String recordId);

    int insert(OaAttendanceRecord record);

    int insertSelective(OaAttendanceRecord record);

    OaAttendanceRecord selectByPrimaryKey(String recordId);

    int updateByPrimaryKeySelective(OaAttendanceRecord record);

    int updateByPrimaryKey(OaAttendanceRecord record);
}