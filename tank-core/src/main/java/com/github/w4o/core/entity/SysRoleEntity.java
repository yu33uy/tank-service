package com.github.w4o.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.w4o.core.base.BaseSysEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serial;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
@Getter
@Setter
@TableName("sys_role")
public class SysRoleEntity extends BaseSysEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 角色名
     */
    @ApiModelProperty("角色名称")
    @NotBlank
    private String roleName;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;


}
