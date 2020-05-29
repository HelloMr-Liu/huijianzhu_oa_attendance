package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.mapper.OaUserExpandMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 描述：操作用户扩展信息数据mapper扩展接口
 *
 * @author 刘梓江
 * @date 2020/5/29  12:52
 */
public interface OaUserExpandExtendMapper  extends OaUserExpandMapper {

    /**
     * 按照指定用户id批量修改用户状态信息
     * @param userIds       用户id集
     * @param userState     用户状态(正常）
     */
    @Update({
            "<script> ",
                " UPDATE  oa_user_expand",
                " <trim prefix ='set' prefixOverrides=',' > ",

                    "<trim prefix ='operating_state = case' suffix='end,'>",
                        "<foreach collection ='def' item ='item' index = 'index'> ",
                           "when user_id = #{item} then #{userState} ",
                        "</foreach>",
                    "</trim> ",

                    "<trim prefix ='update_time = case' suffix='end'>",
                        "<foreach collection ='def' item ='item' index = 'index'> ",
                             "when user_id = #{item} then sysdate() ",
                        "</foreach>",
                    "</trim> ",

                " </trim> ",
                " WHERE user_id in ",
                " (",
                    "<foreach collection='def' item='item' index='index' separator=','>",
                        " #{item}",
                    "</foreach>",
                " )",
            "</script>"
    })
    void batchUpdateUserState(@Param("def") List<String> userIds, String userState);
}