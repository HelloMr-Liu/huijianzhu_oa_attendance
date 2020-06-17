package com.huijianzhu.attendance.definition;

import lombok.Data;

/**
 * 描述：封装前端同步成功对应的用户信息
 *
 * @author 刘梓江
 * @date 2020/6/16  12:42
 */
@Data
@SuppressWarnings("all")
public class SynchronizUserDefinition {

    private String staffId;
    private String status;
    private String isFinish;
    private String type;
}
