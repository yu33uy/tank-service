package com.github.w4o.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysLogEntity;

import java.util.Map;

/**
 * <p>
 * 操作日志表 Mapper 接口
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

    /**
     * 分页列表查询
     *
     * @param page 分页参数
     * @return 分页列表
     */
    Page<Map<String, Object>> getPageList(Page<Map<String, Object>> page);

}
