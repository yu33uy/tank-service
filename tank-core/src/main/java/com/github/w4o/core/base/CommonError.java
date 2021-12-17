package com.github.w4o.core.base;

/**
 * @author frank
 */
public interface CommonError {
    /**
     * 获取错误码
     * @return 错误码
     */
    int getCode();

    /**
     * 获取错误信息
     * @return 错误信息
     */
    String getMessage();
}
