package com.github.w4o.manage.service;

import com.github.w4o.manage.dto.param.dept.AddDeptParam;
import com.github.w4o.manage.dto.param.dept.ModifyDeptParam;

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
     * 删除机构
     *
     * @param id 机构id
     */
    void delete(Long id);

    /**
     * 修改机构信息
     *
     * @param id    机构id
     * @param param 请求参数
     */
    void update(Long id, ModifyDeptParam param);

    /**
     * 查询部门树
     *
     * @return 部门树
     */
    List<?> findTree();

}
