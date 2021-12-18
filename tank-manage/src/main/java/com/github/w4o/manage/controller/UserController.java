package com.github.w4o.manage.controller;

import com.github.w4o.core.base.CommonResult;
import com.github.w4o.manage.dto.param.AddUserParam;
import com.github.w4o.manage.dto.param.ModifyUserParam;
import com.github.w4o.manage.service.UserService;
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
import javax.validation.constraints.NotNull;

/**
 * @author frank
 * @date 2021/12/17
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = {"用户管理"})
@Validated
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * 添加用户
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加用户")
    public CommonResult<?> add(@RequestBody @Valid AddUserParam param) {
        userService.add(param);
        return CommonResult.success();
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/modify")
    @ApiOperation(value = "修改用户")
    public CommonResult<?> modify(@RequestParam("id") @NotNull Long id,
                                  @RequestBody @Valid ModifyUserParam param) {
        userService.update(id, param);
        return CommonResult.success();
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除用户")
    public CommonResult<?> delete(@RequestParam("id") @NotNull Long id) {
        userService.delete(id);
        return CommonResult.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询")
    public CommonResult<?> findPage(@RequestParam("pageNo") @NotNull @Min(1) Long pageNo,
                                    @RequestParam("pageSize") @NotNull @Max(100) Long pageSize) {
        return CommonResult.success(userService.getPageList(pageNo, pageSize));
    }

    /**
     * 用户详情
     */
    @GetMapping("/info")
    @ApiOperation(value = "用户详细信息")
    public CommonResult<?> info() {
        return CommonResult.success();
    }

    /**
     * 查询用户权限
     */
    @GetMapping("/findPermissions")
    @ApiOperation(value = "查询用户权限")
    public CommonResult<?> findPermissions() {
        return CommonResult.success();
    }

    /**
     * 查询用户角色
     */
    @GetMapping("/findUserRoles")
    @ApiOperation(value = "查询用户角色")
    public CommonResult<?> findUserRoles() {
        return CommonResult.success();
    }

}
