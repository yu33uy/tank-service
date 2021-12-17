package com.github.w4o.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.w4o.core.base.BaseSysEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * <p>
 * 机构表
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
@Getter
@Setter
@TableName("sys_dept")
public class SysDeptEntity extends BaseSysEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 机构名
     */
    private String deptName;

    /**
     * 上级机构ID， 一级机构为0
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sort;


}
