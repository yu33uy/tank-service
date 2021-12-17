package com.github.w4o.core.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;


/**
 * @author frank
 */
@Data
@ApiModel(value = "响应信息")
public class CommonResult<T> {

    @ApiModelProperty(value = "状态码, 成功返回 200")
    private int code;

    @ApiModelProperty(value = "响应数据")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;

    @ApiModelProperty(value = "响应消息")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String msg;

    @ApiModelProperty(value = "接口版本")
    private String version;

    @ApiModelProperty(value = "时间戳")
    private String timestamp;

    @ApiModelProperty(value = "接口耗时")
    private long spent;

    @ApiModelProperty(value = "调试信息；只用于开发和测试环境，生成环境没有该字段")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String trace;

    protected CommonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    }

    protected CommonResult(int code, String msg, T data, String trac) {
        this.code = code;
        this.msg = msg;
        this.timestamp = DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        this.trace = trac;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(200, "操作成功", data);
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult<T>(200, "操作成功", null);
    }

    public static <T> CommonResult<T> error(CommonError error) {
        return new CommonResult<>(error.getCode(), error.getMessage(), null);
    }

    public static <T> CommonResult<T> error(CommonError error, String trace) {
        return new CommonResult<T>(error.getCode(), error.getMessage(), null, trace);
    }

}
