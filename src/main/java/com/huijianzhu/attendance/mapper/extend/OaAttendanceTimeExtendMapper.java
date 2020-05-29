package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.entity.OaAttendanceTime;
import com.huijianzhu.attendance.mapper.OaAttendanceTimeMapper;
import org.apache.ibatis.annotations.Select;

/**
 * 描述：操作考勤时间信息数据mapper接口
 *
 * @author 刘梓江
 * @date 2020/5/27  14:15
 */
public interface OaAttendanceTimeExtendMapper extends OaAttendanceTimeMapper {


    /**
     * 获取当前默认的考勤时间
     * @param delFalg       删除标志
     * @param yesDefault    默认时间标志
     * @return
     */
    @Select("select * from oa_attendance_time where is_delete=#{delFalg} and r1=#{yesDefault} ")
    OaAttendanceTime getTimeByYesDefault(String delFalg,String yesDefault);
}
