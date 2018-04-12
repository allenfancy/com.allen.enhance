package org.com.allen.enhance.basic.redis.lettuce;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.support.RedisClusterClientFactoryBean;

@Component
public class LettuceConfig {


    @Bean
    public  RedisClusterClientFactoryBean redisClient() {
        RedisClusterClientFactoryBean redisClusterClientFactoryBean = new RedisClusterClientFactoryBean();
        redisClusterClientFactoryBean.setRedisURI(RedisURI.create("redis://127.0.0.1:7001"));
        return redisClusterClientFactoryBean;
    }
}
