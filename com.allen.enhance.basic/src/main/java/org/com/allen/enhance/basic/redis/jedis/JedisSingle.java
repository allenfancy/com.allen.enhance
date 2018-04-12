package org.com.allen.enhance.basic.redis.jedis;

import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;

public class JedisSingle {

    private static Jedis jedis;

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        jedis = new Jedis("127.0.0.1", 6379);
        String string = jedis.get("s");
        Integer convertValue = mapper.convertValue(string, Integer.class);
        System.out.println(convertValue);
        System.out.println(Double.valueOf(convertValue));
    }
}
