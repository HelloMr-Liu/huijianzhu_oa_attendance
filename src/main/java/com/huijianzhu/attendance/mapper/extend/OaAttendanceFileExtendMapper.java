package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.entity.OaAttendanceFileWithBLOBs;
import com.huijianzhu.attendance.mapper.OaAttendanceFileMapper;
import org.apache.ibatis.annotations.Select;

/**
 * 描述：操作考勤文件信息数据mapper扩展接口
 *
 * @author 刘梓江
 * @date 2020/5/27  16:51
 */
public interface OaAttendanceFileExtendMapper extends OaAttendanceFileMapper {

    /**
     * 获取指定记录id对应的文件信息
     * @param delFlag       删除标志
     * @param recordId      记录id
     * @return
     */
    @Select(" select * from oa_attendance_file where is_delete=#{delFlag} and uniqueness_id=#{recordId} ")
    public OaAttendanceFileWithBLOBs getFileByRecordId(String delFlag, String recordId);
}