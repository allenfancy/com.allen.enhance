package org.com.allen.enhance.basic.limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author allen.wu
 * @since 2018-06-21 22:47
 */
public class RateLimitDemo {

    /**
     * guava limit使用的是令牌桶算法.可以抵抗一定的突发流量
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(10);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                exec();
            }).start();
        }
    }


    public static void exec() {
        try {
            rateLimiter.acquire(1);
            System.out.println("--" + System.currentTimeMillis() / 1000);
        } catch (Exception e) {

        } finally {

        }
    }
}
