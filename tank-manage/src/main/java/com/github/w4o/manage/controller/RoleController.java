package com.github.w4o.manage.controller;

import com.github.w4o.core.base.CommonResult;
import com.github.w4o.manage.service.RoleService;
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
@RequestMapping("/role")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = {"角色管理"})
@Validated
@Slf4j
public class RoleController {

    private final RoleService roleService;

    /**
     * 添加角色
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加角色", notes = "")
    public CommonResult<?> add() {
        return CommonResult.success();
    }

    /**
     * 修改角色信息
     */
    @PostMapping("/modify")
    @ApiOperation(value = "修改角色")
    public CommonResult<?> modify() {
        return CommonResult.success();
    }

    /**
     * 删除角色
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除角色")
    public CommonResult<?> delete() {
        return CommonResult.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询")
    public CommonResult<?> findPage(@RequestParam("pageNo") @NotNull @Min(1) Long pageNo,
                                    @RequestParam("pageSize") @NotNull @Max(100) Long pageSize) {
        return CommonResult.success(roleService.getPageList(pageNo, pageSize));
    }

    /**
     * 查询全部角色
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询全部角色")
    public CommonResult<?> findAll() {
        return CommonResult.success();
    }

    /**
     * 查询角色菜单
     */
    @GetMapping("/findRoleMenu")
    @ApiOperation(value = "查询角色菜单")
    public CommonResult<?> findRoleMenu() {
        return CommonResult.success();
    }

    /**
     * 保存角色菜单
     */
    @PostMapping("/saveRoleMenu")
    @ApiOperation(value = "保存角色菜单")
    public CommonResult<?> saveRoleMenu() {
        return CommonResult.success();
    }

}
