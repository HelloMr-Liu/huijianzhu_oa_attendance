package com.huijianzhu.attendance.service;

import com.huijianzhu.attendance.definition.AtttendanceUserQueryDefinition;
import com.huijianzhu.attendance.vo.SystemResult;

import java.util.List;

/**
 * 描述：操作考勤人员信息业务接口
 *
 * @author 刘梓江
 * @date 2020/5/27  11:42
 */
public interface AttendanceUserService {

    /**
     * 指定查询条件,获取考勤人员对应的操作状态后的信息集
     * @param query
     * @return
     */
    public SystemResult findAllQuery(AtttendanceUserQueryDefinition query);


    /**
     * 获取所有有效人员对应的信息数据集
     * @param query
     * @return
     */
    public SystemResult findAll(AtttendanceUserQueryDefinition query);


    /**
     * 统计人员数量
     * @return
     */
    public SystemResult countMemberNumber();


    /**
     * 判断人员是否变动信息
     * @return
     */
    public SystemResult personnelChangesNumber();

    /**
     * 修改考勤用户操作状态(正常)
     * @param userIds
     * @return
     */
    public SystemResult updateAttendanceUserState(List<String> userIds);
}