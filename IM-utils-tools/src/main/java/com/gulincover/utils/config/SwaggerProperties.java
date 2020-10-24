package com.gulincover.utils.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "swagger")
@Component
public class SwaggerProperties {
    private String title = "internet memory";
    private String description = "internet memory api document";
    private String version = "1.0.0";
    private String termsOfServiceUrl = "https://github.com/GulinCover/Internet-Memery";
    private String basePackage = "com.gulincover.*";
    private String groupName = "default";
}
