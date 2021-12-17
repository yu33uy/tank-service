create table `sys_user`
(
    `id`               bigint(20)   not null comment '主键ID',
    `username`         varchar(50)  not null comment '用户名',
    `nick_name`        varchar(150) default null comment '昵称',
    `avatar`           varchar(150) default null comment '头像',
    `password`         varchar(100) not null comment '密码',
    `email`            varchar(100) default null comment '邮箱',
    `mobile`           varchar(100) default null comment '手机号',
    `status`           tinyint(1)   default null comment '状态 0：禁用 1：正常',
    `dept_id`          bigint(20)   default null comment '机构ID',
    `create_by`        bigint(20)   default null comment '创建人',
    `create_time`      datetime     default null comment '创建时间',
    `last_update_by`   bigint(20)   default null comment '最后更新人',
    `last_update_time` datetime     default null comment '最后更新时间',
    `deleted`          tinyint      default '0' comment '是否删除 0：否 1：是',
    primary key (`id`),
    unique key `username` (`username`)
) engine = InnoDB comment ='系统用户';

create table `sys_role`
(
    `id`               bigint(20)   not null comment '主键ID',
    `role_name`        varchar(100) not null comment '角色名',
    `remark`           varchar(100) default null comment '备注',
    `create_by`        bigint(20)   default null comment '创建人',
    `create_time`      datetime     default null comment '创建时间',
    `last_update_by`   bigint(20)   default null comment '最后更新人',
    `last_update_time` datetime     default null comment '最后更新时间',
    `deleted`          tinyint      default '0' comment '是否删除 0：否 1：是',
    primary key (`id`),
    unique key `role_name` (`role_name`)
) engine = InnoDB comment ='系统角色表';

create table `sys_dept`
(
    `id`               bigint(20)   not null comment '主键ID',
    `dept_name`        varchar(100) not null comment '机构名',
    `parent_id`        bigint(20) default null comment '上级机构ID， 一级机构为0',
    `sort`             int(11)    default null comment '排序',
    `create_by`        bigint(20) default null comment '创建人',
    `create_time`      datetime   default null comment '创建时间',
    `last_update_by`   bigint(20) default null comment '最后更新人',
    `last_update_time` datetime   default null comment '最后更新时间',
    `deleted`          tinyint    default '0' comment '是否删除 0：否 1：是',
    primary key (`id`)
) engine = InnoDB comment ='机构表';

create table `sys_menu`
(
    `id`               bigint(20)  not null comment '主键ID',
    `menu_name`        varchar(50) not null comment '菜单名称',
    `parent_id`        bigint(20)   default '0' comment '父菜单ID，一级菜单为0',
    `url`              varchar(200) default null comment '菜单url，类型：1.普通页面，路由地址 2.外部页面，以http(s)开头 3.嵌套页面，使用iframe',
    `perms`            varchar(500) default null comment '授权，多个用逗号分割',
    `type`             int(1)       default null comment '类型 1：目录 2：菜单 3：按钮',
    `icon`             varchar(50)  default null comment '菜单图标',
    `sort`             int(11)      default null comment '排序',
    `create_by`        bigint(20)   default null comment '创建人',
    `create_time`      datetime     default null comment '创建时间',
    `last_update_by`   bigint(20)   default null comment '最后更新人',
    `last_update_time` datetime     default null comment '最后更新时间',
    `deleted`          tinyint      default '0' comment '是否删除 0：否 1：是',
    primary key (`id`)
) engine = InnoDB comment ='系统菜单表';

create table `sys_user_role`
(
    `id`               bigint(20) not null comment '主键ID',
    `sys_user_id`      bigint(20) not null comment '系统用户ID',
    `sys_role_id`      bigint(20) not null comment '系统角色ID',
    `create_by`        bigint(20) default null comment '创建人',
    `create_time`      datetime   default null comment '创建时间',
    `last_update_by`   bigint(20) default null comment '最后更新人',
    `last_update_time` datetime   default null comment '最后更新时间',
    `deleted`          tinyint    default '0' comment '是否删除 0：否 1：是',
    primary key (`id`)
) engine = InnoDB comment ='用户角色表';

create table `sys_role_menu`
(
    `id`               bigint(20) not null comment '主键ID',
    `sys_role_id`      bigint(20) not null comment '系统角色ID',
    `sys_menu_id`      bigint(20) not null comment '系统菜单ID',
    `create_by`        bigint(20) default null comment '创建人',
    `create_time`      datetime   default null comment '创建时间',
    `last_update_by`   bigint(20) default null comment '最后更新人',
    `last_update_time` datetime   default null comment '最后更新时间',
    `deleted`          tinyint    default '0' comment '是否删除 0：否 1：是',
    primary key (`id`)
) engine = InnoDB comment ='角色菜单表';

create table `sys_role_dept`
(
    `id`               bigint(20) not null comment '主键ID',
    `sys_role_id`      bigint(20) not null comment '系统角色ID',
    `sys_dept_id`      bigint(20) not null comment '系统机构ID',
    `create_by`        bigint(20) default null comment '创建人',
    `create_time`      datetime   default null comment '创建时间',
    `last_update_by`   bigint(20) default null comment '最后更新人',
    `last_update_time` datetime   default null comment '最后更新时间',
    `deleted`          tinyint    default '0' comment '是否删除 0：否 1：是',
    primary key (`id`)
) engine = InnoDB comment ='角色机构表';

create table `sys_dict`
(
    `id`               bigint(20)   not null comment '主键ID',
    `value`            varchar(100) not null comment '数据值',
    `label`            varchar(100) not null comment '标签名',
    `type`             varchar(100) not null comment '类型',
    `description`      varchar(100) not null comment '描述',
    `sort`             int(11)      not null comment '排序',
    `remark`           varchar(255) default null comment '备注',
    `create_by`        bigint(20)   default null comment '创建人',
    `create_time`      datetime     default null comment '创建时间',
    `last_update_by`   bigint(20)   default null comment '最后更新人',
    `last_update_time` datetime     default null comment '最后更新时间',
    `deleted`          tinyint      default '0' comment '是否删除 0：否 1：是',
    primary key (`id`)
) engine = InnoDB comment ='系统字典表';

create table `sys_config`
(
    `id`               bigint(20)   not null comment '主键ID',
    `value`            varchar(100) not null comment '数据值',
    `label`            varchar(100) not null comment '标签名',
    `type`             varchar(100) not null comment '类型',
    `description`      varchar(100) not null comment '描述',
    `sort`             int(11)      not null comment '排序',
    `remark`           varchar(255) default null comment '备注',
    `create_by`        bigint(20)   default null comment '创建人',
    `create_time`      datetime     default null comment '创建时间',
    `last_update_by`   bigint(20)   default null comment '最后更新人',
    `last_update_time` datetime     default null comment '最后更新时间',
    `deleted`          tinyint      default '0' comment '是否删除 0：否 1：是',
    primary key (`id`)
) engine = InnoDB comment ='系统配置表';

create table `sys_log`
(
    `id`               bigint(20) not null comment '主键ID',
    `user_name`        varchar(50)   default null comment '用户名',
    `operation`        varchar(50)   default null comment '用户操作',
    `method`           varchar(200)  default null comment '请求方法',
    `params`           varchar(5000) default null comment '请求参数',
    `time`             bigint(20) not null comment '执行时长(毫秒)',
    `ip`               varchar(64)   default null comment 'IP地址',
    `create_by`        bigint(20)    default null comment '创建人',
    `create_time`      datetime      default null comment '创建时间',
    `last_update_by`   bigint(20)    default null comment '最后更新人',
    `last_update_time` datetime      default null comment '最后更新时间',
    `deleted`          tinyint       default '0' comment '是否删除 0：否 1：是',
    primary key (`id`)
) engine = InnoDB comment ='操作日志表';

create table `sys_login_log`
(
    `id`               bigint(20) not null comment '主键ID',
    `user_name`        varchar(50) default null comment '用户名',
    `status`           varchar(50) default null comment '登录状态（online: 在线，登录初始状态，方便统计在线人数；login：退出登录后将online设置为login；logout：退出登录）',
    `ip`               varchar(64) default null comment 'IP地址',
    `create_by`        bigint(20)  default null comment '创建人',
    `create_time`      datetime    default null comment '创建时间',
    `last_update_by`   bigint(20)  default null comment '最后更新人',
    `last_update_time` datetime    default null comment '最后更新时间',
    `deleted`          tinyint     default '0' comment '是否删除 0：否 1：是',
    primary key (`id`)
) engine = InnoDB comment ='登录日志表';