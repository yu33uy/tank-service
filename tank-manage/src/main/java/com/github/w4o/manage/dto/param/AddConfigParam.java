package com.github.w4o.manage.dto.param;

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
@ApiModel("添加配置请求参数")
public class AddConfigParam {

    /**
     * 数据值
     */
    @ApiModelProperty("数据值")
    @NotBlank
    private String value;

    /**
     * 标签名
     */
    @ApiModelProperty("标签名")
    @NotBlank
    private String label;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @NotNull
    private Integer sort = NumberUtils.INTEGER_ZERO;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
