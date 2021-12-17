package com.github.w4o.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author frank
 */
@Component
@ConfigurationProperties(prefix = "tank.core")
@Data
@Validated
public class CoreConfig {
    @NotBlank
    private String version;
}
