package com.github.w4o.manage.dto.param.dept;

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
@ApiModel("添加机构请求参数")
public class AddDeptParam {
    /**
     * 机构名
     */
    @ApiModelProperty("机构名")
    @NotBlank
    private String deptName;

    /**
     * 上级机构ID， 一级机构为0
     */
    @ApiModelProperty("上级机构ID")
    @NotNull
    private Long parentId = NumberUtils.LONG_ZERO;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @NotNull
    private Integer sort = NumberUtils.INTEGER_ZERO;
}
