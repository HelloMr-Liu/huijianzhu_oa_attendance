package com.huijianzhu.attendance.definition;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 描述：考勤用户打卡记录信息属性定义
 *
 * @author 刘梓江
 * @date 2020/5/27  14:08
 */
@Data
public class AttendanceUserClockDefinition {

    /**
     * 设备标识
     */
    @NotBlank(message = "没有设备标识")
    private String token;

    /**
     * 用户id
     */
    @NotBlank(message = "没有用户id")
    private String staffId;

    /**
     * 打卡时间
     */
    @NotNull(message = "没有打卡时间")
    private Long clockTime;

    /**
     * 用户名称
     */
    private String userName;


    /**
     * 用户文件名称
     */
    private String fileName;

    /**
     * 用户打卡文件
     */
    //private MultipartFile file;

    /**
     * 基本数据
     */
    @NotBlank(message = "没有打卡数据信息")
    private String file;


}
