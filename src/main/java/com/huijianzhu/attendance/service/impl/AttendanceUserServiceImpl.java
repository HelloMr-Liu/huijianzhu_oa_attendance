package com.huijianzhu.attendance.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huijianzhu.attendance.cache.EquipmentTokenCacheManager;
import com.huijianzhu.attendance.dto.AttendanceUserDTO;
import com.huijianzhu.attendance.enums.SYSTEM_RESULT_STATE;
import com.huijianzhu.attendance.enums.table.ATTENDANCE_FILE_TABLE_STATE;
import com.huijianzhu.attendance.enums.table.GLOBAL_TABLE_FILED_STATE;
import com.huijianzhu.attendance.enums.table.OA_USER_EXPAND_TABLE_STATE;
import com.huijianzhu.attendance.mapper.extend.OaUserExpandExtendMapper;
import com.huijianzhu.attendance.mapper.extend.TblOaLoginExtendMapper;
import com.huijianzhu.attendance.definition.AtttendanceUserQueryDefinition;
import com.huijianzhu.attendance.service.AttendanceUserService;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述：操作考勤人员信息业务接口实现
 *
 * @author 刘梓江
 * @date 2020/5/27  11:46
 */
@Slf4j
@Service
@SuppressWarnings("all")
public class AttendanceUserServiceImpl implements AttendanceUserService {

    /**
     * 注入：操作考勤人员信息数据mapper扩展接口
     */
    @Autowired
    private TblOaLoginExtendMapper tblOaLoginExtendMapper;


    /**
     * 注入：操作考勤用户扩展信息数据mapper扩展接口
     */
    @Autowired
    private OaUserExpandExtendMapper expandExtendMapper;

    /**
     * 注入：设备标识管理容器
     */
    @Autowired
    private EquipmentTokenCacheManager cacheManager;

    /**
     * 指定查询条件,获取考勤人员对应的操作状态后的信息集
     * @param query
     * @return
     */
    public SystemResult findAllQuery(AtttendanceUserQueryDefinition query){

        //校验对应的标识是否有效
        if(!cacheManager.check(query.getToken())){
            //验证标识失效
            return SystemResult.build(SYSTEM_RESULT_STATE.LOGIN_FAILURE.KEY,"设备验证标识失效");
        }

        //补充查询条件
        query.setFileType(ATTENDANCE_FILE_TABLE_STATE.FILE_TYPE_1.KEY); //默认是用户入职信息
        //query.setIsDeparture(StrUtil.hasBlank(query.getIsDeparture())? OA_USER_EXPAND_TABLE_STATE.NO_Departure.KEY:query.getIsDeparture());
        query.setUserState(OA_USER_EXPAND_TABLE_STATE.NORMAL_STATE.KEY); //默认是用户状态
        if(query.getPageSize()!=null&&query.getPageNo()!=null){
            //当前有分页条件开启分页插件
            PageHelper.startPage(query.getPageNo(),query.getPageSize());
            List<AttendanceUserDTO> allByQuery = tblOaLoginExtendMapper.findAllByQuery(query, GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY);
            //创建分页信息对象
            PageInfo<AttendanceUserDTO> info=new PageInfo<>(allByQuery);
            return SystemResult.ok(info.getList());
        }else{
            //获取对应的结果信息集（没有分页）
            List<AttendanceUserDTO> allByQuery = tblOaLoginExtendMapper.findAllByQuery(query, GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY);
            return SystemResult.ok(allByQuery);
        }
    }


    /**
     * 获取所有有效人员对应的信息数据集
     * @param query
     * @return
     */
    public SystemResult findAll(AtttendanceUserQueryDefinition query){
        //补充查询条件
        query.setFileType(ATTENDANCE_FILE_TABLE_STATE.FILE_TYPE_1.KEY);  //默认是用户入职信息
        List<AttendanceUserDTO> all = tblOaLoginExtendMapper.findAll(query, GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY);
        return SystemResult.ok(all);
    }

    /**
     * 修改考勤用户操作状态(正常)
     * @param userIds
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult updateAttendanceUserState(List<String> userIds){
        //批量修改用户操作状态信息(正常)
        expandExtendMapper.batchUpdateUserState(userIds,OA_USER_EXPAND_TABLE_STATE.NORMAL_STATE.KEY);
        return SystemResult.ok();
    }
}
