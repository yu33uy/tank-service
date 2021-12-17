package com.github.w4o.manage.service.impl;

import com.github.w4o.core.entity.SysDeptEntity;
import com.github.w4o.manage.mapper.SysDeptMapper;
import com.github.w4o.manage.dto.param.AddDeptParam;
import com.github.w4o.manage.service.DeptService;
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
public class DeptServiceImpl implements DeptService {

    private final SysDeptMapper sysDeptMapper;

    @Override
    public void add(AddDeptParam param) {
        SysDeptEntity sysDeptEntity = new SysDeptEntity();
        BeanUtils.copyProperties(param, sysDeptEntity);
        sysDeptMapper.insert(sysDeptEntity);
    }

}
