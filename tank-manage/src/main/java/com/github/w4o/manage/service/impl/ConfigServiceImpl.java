package com.github.w4o.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysConfigEntity;
import com.github.w4o.manage.mapper.SysConfigMapper;
import com.github.w4o.manage.service.ConfigService;
import com.github.w4o.manage.dto.param.AddConfigParam;
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
        SysConfigEntity sysConfigEntity = new SysConfigEntity();
        BeanUtils.copyProperties(param, sysConfigEntity);
        sysConfigMapper.insert(sysConfigEntity);
    }

    @Override
    public Page<Map<String, Object>> getPageList(long pageNo, long pageSize) {
        return sysConfigMapper.getPageList(new Page<>(pageNo, pageSize));
    }
}
