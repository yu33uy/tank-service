package com.github.w4o.manage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.manage.dto.param.role.AddRoleMenuParam;
import com.github.w4o.manage.dto.param.role.AddRoleParam;
import com.github.w4o.manage.dto.param.role.ModifyRoleParam;

import java.util.List;
import java.util.Map;

/**
 * @author frank
 * @date 2021/12/17
 */
public interface RoleService {

    /**
     * 获取分页列表
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 分页列表
     */
    Page<Map<String, Object>> getPageList(long pageNo, long pageSize);

    /**
     * 添加角色
     * @param param 请求参数
     */
    void add(AddRoleParam param);

    /**
     * 修改角色
     * @param id 角色id
     * @param param 请求参数
     */
    void update(Long id, ModifyRoleParam param);

    /**
     * 删除角色
     * @param id 角色id
     */
    void delete(Long id);

    /**
     * 查询全部角色
     * @return 角色集合
     */
    List<Map <String, Object>> getAll();

    /**
     * 角色菜单列表查询
     * @param roleId 角色id
     * @return 菜单列表
     */
    List <Map <String, Object>> getRoleMenu(Long roleId);

    /**
     * 添加角色菜单
     * @param param 请求参数
     */
    void addRoleMenu(AddRoleMenuParam param);
}
