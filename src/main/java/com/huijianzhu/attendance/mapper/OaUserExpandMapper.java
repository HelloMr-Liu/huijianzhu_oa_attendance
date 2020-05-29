package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.OaUserExpand;

public interface OaUserExpandMapper {
    int deleteByPrimaryKey(String userId);

    int insert(OaUserExpand record);

    int insertSelective(OaUserExpand record);

    OaUserExpand selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(OaUserExpand record);

    int updateByPrimaryKey(OaUserExpand record);
}