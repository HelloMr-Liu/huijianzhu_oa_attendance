package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.OaAttendanceType;

public interface OaAttendanceTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(OaAttendanceType record);

    int insertSelective(OaAttendanceType record);

    OaAttendanceType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(OaAttendanceType record);

    int updateByPrimaryKey(OaAttendanceType record);
}