package com.github.w4o.manage.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author frank
 */
@Data
@ApiModel(value = "用户登陆请求参数")
public class LoginParam {
    @NotBlank
    @Length(max = 50)
    @ApiModelProperty(value = "用户名", example = "abc", position = 1, required = true)
    private String username;

    @NotBlank
    @ApiModelProperty(value = "登陆密码", example = "123456", position = 2, required = true)
    private String password;

    private String captchaKey;
    private String verificationCode;
}
