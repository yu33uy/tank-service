package com.github.w4o.core.config;

import com.github.w4o.core.filter.HttpTraceLogFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author frank
 */
@Configuration
@ConditionalOnWebApplication
public class HttpTraceConfig {
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    static class ServletTraceFilterConfiguration {
        @Bean
        public HttpTraceLogFilter httpTraceLogFilter() {
            return new HttpTraceLogFilter();
        }
    }
}
