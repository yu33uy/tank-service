package com.github.w4o.manage.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Frank
 */
@Configuration
@MapperScan("com.github.w4o.manage.mapper")
public class MybatisPlusConfig {
}
