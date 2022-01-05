package com.github.w4o.manage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysConfigEntity;
import com.github.w4o.manage.dto.param.config.AddConfigParam;
import com.github.w4o.manage.dto.param.config.ModifyConfigParam;

import java.util.Map;

/**
 * @author frank
 * @date 2021/12/17
 */
public interface ConfigService {

    /**
     * 添加配置
     *
     * @param param 请求参数
     */
    void add(AddConfigParam param);

    /**
     * 获取分页列表
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 分页列表
     */
    Page<Map<String, Object>> getPageList(long pageNo, long pageSize);

    /**
     * 修改配置信息
     *
     * @param id    配置id
     * @param param 请求参数
     */
    void update(Long id, ModifyConfigParam param);

    /**
     * 删除配置
     *
     * @param id 配置id
     */
    void delete(Long id);

    /**
     * 根据标签查询配置信息
     * @param label 标签
     * @return 配置信息
     */
    SysConfigEntity findByLabel(String label);
}
