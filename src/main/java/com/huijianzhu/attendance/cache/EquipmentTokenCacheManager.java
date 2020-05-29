package com.huijianzhu.attendance.cache;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：终端标识缓存容器
 *
 * @author 刘梓江
 * @date 2020/5/29  10:59
 */
@Data
@Component
@SuppressWarnings("all")
public class EquipmentTokenCacheManager {

    private  String DEFAULT_TOKEN="DEFAULT_TOKEN";
    /**
     * 创建一个终端容器
     */
    private ConcurrentHashMap<String,String> cache=new ConcurrentHashMap<>();

    /**
     * 校验对应的权限标识
     * @param token
     * @return false 标识失效  true 标识有效
     */
    public boolean check(String token){
        Set<Map.Entry<String, String>> entries = cache.entrySet();
        for(Map.Entry<String, String> entity:entries){
            if(entity.getValue().equals(token)){
                return true;
            }
        }
        return false;
    }
}
