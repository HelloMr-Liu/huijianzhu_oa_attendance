package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.entity.OaAttendanceRecord;
import com.huijianzhu.attendance.mapper.OaAttendanceRecordMapper;
import org.apache.ibatis.annotations.Select;

/**
 * 描述：操作考勤记录信息数据mapper接口数据
 *
 * @author 刘梓江
 * @date 2020/5/27  14:56
 */
public interface OaAttendanceRecordExtendMapper  extends OaAttendanceRecordMapper {


    /**
     * 获取最新的一次用户考勤记录
     * @param userId    用户id
     * @param delFlag   删除标志
     * @return
     */
    @Select("select * from  oa_attendance_record where user_no=#{userId} and is_delete=#{delFlag} order by create_time desc LIMIT 1 ")
    OaAttendanceRecord getUserRecordByUserId(String userId,String delFlag);
}