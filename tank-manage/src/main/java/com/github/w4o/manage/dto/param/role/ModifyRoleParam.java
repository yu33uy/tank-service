package com.github.w4o.manage.dto.param.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author frank
 * @date 2021/12/17
 */
@Data
@ApiModel("修改角色请求参数")
public class ModifyRoleParam {
    /**
     * 角色名
     */
    @ApiModelProperty("角色名")
    @NotBlank
    private String roleName;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
