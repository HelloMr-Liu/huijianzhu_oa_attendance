package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.TblOaLogin;

public interface TblOaLoginMapper {
    int deleteByPrimaryKey(String loginId);

    int insert(TblOaLogin record);

    int insertSelective(TblOaLogin record);

    TblOaLogin selectByPrimaryKey(String loginId);

    int updateByPrimaryKeySelective(TblOaLogin record);

    int updateByPrimaryKey(TblOaLogin record);
}