package com.github.w4o.manage.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author frank
 */
@Data
@Builder
public class UserInfoVO {
    private String username;
    private String[] roles;
    private String[] permissions;
    private String avatar;
}
