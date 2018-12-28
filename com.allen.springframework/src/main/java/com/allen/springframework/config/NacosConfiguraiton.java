package com.allen.springframework.config;

import org.springframework.context.annotation.Configuration;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

/**
 * @author allen.wu
 * @since 2018-12-06 17:32
 */
@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
@NacosPropertySource(dataId = "allen.test", groupId = "allen.test.", autoRefreshed = true)
public class NacosConfiguraiton {
}
