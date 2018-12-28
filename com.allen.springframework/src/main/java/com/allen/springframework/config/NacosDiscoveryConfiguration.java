package com.allen.springframework.config;

import org.springframework.context.annotation.Configuration;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;

/**
 * @author allen.wu
 * @since 2018-12-07 23:36
 */
@Configuration
@EnableNacosDiscovery(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
public class NacosDiscoveryConfiguration {
}
