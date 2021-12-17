package com.github.w4o.core.base;

import lombok.Getter;

/**
 * @author frank
 * @date 2021/12/17
 */
public enum BaseErrorCode  implements CommonError {
    /**
     * 服务器发生错误
     */
    E500(500, "服务器发生错误"),
    ;

    @Getter
    private final int code;
    @Getter
    private final String message;

    BaseErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
