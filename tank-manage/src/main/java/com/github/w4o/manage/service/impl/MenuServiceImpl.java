package com.github.w4o.manage.service.impl;

import com.github.w4o.core.entity.SysMenuEntity;
import com.github.w4o.manage.mapper.SysMenuMapper;
import com.github.w4o.manage.service.MenuService;
import com.github.w4o.manage.dto.param.AddMenuParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author frank
 * @date 2021/12/17
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuServiceImpl implements MenuService {

    private final SysMenuMapper sysMenuMapper;

    @Override
    public void add(AddMenuParam param) {
        SysMenuEntity sysMenuEntity = new SysMenuEntity();
        BeanUtils.copyProperties(param, sysMenuEntity);
        sysMenuMapper.insert(sysMenuEntity);
    }
}
