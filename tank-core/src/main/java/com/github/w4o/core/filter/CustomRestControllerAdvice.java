package com.github.w4o.core.filter;

import com.github.w4o.core.base.BaseErrorCode;
import com.github.w4o.core.base.CommonResult;
import com.github.w4o.core.config.CoreConfig;
import com.github.w4o.core.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;

/**
 * @author frank
 */
@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomRestControllerAdvice implements ResponseBodyAdvice<Object> {

    private final CoreConfig coreConfig;

    @Value("${spring.profiles.active}")
    private String active;

    private boolean isDebug() {
        return Arrays.asList(new String[]{"dev", "stage"}).contains(active);
    }

    /**
     * 系统出现未捕获的异常时
     */
    @ExceptionHandler(Exception.class)
    public CommonResult<?> exception(Exception e) {
        log.error("an exception occurs", e);
        if (isDebug()) {
            return CommonResult.error(BaseErrorCode.E500, e.getMessage());
        } else {
            return CommonResult.error(BaseErrorCode.E500);
        }
    }

    /**
     * 自定义业务异常时
     */
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<?> businessException(CustomException e) {
        if (isDebug()) {
            return CommonResult.error(e.getError(), e.getMessage());
        } else {
            return CommonResult.error(e.getError());
        }
    }

    @Override

    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (body instanceof CommonResult<?> commonResult) {
            commonResult.setVersion(coreConfig.getVersion());
            return commonResult;
        }
        return body;
    }
}
