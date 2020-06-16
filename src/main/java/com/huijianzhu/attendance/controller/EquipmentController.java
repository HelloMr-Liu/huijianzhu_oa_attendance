package com.huijianzhu.attendance.controller;

import com.huijianzhu.attendance.service.EquipmentService;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;

/**
 * 描述：设备处理请求接口控制器
 *
 * @author 刘梓江
 * @date 2020/5/29  11:17
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/labour/gate")
@SuppressWarnings("all")
public class EquipmentController {

    /**
     * 注入：设备业务处理接口
     */
    @Autowired
    private EquipmentService equipmentService;

    /**
     * 校验设备是否有连接
     * @return
     */
    @PostMapping("/check/online")
    public SystemResult checkEquipmentExists(){
        SystemResult systemResult = equipmentService.checkEquipmentExists();
        return systemResult;
    }

    /**
     * 设备上线
     * @param equipCode 设备标识
     * @return
     */
    @PostMapping("/online")
    public SystemResult online(@NotBlank(message = "没有设备编号") String equipCode){
        SystemResult systemResult = equipmentService.online(equipCode);
        return systemResult;
    }

    /**
     * 设备下线
     * @param token
     * @return
     */
    @PostMapping("/Offline")
    public SystemResult offline(@NotBlank(message = "没有设备编号") String token){
        SystemResult systemResult = equipmentService.offline(token);
        return systemResult;
    }

    /**
     * 设备请求心跳响应机制状态操作
     * @param token
     * @return
     */
    @PostMapping("/receiveHeartBeat")
    public SystemResult heartbeat(@NotBlank(message = "没有验证标识")  String token){
        SystemResult systemResult = equipmentService.heartbeat(token);
        return systemResult;
    }


    /**
     * 获取人员变动的数量
     * @param token
     * @return
     */
    @PostMapping("/personnelCount")
    public SystemResult personnelCount(@NotBlank(message = "没有验证标识")  String token){
        SystemResult systemResult = equipmentService.personnelCount(token);
        return systemResult;
    }


    /**
     * 设备同步成功响应操作
     * @param userIds 存储对应同步成功的用户id
     * @return
     */
    @PostMapping("/device/synchroniz")
    public SystemResult deviceSynchronization(String[] userIds){
        SystemResult systemResult = equipmentService.deviceSynchronization(Arrays.asList(userIds));
        return systemResult;
    }



}
