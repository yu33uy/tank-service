package com.github.w4o.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.w4o.core.entity.SysMenuEntity;
import com.github.w4o.manage.dto.MenuDto;

import java.util.List;

/**
 * <p>
 * 系统菜单表 Mapper 接口
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

    List<MenuDto> getNavMenu();

    List<MenuDto> getAllList();
}
