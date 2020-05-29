package com.huijianzhu.attendance.cache;

import com.huijianzhu.attendance.entity.OaAttendanceType;
import com.huijianzhu.attendance.enums.table.GLOBAL_TABLE_FILED_STATE;
import com.huijianzhu.attendance.mapper.extend.OaAttendanceTypeExtendMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.awt.geom.AreaOp;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述： 考勤类型缓存管理
 *
 * @author 刘梓江
 * @date 2020/5/27  15:55
 */
@Data
@Slf4j
@Component
@SuppressWarnings("all")
public class AttendanceTypeCacheManager {

    /**
     * 注入：操作考勤类型信息数据mapper扩展接口
     */
    @Autowired
    private OaAttendanceTypeExtendMapper typeExtendMapper;

    /**
     * 缓存容器
     */
    private ConcurrentHashMap<String, OaAttendanceType> typeCache=new ConcurrentHashMap<>();


    /**
     * 初始化容器
     */
    private void init(){
        refresh();
    }

    /**
     * 容器刷新
     */
    public void refresh(){
        findAll();
    }


    /**
     * 获取所有有效的考勤类型信息
     */
    private void findAll(){
        List<OaAttendanceType> all = typeExtendMapper.findAll(GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY);
        all.forEach(
            e->{
                typeCache.put(e.getTypeNo(),e);
            }
        );
    }
}
