package com.github.w4o.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysConfigEntity;
import com.github.w4o.core.entity.SysDictEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 Mapper 接口
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
public interface SysDictMapper extends BaseMapper<SysDictEntity> {

    /**
     * 分页列表查询
     *
     * @param page 分页参数
     * @return 分页列表
     */
    Page<Map<String, Object>> getPageList(Page<Map<String, Object>> page);

    /**
     * 根据标签查询
     * @param label 标签
     * @return 字典信息
     */
    List<SysDictEntity> getByLabel(@Param("label") String label);
}
