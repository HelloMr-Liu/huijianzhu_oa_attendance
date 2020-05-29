package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.OaAttendanceRecordResult;

public interface OaAttendanceRecordResultMapper {
    int deleteByPrimaryKey(String resultId);

    int insert(OaAttendanceRecordResult record);

    int insertSelective(OaAttendanceRecordResult record);

    OaAttendanceRecordResult selectByPrimaryKey(String resultId);

    int updateByPrimaryKeySelective(OaAttendanceRecordResult record);

    int updateByPrimaryKey(OaAttendanceRecordResult record);
}