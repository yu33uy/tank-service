package com.github.w4o.manage.service;

import com.github.w4o.manage.dto.param.AddMenuParam;

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
}
