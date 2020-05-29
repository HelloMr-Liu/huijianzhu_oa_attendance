package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.entity.OaAttendanceType;
import com.huijianzhu.attendance.mapper.OaAttendanceTypeMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述：操作考勤类型信息数据mapper扩展接口
 *
 * @author 刘梓江
 * @date 2020/5/27  14:28
 */
public interface OaAttendanceTypeExtendMapper extends OaAttendanceTypeMapper {


    /**
     * 获取所有有效的考勤类型信息
     * @param delFlag
     * @return
     */
    @Select(" select * from oa_attendance_type where is_delete=#{delFlag} ")
    public List<OaAttendanceType> findAll(String delFlag);
}