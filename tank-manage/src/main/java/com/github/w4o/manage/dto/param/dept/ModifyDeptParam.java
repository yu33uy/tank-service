package com.github.w4o.manage.dto.param.dept;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author frank
 * @date 2021/12/18
 */
@Data
public class ModifyDeptParam {
    /**
     * 机构名
     */
    @ApiModelProperty("机构名")
    @NotBlank
    private String deptName;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @NotNull
    private Integer sort;
}
