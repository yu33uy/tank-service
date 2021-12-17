package com.github.w4o.manage.dto.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author frank
 * @date 2021/12/17
 */
@Data
public class AddUserParam {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotBlank
    private String username;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 状态 0：禁用 1：正常
     */
    @ApiModelProperty("状态")
    private Boolean status = true;

    /**
     * 机构ID
     */
    @ApiModelProperty("机构ID")
    @NotNull
    private Long deptId;
}
