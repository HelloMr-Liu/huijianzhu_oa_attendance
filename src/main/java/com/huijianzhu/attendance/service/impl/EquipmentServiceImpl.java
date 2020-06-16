package com.huijianzhu.attendance.service.impl;

import com.huijianzhu.attendance.cache.EquipmentTokenCacheManager;
import com.huijianzhu.attendance.enums.SYSTEM_RESULT_STATE;
import com.huijianzhu.attendance.service.AttendanceUserService;
import com.huijianzhu.attendance.service.EquipmentService;
import com.huijianzhu.attendance.utils.ShareCodeUtil;
import com.huijianzhu.attendance.vo.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：设备业务处理接口实现
 *
 * @author 刘梓江
 * @date 2020/5/29  11:07
 */
@Service
@SuppressWarnings("all")
public class EquipmentServiceImpl implements EquipmentService {

    /**
     * 注入：设备标识缓存管理
     */
    @Autowired
    private EquipmentTokenCacheManager cacheManager;

    /**
     * 注入：考勤用户信息业务接口
     */
    @Autowired
    private AttendanceUserService userService;

    private String currentUnique="96e71ca1a3fe48d5a8dc937b7269d7c7";

    /**
     * 校验设备是否有连接
     * @return
     */
    public SystemResult checkEquipmentExists(){
        //判断是否有连接的设备
        return SystemResult.ok(cacheManager.getCache().size());
    }

    /**
     * 设备上线
     * @param equipCode 设备标识
     * @return
     */
    public SystemResult online(String equipCode){
        if(!currentUnique.equals(equipCode)){
            return SystemResult.build(SYSTEM_RESULT_STATE.CHECK_ERROR.KEY,SYSTEM_RESULT_STATE.CHECK_ERROR.VALUE);
        }

        //创建一个设备请求权限标识
        String permissionsToken= ShareCodeUtil.getOnlyToken();

        //清空原来的设备校验标识信息
        cacheManager.getCache().clear();

        //将当前设备编号对应权限标识存储到缓存中
        cacheManager.getCache().put(equipCode,permissionsToken);

        return SystemResult.ok(permissionsToken);
    }

    /**
     * 设备下线
     * @param token
     * @return
     */
    public SystemResult offline(String token){
        //校验对应的标识是否有效
        if(!cacheManager.check(token)){
            //验证标识失效
            return SystemResult.build(SYSTEM_RESULT_STATE.LOGIN_FAILURE.KEY,"设备验证标识失效");
        }
        //清空原来的设备校验标识信息
        cacheManager.getCache().clear();
        return SystemResult.ok();
    }

    /**
     * 设备请求心跳响应机制状态操作
     * @param equipCode
     * @return
     */
    public SystemResult heartbeat(String token){

        //校验对应的标识是否有效
        if(!cacheManager.check(token)){
            //验证标识失效
            return SystemResult.build(SYSTEM_RESULT_STATE.LOGIN_FAILURE.KEY,"设备验证标识失效");
        }
        //获取人员变动数量信息
        SystemResult systemResult = userService.personnelChangesNumber();
        Map<String,Object> objMap=new HashMap<>();
        objMap.put("personFlag",(Integer.parseInt(systemResult.getResult().toString())>0));
        return SystemResult.ok(objMap);
    }

    /**
     * 获取人员变动的数量
     * @param token
     * @return
     */
    public SystemResult personnelCount(String token){
        //校验对应的标识是否有效
        if(!cacheManager.check(token)){
            //验证标识失效
            return SystemResult.build(SYSTEM_RESULT_STATE.LOGIN_FAILURE.KEY,"设备验证标识失效");
        }
        //获取人员变动数量信息
        SystemResult systemResult = userService.personnelChangesNumber();
        return systemResult;

    }

    /**
     * 设备同步成功响应操作
     * @param userIds 存储对应同步成功的用户id
     * @return
     */
    public SystemResult deviceSynchronization(List<String> userIds){
        //异步调用考勤用户修改操作
        try{
            new Thread(()->{
                userService.updateAttendanceUserState(userIds);
            }).start();
        }catch (Exception e){}
        return SystemResult.ok();
    }
}
