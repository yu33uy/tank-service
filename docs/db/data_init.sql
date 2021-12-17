-- 密码123456
INSERT INTO `tank_db`.`sys_user` (`id`, `username`, `nick_name`, `avatar`, `password`, `email`, `mobile`, `status`,
                                  `dept_id`, `create_by`, `create_time`, `last_update_by`, `last_update_time`,
                                  `deleted`)
VALUES (1, 'admin', '管理员', 'https://avatars.githubusercontent.com/u/13061300',
        '$2a$10$UqpZOFkzAsGD3Iq.4mTvJunnXEzrVMosPYSGeleKysnjJyzMhcGvm', 'zhwuzhuo@gmail.com', '13812341234', 0, NULL, 1,
        '1900-01-01 00:00:00', NULL, NULL, 0);