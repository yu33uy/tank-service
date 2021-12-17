package com.github.w4o.manage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.manage.dto.param.AddDictParam;

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
}
