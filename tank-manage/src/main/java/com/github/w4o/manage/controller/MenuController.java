package com.github.w4o.manage.controller;

import com.github.w4o.core.base.CommonResult;
import com.github.w4o.manage.dto.param.menu.AddMenuParam;
import com.github.w4o.manage.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author frank
 * @date 2021/12/17
 */
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = {"菜单管理"})
@Validated
@Slf4j
public class MenuController {

    private final MenuService menuService;

    /**
     * 添加菜单
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加菜单")
    public CommonResult<?> add(@RequestBody @Valid AddMenuParam param) {
        menuService.add(param);
        return CommonResult.success();
    }

    /**
     * 删除菜单
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除菜单")
    public CommonResult<?> delete(@RequestParam("id") @NotNull Long id) {
        menuService.delete(id);
        return CommonResult.success();
    }

    /**
     * 查询导航菜单树
     */
    @GetMapping("/findNavTree")
    @ApiOperation(value = "查询导航菜单树")
    public CommonResult<?> findNavTree() {
        return CommonResult.success();
    }

    /**
     * 查询菜单树
     */
    @GetMapping("/findMenuTree")
    @ApiOperation(value = "查询菜单树")
    public CommonResult<?> findMenuTree() {
        return CommonResult.success();
    }


}
