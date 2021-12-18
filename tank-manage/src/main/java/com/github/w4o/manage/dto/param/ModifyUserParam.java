package com.github.w4o.manage.dto.param;

import com.github.w4o.core.constant.RegEx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author frank
 * @date 2021/12/18
 */
@Data
public class ModifyUserParam {
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
    @Pattern(regexp = RegEx.E_MAIL)
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @Pattern(regexp = RegEx.PHONE_NUMBER)
    private String mobile;

    /**
     * 机构ID
     */
    @ApiModelProperty("机构ID")
    @NotNull
    private Long deptId;
}
