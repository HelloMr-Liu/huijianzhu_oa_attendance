package com.huijianzhu.attendance.service;

import com.huijianzhu.attendance.vo.SystemResult;

import javax.validation.constraints.NotBlank;
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
     * @param token
     * @return
     */
    public SystemResult offline(String token);


    /**
     * 设备请求心跳响应机制状态操作
     * @param token
     * @return
     */
    public SystemResult heartbeat(String token);

    /**
     * 获取人员变动的数量
     * @param token
     * @return
     */
    public SystemResult personnelCount(String token);

    /**
     * 设备同步成功响应操作
     * @param userIds 存储对应同步成功的用户id
     * @return
     */
    public SystemResult deviceSynchronization(List<String>userIds);
}
