package com.github.w4o.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.w4o.core.base.BaseSysEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * <p>
 * 系统菜单表
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
@Getter
@Setter
@TableName("sys_menu")
public class SysMenuEntity extends BaseSysEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 菜单url，类型：1.普通页面，路由地址 2.外部页面，以http(s)开头 3.嵌套页面，使用iframe
     */
    private String url;

    /**
     * 授权，多个用都好分割
     */
    private String perms;

    /**
     * 类型 1：目录 2：菜单 3：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;


}
