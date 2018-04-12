package org.com.allen.enhance.basic.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonCluster {
    public static final Config config = new Config();
    public static RedissonClient client = null;
    public static RBucket<String> testRed = null;

    static {
        config.useClusterServers()
                .setScanInterval(1000)
                /*.setConnectTimeout(1000)
             .setClientName("cluster-demo")
             .setKeepAlive(true)
             .setPingTimeout(500)
             .setRetryInterval(2)
             .setTimeout(200)
           .setTcpNoDelay(true)*/
                .addNodeAddress("redis://127.0.0.1:7001")
                .addNodeAddress("redis://127.0.0.1:7002")
                .addNodeAddress("redis://127.0.0.1:7003");
        client = Redisson.create(config);
        testRed = client.getBucket("testRed");
    }


    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        set();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

    public static void set() {
        for (int i = 0; i < 1000000; i++) {
            String andSet = testRed.getAndSet(String.valueOf(i));
            System.out.println(Thread.currentThread().getName() + " => : "+ andSet);
        }
    }
}
