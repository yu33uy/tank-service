package com.github.w4o.manage.controller;

import com.github.w4o.core.base.CommonResult;
import com.github.w4o.manage.dto.param.AddDeptParam;
import com.github.w4o.manage.dto.param.ModifyDeptParam;
import com.github.w4o.manage.service.DeptService;
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
@RequestMapping("/dept")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = {"机构管理"})
@Validated
@Slf4j
public class DeptController {

    private final DeptService deptService;

    /**
     * 添加机构
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加机构")
    public CommonResult<?> add(@RequestBody @Valid AddDeptParam addDeptParam) {
        deptService.add(addDeptParam);
        return CommonResult.success();
    }

    /**
     * 修改机构信息
     */
    @PutMapping("/modify")
    @ApiOperation(value = "修改机构")
    public CommonResult<?> modify(@RequestParam("id") @NotNull Long id,
                                  @RequestBody @Valid ModifyDeptParam param) {
        deptService.update(id, param);
        return CommonResult.success();
    }

    /**
     * 删除机构
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除机构")
    public CommonResult<?> delete(@RequestParam("id") @NotNull Long id) {
        deptService.delete(id);
        return CommonResult.success();
    }

    /**
     * 查询机构树
     */
    @GetMapping("/findTree")
    @ApiOperation(value = "查询机构树")
    public CommonResult<?> findTree() {
        return CommonResult.success(deptService.findTree());
    }
}
