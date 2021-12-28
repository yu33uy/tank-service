package com.github.w4o.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.manage.mapper.SysLoginLogMapper;
import com.github.w4o.manage.service.LoginLogService;
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
public class LoginLogServiceImpl implements LoginLogService {

    private final SysLoginLogMapper sysLoginLogMapper;

    @Override
    public Page<Map<String, Object>> getPageList(long pageNo, long pageSize) {
        return sysLoginLogMapper.getPageList(new Page<>(pageNo, pageSize));
    }

    @Override
    public void clean() {
        sysLoginLogMapper.clean();
    }
}
