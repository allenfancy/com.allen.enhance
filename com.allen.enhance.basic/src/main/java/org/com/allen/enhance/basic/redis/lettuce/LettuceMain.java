package org.com.allen.enhance.basic.redis.lettuce;


import java.util.Arrays;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.api.sync.RedisCommands;
import com.lambdaworks.redis.cluster.RedisClusterClient;
import com.lambdaworks.redis.cluster.api.StatefulRedisClusterConnection;
import com.lambdaworks.redis.cluster.api.sync.RedisAdvancedClusterCommands;

public class LettuceMain {

    public static void main(String[] args) {
        //singleRedis();
        clusterRedis();
    }

    public static void singleRedis() {
        RedisClient redisClient = RedisClient.create("redis://localhost:6379");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.set("key", "Hello, Redis!");
        System.out.println(syncCommands.get("key"));
        connection.close();
        redisClient.shutdown();
    }

    public static void clusterRedis() {
        RedisURI node1 = RedisURI.create("127.0.0.1", 7001);
        RedisURI node2 = RedisURI.create("127.0.0.1", 7002);
        RedisURI node3 = RedisURI.create("127.0.0.1", 7003);
        RedisClusterClient clusterClient =
                RedisClusterClient.create(Arrays.asList(node1, node2, node3));
        StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
        RedisAdvancedClusterCommands<String, String> syncCommands = connection.sync();
        for (int i = 0; i < 10000; i++) {
            syncCommands.set("k_" + i, "kv_" + i);
        }

        for (int i = 0; i < 10000; i++) {
            System.out.println(syncCommands.get("k_" + i));
        }

        connection.close();
        clusterClient.shutdown();
    }
}
