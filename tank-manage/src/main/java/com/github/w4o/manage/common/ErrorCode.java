package com.github.w4o.manage.common;

import com.github.w4o.core.base.CommonError;
import lombok.Getter;

/**
 * 错误信息枚举
 *
 * @author frank
 */
public enum ErrorCode implements CommonError {

    /**
     * 系统错误
     */
    E1000(1000, "系统错误"),
    /**
     * 数据不存在，不能操作
     */
    E1001(1001, "数据不存在，不能操作"),
    E1002(1002, "用户不存在或已被禁用"),
    /**
     * 验证码错误
     */
    E1003(1003, "验证码错误"),
    E1004(1004, "存在下级机构，不能删除此机构"),
    E1005(1005, "机构下存在用户，不能删除此机构"),
    E1006(1006, "用户名已存在"),
    E1007(1007, "存在下级菜单，不能删除此菜单"),
    E1008(1008, "标签已存在"),
    E1009(1009, "角色已存在"),
    E1010(1010, "角色下存在用户，不能删除此角色"),
    /**
     * 未知错误
     */
    E9999(9999, "未知错误"),

    //==> 以下错误码与前端代码对应，无需修改！
    /**
     * 请求参数错误
     */
    E400(400, "请求参数错误"),
    /**
     * 用户没有权限
     */
    E401(401, "用户没有权限"),
    /**
     * 令牌过期
     */
    E402(402, "令牌过期"),

    ;

    @Getter
    private final int code;
    @Getter
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
