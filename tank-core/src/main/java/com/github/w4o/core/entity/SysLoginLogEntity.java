package com.github.w4o.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.w4o.core.base.BaseSysEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * <p>
 * 登录日志表
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
@Getter
@Setter
@TableName("sys_login_log")
public class SysLoginLogEntity extends BaseSysEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录状态（online: 在线，登录初始状态，方便统计在线人数；login：退出登录后将online设置为login；logout：退出登录）
     */
    private String status;

    /**
     * IP地址
     */
    private String ip;


}
