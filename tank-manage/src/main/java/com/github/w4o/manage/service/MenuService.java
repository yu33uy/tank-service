package com.github.w4o.manage.service;

import com.github.w4o.manage.dto.param.menu.AddMenuParam;

import java.util.List;
import java.util.Map;

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
    void add(AddMenuParam param);

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
