package com.huijianzhu.attendance.service;

import com.huijianzhu.attendance.vo.SystemResult;

import java.util.List;

/**
 * 描述：设备业务处理接口
 *
 * @author 刘梓江
 * @date 2020/5/29  11:02
 */

public interface EquipmentService {


    /**
     * 校验设备是否有连接
     * @return
     */
    public SystemResult  checkEquipmentExists();


    /**
     * 设备上线
     * @param equipCode 设备标识
     * @return
     */
    public SystemResult online(String equipCode);

    /**
     * 设备下线
     * @param equipCode 设备标识
     * @return
     */
    public SystemResult offline(String equipCode);


    /**
     * 设备请求心跳响应机制状态操作
     * @param token
     * @return
     */
    public SystemResult deviceResponseState(String token);

    /**
     * 设备同步成功响应操作
     * @param userIds 存储对应同步成功的用户id
     * @return
     */
    public SystemResult deviceSynchronization(List<String>userIds);
}
