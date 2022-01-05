package com.github.w4o.manage.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author frank
 */
@Component
@ConfigurationProperties(prefix = "tank")
@Data
@Validated
public class TankConfig {
    @NotNull
    private String version;

    @NotNull
    private Jwt jwt;

    @Data
    public static class Jwt {
        @NotBlank
        private String secret;
        @NotNull
        private Integer expire;
    }
}
