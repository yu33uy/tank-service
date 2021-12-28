package com.github.w4o.manage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysUserEntity;
import com.github.w4o.core.exception.CustomException;
import com.github.w4o.manage.common.ErrorCode;
import com.github.w4o.manage.dto.param.user.AddUserParam;
import com.github.w4o.manage.dto.param.user.ModifyUserParam;
import com.github.w4o.manage.mapper.SysUserMapper;
import com.github.w4o.manage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        // 检查用户名是否重复
        Long userCount = sysUserMapper.selectCount(new LambdaQueryWrapper<SysUserEntity>().eq(SysUserEntity::getUsername, param.getUsername()));
        if (userCount.compareTo(0L) > 0) {
            throw new CustomException(ErrorCode.E1006);
        }
        SysUserEntity sysUserEntity = new SysUserEntity();
        BeanUtils.copyProperties(param, sysUserEntity);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        sysUserEntity.setPassword(encoder.encode(sysUserEntity.getPassword()));
        sysUserMapper.insert(sysUserEntity);
    }

    @Override
    public void delete(Long id) {
        sysUserMapper.deleteById(id);
    }

    @Override
    public void update(Long id, ModifyUserParam param) {
        SysUserEntity queryEntity = sysUserMapper.selectById(id);
        // 判断数据是否存在
        if (queryEntity == null) {
            throw new CustomException(ErrorCode.E1001);
        }
        BeanUtil.copyProperties(param, queryEntity);
        sysUserMapper.updateById(queryEntity);
    }

    @Override
    public void disable(Long id) {
        SysUserEntity queryEntity = sysUserMapper.selectById(id);
        // 判断数据是否存在
        if (queryEntity == null) {
            throw new CustomException(ErrorCode.E1001);
        }
        queryEntity.setStatus(0);
        sysUserMapper.updateById(queryEntity);
    }

    @Override
    public void enable(Long id) {
        SysUserEntity queryEntity = sysUserMapper.selectById(id);
        // 判断数据是否存在
        if (queryEntity == null) {
            throw new CustomException(ErrorCode.E1001);
        }
        queryEntity.setStatus(1);
        sysUserMapper.updateById(queryEntity);
    }

    @Override
    public Page<Map<String, Object>> getPageList(long pageNo, long pageSize) {
        return sysUserMapper.getPageList(new Page<>(pageNo, pageSize));
    }
}
