package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.entity.OaAttendanceRecordResult;
import com.huijianzhu.attendance.mapper.OaAttendanceRecordResultMapper;
import org.apache.ibatis.annotations.Select;

/**
 * 描述：操作考勤记录结果信息数据mapper扩展接口
 *
 * @author 刘梓江
 * @date 2020/5/27  16:37
 */
@SuppressWarnings("all")
public interface OaAttendanceRecordResultExtendMapper extends OaAttendanceRecordResultMapper {


        /**
         * 获取指定打卡记录id对应的结果信息
         *
         * @param delFlag  删除标志
         * @param recordId 记录id
         * @return
         */
        @Select("select * from oa_attendance_record_result where is_delete=#{delFlag} and record_id=#{recordId} ")
        public OaAttendanceRecordResult getRecordResultByRecordId(String delFlag, String recordId);
}