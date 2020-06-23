package com.huijianzhu.attendance.controller;

import com.alibaba.fastjson.JSON;
import com.huijianzhu.attendance.definition.SynchronizUserDefinition;
import com.huijianzhu.attendance.service.EquipmentService;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
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
     * 设备同步成功响应操作
     * @param userIds 存储对应同步成功的用户id
     * @return
     */
    @PostMapping("/personnelSyncCallback")
    public SystemResult deviceSynchronization(String token,String jsonData){
        List<SynchronizUserDefinition> newJsonData= JSON.parseArray(jsonData,SynchronizUserDefinition.class);
        List<String > userIdsList=new ArrayList<>();
        for(SynchronizUserDefinition user:newJsonData){
            if(Boolean.valueOf(user.getIsFinish())){
                userIdsList.add(user.getStaffId());
            }
        }
        SystemResult systemResult = equipmentService.deviceSynchronization(token,userIdsList);
        return systemResult;
    }



}
