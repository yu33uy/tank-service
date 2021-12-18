package com.github.w4o.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysUserEntity;
import com.github.w4o.manage.dto.param.AddUserParam;
import com.github.w4o.manage.mapper.SysUserMapper;
import com.github.w4o.manage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author frank
 * @date 2021/12/17
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final SysUserMapper sysUserMapper;

    @Override
    public void add(AddUserParam param) {
        SysUserEntity sysUserEntity = new SysUserEntity();
        BeanUtils.copyProperties(param, sysUserEntity);
        sysUserMapper.insert(sysUserEntity);
    }

    @Override
    public Page<Map<String, Object>> getPageList(long pageNo, long pageSize) {
        return sysUserMapper.getPageList(new Page<>(pageNo, pageSize));
    }
}
