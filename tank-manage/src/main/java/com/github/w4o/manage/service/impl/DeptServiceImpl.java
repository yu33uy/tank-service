package com.github.w4o.manage.service.impl;

import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.w4o.core.entity.SysDeptEntity;
import com.github.w4o.manage.dto.param.AddDeptParam;
import com.github.w4o.manage.mapper.SysDeptMapper;
import com.github.w4o.manage.service.DeptService;
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
public class DeptServiceImpl implements DeptService {

    private final SysDeptMapper sysDeptMapper;

    @Override
    public void add(AddDeptParam param) {
        SysDeptEntity sysDeptEntity = new SysDeptEntity();
        BeanUtils.copyProperties(param, sysDeptEntity);
        sysDeptMapper.insert(sysDeptEntity);
    }

    @Override
    public List<?> findTree() {
        List<SysDeptEntity> deptList = sysDeptMapper.selectList(new QueryWrapper<>());
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setWeightKey("sort");
        treeNodeConfig.setDeep(3);
        return TreeUtil.build(deptList, 0L, treeNodeConfig, (treeNode, tree) -> {
            tree.setId(treeNode.getId());
            tree.setParentId(treeNode.getParentId());
            tree.setWeight(treeNode.getSort().toString());
            tree.setName(treeNode.getDeptName());
        });
    }
}
