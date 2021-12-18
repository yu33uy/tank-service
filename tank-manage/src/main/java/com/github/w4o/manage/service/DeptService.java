package com.github.w4o.manage.service;

import com.github.w4o.manage.dto.param.AddDeptParam;

import java.util.List;

/**
 * @author frank
 * @date 2021/12/17
 */
public interface DeptService {

    /**
     * 添加机构
     *
     * @param param 请求参数
     */
    void add(AddDeptParam param);

    /**
     * 查询部门树
     *
     * @return 部门树
     */
    List<?> findTree();

}
