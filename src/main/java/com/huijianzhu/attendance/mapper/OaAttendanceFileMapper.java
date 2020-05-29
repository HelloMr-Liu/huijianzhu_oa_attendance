package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.OaAttendanceFile;
import com.huijianzhu.attendance.entity.OaAttendanceFileWithBLOBs;

public interface OaAttendanceFileMapper {
    int deleteByPrimaryKey(String fileId);

    int insert(OaAttendanceFileWithBLOBs record);

    int insertSelective(OaAttendanceFileWithBLOBs record);

    OaAttendanceFileWithBLOBs selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(OaAttendanceFileWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OaAttendanceFileWithBLOBs record);

    int updateByPrimaryKey(OaAttendanceFile record);
}