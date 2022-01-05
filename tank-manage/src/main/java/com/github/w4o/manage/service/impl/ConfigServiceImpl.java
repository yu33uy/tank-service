package com.github.w4o.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysConfigEntity;
import com.github.w4o.core.exception.CustomException;
import com.github.w4o.manage.common.ErrorCode;
import com.github.w4o.manage.dto.param.config.ModifyConfigParam;
import com.github.w4o.manage.mapper.SysConfigMapper;
import com.github.w4o.manage.service.ConfigService;
import com.github.w4o.manage.dto.param.config.AddConfigParam;
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
public class ConfigServiceImpl implements ConfigService {

    private final SysConfigMapper sysConfigMapper;

    @Override
    public void add(AddConfigParam param) {
        SysConfigEntity queryEntity = sysConfigMapper.getByLabel(param.getLabel());
        if (queryEntity != null) {
            throw new CustomException(ErrorCode.E1008);
        }
        SysConfigEntity sysConfigEntity = new SysConfigEntity();
        BeanUtils.copyProperties(param, sysConfigEntity);
        sysConfigMapper.insert(sysConfigEntity);
    }

    @Override
    public Page<Map<String, Object>> getPageList(long pageNo, long pageSize) {
        return sysConfigMapper.getPageList(new Page<>(pageNo, pageSize));
    }

    @Override
    public void update(Long id, ModifyConfigParam param) {
        SysConfigEntity queryEntity = sysConfigMapper.selectById(id);
        // 判断数据是否存在
        if (queryEntity == null) {
            throw new CustomException(ErrorCode.E1001);
        }
        queryEntity.setValue(param.getValue());
        queryEntity.setDescription(param.getDescription());
        queryEntity.setRemark(param.getRemark());
        queryEntity.setSort(param.getSort());

        sysConfigMapper.updateById(queryEntity);
    }

    @Override
    public void delete(Long id) {
        sysConfigMapper.deleteById(id);
    }

    @Override
    public SysConfigEntity findByLabel(String label) {
        SysConfigEntity queryEntity = sysConfigMapper.getByLabel(label);
        if (queryEntity == null) {
            throw new CustomException(ErrorCode.E1001);
        }
        return queryEntity;
    }
}
