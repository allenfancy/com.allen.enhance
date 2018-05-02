package org.com.allen.enhance.basic.redis.lettuce;

import com.lambdaworks.redis.SocketOptions;
import com.lambdaworks.redis.ClientOptions.DisconnectedBehavior;
import com.lambdaworks.redis.cluster.ClusterClientOptions;
import com.lambdaworks.redis.cluster.RedisClusterClient;
import com.lambdaworks.redis.cluster.api.StatefulRedisClusterConnection;
import com.lambdaworks.redis.cluster.api.sync.RedisAdvancedClusterCommands;
import com.lambdaworks.redis.support.RedisClusterClientFactoryBean;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportRedis {

    @Autowired
    private RedisClusterClientFactoryBean redisClient;
    
    private RedisClusterClient redisClusterClient;
    
    private StatefulRedisClusterConnection<String, String> connection;
    
    private RedisAdvancedClusterCommands<String, String> syncCommands;

    
    @PostConstruct
    public void init() {
        try {
            System.out.println("开始初始化... ");
            redisClusterClient=  redisClient.getObject(); 
            redisClusterClient.setOptions(ClusterClientOptions.builder().autoReconnect(true)
                    .cancelCommandsOnReconnectFailure(true)
                    .disconnectedBehavior(DisconnectedBehavior.REJECT_COMMANDS)
                    .socketOptions(SocketOptions.builder().connectTimeout(100, TimeUnit.MILLISECONDS).keepAlive(true).tcpNoDelay(true).build())
                    .build());
            connection =  redisClusterClient.connect();
            syncCommands= connection.sync();
            System.out.println("初始化结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destory() {
        System.out.println("开始销毁...");
        syncCommands.close();
        connection.close();
        redisClusterClient.shutdown();
        System.out.println("销毁结束...");
    }
    
    public RedisAdvancedClusterCommands<String, String> getSyncCommands() {
        return this.syncCommands;
    }
}
