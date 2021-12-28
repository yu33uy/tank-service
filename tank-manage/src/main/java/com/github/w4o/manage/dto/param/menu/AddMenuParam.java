package com.github.w4o.manage.dto.param.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author frank
 * @date 2021/12/17
 */
@Data
@ApiModel("添加菜单请求参数")
public class AddMenuParam {
    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    @NotBlank
    private String menuName;

    /**
     * 父菜单ID，一级菜单为0
     */
    @ApiModelProperty("父菜单ID")
    @NotNull
    private Long parentId = NumberUtils.LONG_ZERO;

    /**
     * 菜单url，类型：1.普通页面，路由地址 2.外部页面，以http(s)开头 3.嵌套页面，使用iframe
     */
    @ApiModelProperty("菜单url")
    @NotBlank
    private String url;

    /**
     * 授权，多个用逗号分割
     */
    @ApiModelProperty("授权，多个用逗号分割")
    private String perms = "*";

    /**
     * 类型 1：目录 2：菜单 3：按钮
     */
    @ApiModelProperty("类型")
    @NotNull
    private Integer type;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    @NotNull
    private String icon;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort = NumberUtils.INTEGER_ZERO;
}
