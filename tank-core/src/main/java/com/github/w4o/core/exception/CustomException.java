package com.github.w4o.core.exception;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.github.w4o.core.base.CommonError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author frank
 * @date 2021/9/28
 */
@ResponseStatus(HttpStatus.OK)
public class CustomException extends RuntimeException {
    @Getter
    private final CommonError error;

    public CustomException(CommonError error) {
        this.error = error;
    }

    public CustomException(CommonError resultCode, String message) {
        super(message);
        this.error = resultCode;
    }

    public CustomException(CommonError resultCode, Throwable e) {
        super(e);
        this.error = resultCode;
    }
}
