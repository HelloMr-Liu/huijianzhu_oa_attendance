package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.dto.AttendanceUserDTO;
import com.huijianzhu.attendance.mapper.TblOaLoginMapper;
import com.huijianzhu.attendance.definition.AtttendanceUserQueryDefinition;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述：操作考勤人员信息数据mapper扩展接口
 *
 * @author 刘梓江
 * @date 2020/5/27  11:20
 */

public interface TblOaLoginExtendMapper extends TblOaLoginMapper {

    /**
     * 按照指定条件查询出所有有效用户考勤人员信息
     * @param query   查询条件
     * @param delFlag 删除标志
     * @return
     */
//    @Select({
//            "<script>"   ,
//                " select  tol.LOGIN_ID userId,tol.NAME userName,tol.DEPT deptId,oaf.base_data1 baseData1,oaf.base_data2 baseData2,oue.operating_state userState  "   ,
//                " from  tbl_oa_login tol  "   ,
//                " left join oa_user_expand oue on tol.LOGIN_ID=oue.user_id  "   ,
//                " left join oa_attendance_file oaf on oue.user_id=oaf.uniqueness_id  "   ,
//                " where "   ,
//                    "<if test='def.deptId!=null'>" ,
//                    "  tol.DEPT=#{def.deptId}  " ,
//                    "</if>",
//
//                    "<if test=' def.deptId!=null and def.userName !=null'>" ,
//                    " and ",
//                    "</if>",
//
//                    "<if test=' def.userName !=null'>" ,
//                        " tol.NAME like  concat('%',#{ def.userName },'%') and  " ,
//                    "</if>",
//                " tol.IS_DELETED=#{delFlag} and oue.operating_state!=#{def.userState}  and  oaf.is_delete=#{delFlag} and oaf.file_type=#{def.fileType}  "   ,
//                " order by oue.update_time desc",
//            " </script>"
//            })
    @Select({
            "<script>"   ,
                " select  tol.LOGIN_ID staffId,tol.NAME name,tol.DEPT deptId,oaf.base_data1 faceData,oaf.base_data2 baseData2,oue.operating_state status  "   ,
                " from  oa_user_expand oue  "   ,
                " left join tbl_oa_login tol        on tol.LOGIN_ID=oue.user_id  "   ,
                " left join oa_attendance_file oaf  on oue.user_id=oaf.uniqueness_id  "   ,
                " where  oue.operating_state!=#{def.userState} and oaf.file_type=#{def.fileType} and  tol.IS_DELETED=#{delFlag}    "   ,
                " order by oue.update_time desc",
            " </script>"
    })
    List<AttendanceUserDTO> findAllByQuery(@Param("def") AtttendanceUserQueryDefinition query, String delFlag);


    /**
     * 查询所有的有效用户对应的人员入职信息
     * @param query
     * @param delFlag
     * @return
     */
    @Select({
        "<script>"   ,
            "select oaf.base_data1 faceData,tol.NAME name,tol.LOGIN_ID staffId ",
            "from oa_attendance_file oaf  left join tbl_oa_login tol on  tol.LOGIN_ID=oaf.uniqueness_id  ",
            "where tol.IS_DELETED=#{delFlag} and oaf.file_type=#{def.fileType} ",
        " </script>"
    })
    List<AttendanceUserDTO> findAll(@Param("def") AtttendanceUserQueryDefinition query, String delFlag);

}