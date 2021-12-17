package com.github.w4o.manage.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author frank
 */
@Data
@Builder
@ApiModel(value = "用户登陆响应结果")
public class LoginVO {
    @ApiModelProperty(value = "jwt字符串", example = "Bearer xxxxx")
    private String token;
}
