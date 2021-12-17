package com.github.w4o.manage.controller;

import com.github.w4o.core.base.CommonResult;
import com.github.w4o.manage.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author frank
 * @date 2021/12/17
 */
@RestController
@RequestMapping("/loginLog")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = {"登录日志"})
@Validated
@Slf4j
public class LoginLogController {

    private final LoginLogService loginLogService;

    /**
     * 分页查询
     */
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询")
    public CommonResult<?> findPage(@RequestParam("pageNo") @NotNull @Min(1) Long pageNo,
                                    @RequestParam("pageSize") @NotNull @Max(100) Long pageSize) {
        return CommonResult.success(loginLogService.getPageList(pageNo, pageSize));
    }

    /**
     * 清除登录日志
     */
    @DeleteMapping("/clear")
    @ApiOperation(value = "清除登录日志")
    public CommonResult<?> clear() {
        return CommonResult.success();
    }

}
