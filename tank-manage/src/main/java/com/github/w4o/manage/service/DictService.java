package com.github.w4o.manage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysDictEntity;
import com.github.w4o.manage.dto.param.dict.AddDictParam;
import com.github.w4o.manage.dto.param.config.ModifyConfigParam;

import java.util.List;
import java.util.Map;

/**
 * @author frank
 * @date 2021/12/17
 */
public interface DictService {

    /**
     * 添加配置
     *
     * @param param 请求参数
     */
    void add(AddDictParam param);

    /**
     * 获取分页列表
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 分页列表
     */
    Page<Map<String, Object>> getPageList(long pageNo, long pageSize);

    /**
     * 修改字典信息
     *
     * @param id    字典id
     * @param param 请求参数
     */
    void update(Long id, ModifyConfigParam param);

    /**
     * 删除字典
     *
     * @param id 字典id
     */
    void delete(Long id);

    /**
     * 根据标签查询字典信息
     * @param label 标签
     * @return 字典信息
     */
    List<SysDictEntity> findByLabel(String label);
}
