package com.allen.enhance.zipkin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.zipkin")
public class ZipkinProperties {

    private String serviceName;
    private String url;
    private int connectTimeout;
    private int readTimeout;
    private int flushInterval;

    private boolean compressionEnabled;

    private String endpoint;

}
