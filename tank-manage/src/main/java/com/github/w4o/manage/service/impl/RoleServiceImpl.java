package com.github.w4o.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysRoleEntity;
import com.github.w4o.core.entity.SysRoleMenuEntity;
import com.github.w4o.core.entity.SysUserRoleEntity;
import com.github.w4o.core.exception.CustomException;
import com.github.w4o.manage.common.ErrorCode;
import com.github.w4o.manage.dto.param.role.AddRoleMenuParam;
import com.github.w4o.manage.dto.param.role.AddRoleParam;
import com.github.w4o.manage.dto.param.role.ModifyRoleParam;
import com.github.w4o.manage.mapper.SysRoleMapper;
import com.github.w4o.manage.mapper.SysRoleMenuMapper;
import com.github.w4o.manage.mapper.SysUserRoleMapper;
import com.github.w4o.manage.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author frank
 * @date 2021/12/17
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {

    private final SysRoleMapper sysRoleMapper;
    private final SysUserRoleMapper sysUserRoleMapper;
    private final SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public Page<Map<String, Object>> getPageList(long pageNo, long pageSize) {
        return sysRoleMapper.getPageList(new Page<>(pageNo, pageSize));
    }

    @Override
    public void add(AddRoleParam param) {
        // 判断名称是否重复
        Long count = sysRoleMapper.selectCount(new LambdaQueryWrapper<SysRoleEntity>()
                .eq(SysRoleEntity::getRoleName, param.getRoleName()));
        if (count>0) {
            throw new CustomException(ErrorCode.E1009);
        }
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        BeanUtils.copyProperties(param, sysRoleEntity);
        sysRoleMapper.insert(sysRoleEntity  );
    }

    @Override
    public void update(Long id , ModifyRoleParam param) {
        SysRoleEntity queryEntity = sysRoleMapper.selectById(id);
        // 判断数据是否存在
        if (queryEntity == null) {
            throw new CustomException(ErrorCode.E1001);
        }
        // 判断名称是否重复
        Long count = sysRoleMapper.selectCount(new LambdaQueryWrapper<SysRoleEntity>()
                .eq(SysRoleEntity::getRoleName, param.getRoleName())
                .ne(SysRoleEntity::getId, id));
        if (count>0) {
            throw new CustomException(ErrorCode.E1009);
        }
        queryEntity.setRoleName(param.getRoleName());
        queryEntity.setRemark(param.getRemark());
        sysRoleMapper.updateById(queryEntity);
    }

    @Override
    public void delete(Long id) {
        // 检查角色下是否有用户
        Long count = sysUserRoleMapper.selectCount(new LambdaQueryWrapper< SysUserRoleEntity >()
                .eq(SysUserRoleEntity::getSysRoleId,id));
        if (count>0) {
            throw new CustomException(ErrorCode.E1010);
        }
        sysRoleMapper.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> getAll() {
        return sysRoleMapper.selectMaps(new LambdaQueryWrapper<SysRoleEntity>()
                .select(SysRoleEntity::getRoleName,SysRoleEntity::getId));
    }

    @Override
    public List<Map<String, Object>> getRoleMenu(Long roleId) {
        return sysRoleMenuMapper.getRoleMenu(roleId);
    }

    @Override
    public void addRoleMenu(AddRoleMenuParam param) {
        SysRoleMenuEntity sysRoleMenu = new SysRoleMenuEntity();
        sysRoleMenu.setSysMenuId(param.getMenuId());
        sysRoleMenu.setSysRoleId(param.getRoleId());
        sysRoleMenuMapper.insert(sysRoleMenu);
    }
}
