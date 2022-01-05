package com.github.w4o.manage.dto.param.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Frank
 */
@ApiModel("添加角色菜单请求参数")
@Data
public class AddRoleMenuParam {

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    @NotNull
    private Long roleId;

    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    @NotNull
    private Long menuId;
}
