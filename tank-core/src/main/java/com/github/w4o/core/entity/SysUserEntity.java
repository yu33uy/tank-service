package com.github.w4o.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.w4o.core.base.BaseSysEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
@Getter
@Setter
@TableName("sys_user")
public class SysUserEntity extends BaseSysEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态 0：禁用 1：正常
     */
    private Boolean status;

    /**
     * 机构ID
     */
    private Long deptId;

}
