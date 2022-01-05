package com.github.w4o.manage.service.impl;

import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.w4o.core.entity.SysMenuEntity;
import com.github.w4o.core.exception.CustomException;
import com.github.w4o.manage.common.ErrorCode;
import com.github.w4o.manage.dto.MenuDto;
import com.github.w4o.manage.dto.param.menu.MenuParam;
import com.github.w4o.manage.mapper.SysMenuMapper;
import com.github.w4o.manage.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author frank
 * @date 2021/12/17
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuServiceImpl implements MenuService {

    private final SysMenuMapper sysMenuMapper;

    @Override
    public void add(MenuParam param) {
        // 检查名称是否重复
        long count = sysMenuMapper.selectCount(new LambdaQueryWrapper<SysMenuEntity>()
                .eq(SysMenuEntity::getParentId, param.getParentId())
                .eq(SysMenuEntity::getMenuName, param.getMenuName()));
        if (count>0) {
            throw new CustomException(ErrorCode.E1011);
        }
        SysMenuEntity sysMenuEntity = new SysMenuEntity();
        BeanUtils.copyProperties(param, sysMenuEntity);
        sysMenuMapper.insert(sysMenuEntity);
    }

    @Override
    public void update(long id, MenuParam param) {
        SysMenuEntity queryEntity = sysMenuMapper.selectById(id);
        // 判断数据是否存在
        if (queryEntity == null) {
            throw new CustomException(ErrorCode.E1001);
        }
        // 检查名称是否重复
        long count = sysMenuMapper.selectCount(new LambdaQueryWrapper<SysMenuEntity>()
                .eq(SysMenuEntity::getParentId, param.getParentId())
                .eq(SysMenuEntity::getMenuName, param.getMenuName())
                .ne(SysMenuEntity::getId, id));
        if (count>0) {
            throw new CustomException(ErrorCode.E1011);
        }
        BeanUtils.copyProperties(param, queryEntity);
        sysMenuMapper.updateById(queryEntity);
    }

    @Override
    public void delete(long id) {
        Long menuCount = sysMenuMapper.selectCount(new LambdaQueryWrapper<SysMenuEntity>().eq(SysMenuEntity::getParentId, id));
        if (menuCount.compareTo(0L) > 0) {
            throw new CustomException(ErrorCode.E1007);
        }
        sysMenuMapper.deleteById(id);
    }

    @Override
    public List<?> findNavTree() {
        List <MenuDto> menuList = sysMenuMapper.getNavMenu();

        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setWeightKey("sort");
        treeNodeConfig.setDeep(3);

        return TreeUtil.build(menuList, 0L, treeNodeConfig, (treeNode, tree) -> {
            tree.setId(treeNode.getId());
            tree.setParentId(treeNode.getParentId());
            tree.setWeight(treeNode.getSort().toString());
            tree.setName(treeNode.getMenuName());
            tree.put("icon", treeNode.getIcon());
        });
    }

    @Override
    public List<?> findMenuTree() {
        List <MenuDto> menuList = sysMenuMapper.getAllList();

        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setWeightKey("sort");
        treeNodeConfig.setDeep(3);

        return TreeUtil.build(menuList, 0L, treeNodeConfig, (treeNode, tree) -> {
            tree.setId(treeNode.getId());
            tree.setParentId(treeNode.getParentId());
            tree.setWeight(treeNode.getSort().toString());
            tree.setName(treeNode.getMenuName());
        });
    }
}
