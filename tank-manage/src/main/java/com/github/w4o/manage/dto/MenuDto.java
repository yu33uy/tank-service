package com.github.w4o.manage.dto;

import lombok.Data;

@Data
public class MenuDto {
    private Long id;
    private String menuName;
    private Long parentId;
    private String route;
    private String perms;
    private String icon;
    private Integer sort;
}
