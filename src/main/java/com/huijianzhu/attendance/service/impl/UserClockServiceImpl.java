package com.huijianzhu.attendance.service.impl;

import com.huijianzhu.attendance.cache.EquipmentTokenCacheManager;
import com.huijianzhu.attendance.definition.AttendanceUserClockDefinition;
import com.huijianzhu.attendance.entity.*;
import com.huijianzhu.attendance.enums.SYSTEM_RESULT_STATE;
import com.huijianzhu.attendance.enums.dictionary.ATTENDANCE_TYPE_DICTIONARY;
import com.huijianzhu.attendance.enums.table.ATTENDANCE_FILE_TABLE_STATE;
import com.huijianzhu.attendance.enums.table.ATTENDANCE_TIME_TABLE_STATE;
import com.huijianzhu.attendance.enums.table.GLOBAL_TABLE_FILED_STATE;
import com.huijianzhu.attendance.mapper.extend.*;
import com.huijianzhu.attendance.service.UserClockService;
import com.huijianzhu.attendance.utils.ShareCodeUtil;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：操作用户打卡业务接口实现
 *
 * @author 刘梓江
 * @date 2020/5/27  15:02
 */
@Slf4j
@Service
@SuppressWarnings("all")
public class UserClockServiceImpl implements UserClockService {

    /**
     * 注入：操作考勤文件信息数据mapper扩展接口
     */
    @Autowired
    private OaAttendanceFileExtendMapper fileMapper;

    /**
     * 注入：操作考勤时间信息数据mapper扩展接口
     */
    @Autowired
    private OaAttendanceTimeExtendMapper timeExtendMapper;

    /**
     * 注入：操作考勤记录信息数据mapper扩展接口
     */
    @Autowired
    private OaAttendanceRecordExtendMapper recordExtendMapper;

    /**
     * 注入：操作考勤记录结果信息数据mapper扩展接口
     */
    @Autowired
    private OaAttendanceRecordResultExtendMapper recordResultMapper;

    /**
     * 注入：设备标识缓存容器
     */
    @Autowired
    private EquipmentTokenCacheManager cacheManager;

    /**
     * 用户打卡
     * @param definition 封装对应的用户打卡信息
     * @return
     */
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public   SystemResult  userClock(AttendanceUserClockDefinition definition) {

        //校验对应的标识是否有效
        if(!cacheManager.check(definition.getToken())){
            //验证标识失效
            return SystemResult.build(SYSTEM_RESULT_STATE.LOGIN_FAILURE.KEY,"设备验证标识失效");
        }

        //获取当前默认的打卡时间
        OaAttendanceTime timeByYesDefault = timeExtendMapper.getTimeByYesDefault(GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY,
                ATTENDANCE_TIME_TABLE_STATE.YES_DEFAULT.KEY);


        //获取当前用户最新的考勤记录信息
        OaAttendanceRecord userRecord = recordExtendMapper.getUserRecordByUserId(definition.getStaffId(), GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY);

        //创建时间格式化对象
        String strDateFormat = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        //获取当前用户时间打卡时间
        Long currentClockTime=sdf.parse(sdf.format(new Date(definition.getClockTime()))).getTime();

        String mess="";

        //判断是上班还是下班
        if(userRecord==null||userRecord.getClockEndTime()!=null){

            //创建记录id、记录结果id、考勤文件信息id
            String recordId = ShareCodeUtil.getOnlyToken();
            String recordResultId = ShareCodeUtil.getOnlyToken();
            String fileId=ShareCodeUtil.getOnlyToken();


            //代表是上班记录、创建对应的新的打开记录对象
            OaAttendanceRecord record =new OaAttendanceRecord();
            record.setRecordId(recordId);                            //记录id 主键
            record.setResultId(recordResultId);                      //记录结果表id
            record.setUserNo(definition.getStaffId());                //用户编号
            record.setUserName(definition.getUserName());            //用户名称
            record.setClockStartTime(new Date());                    //打卡上班时间
            record.setIsDelete(GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY); //删除标志
            record.setCreateTime(new Date());                        //创建时间
            record.setUpdateTime(new Date());                        //修改时间
            record.setR1(timeByYesDefault.getOnWorkTime());          //本次上班时间
            record.setR2(timeByYesDefault.getAfterTime());           //本次下班时间

            //创建打卡记录结果表
            OaAttendanceRecordResult result=new OaAttendanceRecordResult();
            result.setResultId(recordResultId);                       //记录结果id 主键
            result.setRecordId(recordId);                             //记录id主键
            result.setCreateTime(new Date());                         //创建时间
            result.setUpdateTime(new Date());                         //修改时间
            result.setIsDelete(GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY);  //删除标志

            //获取当前默认上班打卡时间
            long onWorkTime=sdf.parse(timeByYesDefault.getOnWorkTime()).getTime();

            //判断是否是迟到状态
            if(currentClockTime>onWorkTime){
                //(迟到)
                result.setOnTypeId(ATTENDANCE_TYPE_DICTIONARY.LATE_TYPE.KEY); //设置成迟到
                mess=ATTENDANCE_TYPE_DICTIONARY.LATE_TYPE.VALUE;
            }else{
                //(正常)
                result.setOnTypeId(ATTENDANCE_TYPE_DICTIONARY.NORMAL_TYPE.KEY); //设置正常上班
            }

            //创建对应打卡记录信息数据对象
            OaAttendanceFileWithBLOBs file=new OaAttendanceFileWithBLOBs();
            file.setFileId(fileId);                                         //文件id
            file.setUniquenessId(recordId);                                 //指定那个记录的文件信息
            file.setFileType(ATTENDANCE_FILE_TABLE_STATE.FILE_TYPE_2.KEY);  //文件类型(考勤类型)
            file.setFileName(definition.getFileName());                     //文件名称
            file.setBaseData1(definition.getFile());                        //上班考勤数据
            file.setCreateTime(new Date());                                 //创建时间
            file.setUpdateTime(new Date());                                 //修改时间
            file.setIsDelete(GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY);          //删除标志

            //持久化到数据库中
            recordExtendMapper.insertSelective(record);         //考勤记录信息
            recordResultMapper.insertSelective(result);         //考勤记录结果信息
            fileMapper.insertSelective(file);                   //考勤记录文件信息

        }else{

            //获取当前默认下班打卡时间
            long afterWorkTime=sdf.parse(userRecord.getR2()).getTime();

            //修改当前用户打卡记录信息
            userRecord.setClockEndTime(new Date(definition.getClockTime()));         //下班打卡时间
            userRecord.setUpdateTime(new Date());           //修改时间

            //修改打卡记录结果信息
            OaAttendanceRecordResult recordResult = recordResultMapper.getRecordResultByRecordId(GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY, userRecord.getRecordId());
            recordResult.setUpdateTime(new Date());         //修改时间

            //判断是否早退
            if(currentClockTime<afterWorkTime){
                //早退
                recordResult.setAfterTypeId(ATTENDANCE_TYPE_DICTIONARY.LEAVE_EARLY_TYPE.KEY);
                mess=ATTENDANCE_TYPE_DICTIONARY.LEAVE_EARLY_TYPE.VALUE;
            }else{
                //正常下班
                recordResult.setAfterTypeId(ATTENDANCE_TYPE_DICTIONARY.NORMAL_TYPE.KEY); //设置正常上班
            }
            //创建对应打卡记录信息数据对象
            OaAttendanceFileWithBLOBs recordFile = fileMapper.getFileByRecordId(GLOBAL_TABLE_FILED_STATE.NO_DEL.KEY, userRecord.getRecordId());
            recordFile.setBaseData2(definition.getFile());  //下班考勤数据信息
            recordFile.setUpdateTime(new Date());

            //持久化到数据库中
            recordExtendMapper.updateByPrimaryKeySelective(userRecord);         //考勤记录信息
            recordResultMapper.updateByPrimaryKeySelective(recordResult);       //考勤记录结果信息
            fileMapper.updateByPrimaryKeySelective(recordFile);                 //考勤记录文件信息
        }
        return SystemResult.ok("打卡成功 "+mess);
    }

}
