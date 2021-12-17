package com.github.w4o.manage.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author frank
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Value("${tank.core.version}")
    private String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                //.securitySchemes(new ArrayList<SecurityScheme>() {{
                //    add(new ApiKey(Constant.JWT_HEADER_NAME, "JWT", "header"));
                //}})
                .groupName("v1")
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.w4o.tank.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Tank接口文档")
                .description("")
                .version(version)
                .build();
    }
}