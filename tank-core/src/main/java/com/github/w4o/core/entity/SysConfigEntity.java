package com.github.w4o.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.w4o.core.base.BaseSysEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * <p>
 * 系统配置表
 * </p>
 *
 * @author Frank
 * @since 2021-12-17
 */
@Getter
@Setter
@TableName("sys_config")
public class SysConfigEntity extends BaseSysEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 数据值
     */
    private String value;

    /**
     * 标签名
     */
    private String label;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;


}
