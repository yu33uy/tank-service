package com.github.w4o.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.manage.mapper.SysRoleMapper;
import com.github.w4o.manage.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author frank
 * @date 2021/12/17
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {

    private final SysRoleMapper sysRoleMapper;

    @Override
    public Page<Map<String, Object>> getPageList(long pageNo, long pageSize) {
        return sysRoleMapper.getPageList(new Page<>(pageNo, pageSize));
    }
}
