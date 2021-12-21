package com.github.w4o.manage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.manage.dto.param.AddUserParam;
import com.github.w4o.manage.dto.param.ModifyUserParam;

import java.util.Map;

/**
 * @author frank
 * @date 2021/12/17
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param param 请求参数
     */
    void add(AddUserParam param);

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    void delete(Long id);

    /**
     * 修改用户
     *
     * @param id    用户id
     * @param param 请求参数
     */
    void update(Long id, ModifyUserParam param);

    /**
     * 禁用用户
     *
     * @param id 用户id
     */
    void disable(Long id);

    /**
     * 启用用户
     *
     * @param id 用户id
     */
    void enable(Long id);

    /**
     * 获取分页列表
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 分页列表
     */
    Page<Map<String, Object>> getPageList(long pageNo, long pageSize);
}
