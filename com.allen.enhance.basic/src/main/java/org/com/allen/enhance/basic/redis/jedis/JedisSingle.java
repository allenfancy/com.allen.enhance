package org.com.allen.enhance.basic.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisSingle {


    public static void main(String[] args) {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(5);
            config.setMaxTotal(10);
            config.setMinIdle(5);
            config.setBlockWhenExhausted(true);
            config.setTestOnBorrow(true);
            config.setTestWhileIdle(true);
            config.setTestOnCreate(true);
            config.setMinEvictableIdleTimeMillis(1000);
            config.setMaxWaitMillis(2000);
            JedisPool pool = new JedisPool(config, "127.0.0.1", 6379);
            for (int j = 0; j < 1000; j++) {
                Jedis jedis = pool.getResource();
                String str = jedis.set("test" + j, "" + j);
                System.out.println(str);
                jedis.close();
            }
        } catch (
            Exception e) {
            e.printStackTrace();
        }
    }
}
