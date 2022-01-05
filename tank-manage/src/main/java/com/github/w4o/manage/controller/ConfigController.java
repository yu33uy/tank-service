package com.github.w4o.manage.controller;

import com.github.w4o.core.base.CommonResult;
import com.github.w4o.manage.dto.param.config.ModifyConfigParam;
import com.github.w4o.manage.service.ConfigService;
import com.github.w4o.manage.dto.param.config.AddConfigParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author frank
 * @date 2021/12/17
 */
@RestController
@RequestMapping("/config")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = {"配置管理"})
@Validated
@Slf4j
public class ConfigController {

    private final ConfigService configService;

    /**
     * 添加配置
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加配置")
    public CommonResult<?> add(@RequestBody @Valid AddConfigParam param) {
        configService.add(param);
        return CommonResult.success();
    }

    /**
     * 修改配置信息
     */
    @PutMapping("/modify")
    @ApiOperation(value = "修改配置信息")
    public CommonResult<?> modify(@RequestParam("id") @NotNull Long id,
                                  @RequestBody @Valid ModifyConfigParam param) {
        configService.update(id, param);
        return CommonResult.success();
    }

    /**
     * 删除配置
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除配置")
    public CommonResult<?> delete(@RequestParam("id") @NotNull Long id) {
        configService.delete(id);
        return CommonResult.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询")
    public CommonResult<?> findPage(@RequestParam("pageNo") @NotNull @Min(1) Long pageNo,
                                    @RequestParam("pageSize") @NotNull @Max(100) Long pageSize) {
        return CommonResult.success(configService.getPageList(pageNo, pageSize));
    }

    /**
     * 根据标签查询
     */
    @GetMapping("/findByLabel")
    @ApiOperation(value = "根据标签查询")
    public CommonResult<?> findByLabel(@RequestParam("label") @NotBlank String label) {
        return CommonResult.success(configService.findByLabel(label));
    }

}
