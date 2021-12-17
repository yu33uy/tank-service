package com.github.w4o.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.w4o.core.base.BaseSysEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
@Getter
@Setter
@TableName("sys_user_role")
public class SysUserRoleEntity extends BaseSysEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统用户ID
     */
    private Long sysUserId;

    /**
     * 系统角色ID
     */
    private Long sysRoleId;


}
