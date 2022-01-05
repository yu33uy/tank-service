package com.github.w4o.manage.dto.param.dict;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ModifyDictParam {

    /**
     * 数据值
     */
    @ApiModelProperty("数据值")
    @NotBlank
    private String value;

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
