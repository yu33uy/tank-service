package com.github.w4o.manage.service;

import com.github.w4o.manage.dto.param.menu.MenuParam;

import java.util.List;

/**
 * @author frank
 * @date 2021/12/17
 */
public interface MenuService {

    /**
     * 添加菜单
     *
     * @param param 请求参数
     */
    void add(MenuParam param);

    /**
     * 修改菜单
     * @param param 请求参数
     */
    void update (long id, MenuParam param);

    /**
     * 删除菜单
     *
     * @param id 菜单Id
     */
    void delete(long id);

    /**
     * 导航菜单树
     * @return
     */
    List<?> findNavTree();

    /**
     * 菜单树
     * @return
     */
    List<?> findMenuTree();
}
