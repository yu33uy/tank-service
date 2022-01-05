package com.github.w4o.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.w4o.core.entity.SysDictEntity;
import com.github.w4o.core.exception.CustomException;
import com.github.w4o.manage.common.ErrorCode;
import com.github.w4o.manage.dto.param.config.ModifyConfigParam;
import com.github.w4o.manage.mapper.SysDictMapper;
import com.github.w4o.manage.service.DictService;
import com.github.w4o.manage.dto.param.dict.AddDictParam;
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
public class DictServiceImpl implements DictService {

    private final SysDictMapper sysDictMapper;

    @Override
    public void add(AddDictParam param) {
        SysDictEntity sysDictEntity = new SysDictEntity();
        BeanUtils.copyProperties(param, sysDictEntity);
        sysDictMapper.insert(sysDictEntity);
    }

    @Override
    public Page<Map<String, Object>> getPageList(long pageNo, long pageSize) {
        return sysDictMapper.getPageList(new Page<>(pageNo, pageSize));
    }

    @Override
    public void update(Long id, ModifyConfigParam param) {
        SysDictEntity queryEntity = sysDictMapper.selectById(id);
        // 判断数据是否存在
        if (queryEntity == null) {
            throw new CustomException(ErrorCode.E1001);
        }
        queryEntity.setValue(param.getValue());
        queryEntity.setDescription(param.getDescription());
        queryEntity.setRemark(param.getRemark());
        queryEntity.setSort(param.getSort());

        sysDictMapper.updateById(queryEntity);
    }

    @Override
    public void delete(Long id) {
        sysDictMapper.deleteById(id);
    }

    @Override
    public List<SysDictEntity> findByLabel(String label) {
        return sysDictMapper.getByLabel(label);
    }
}
