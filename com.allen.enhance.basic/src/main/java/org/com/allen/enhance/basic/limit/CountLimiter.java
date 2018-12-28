package org.com.allen.enhance.basic.limit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author allen.wu
 * @since 2018-06-21 22:52
 */
public class CountLimiter {


    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                exec();
            }).start();
        }
    }

    public static void exec() {

        if (count.get() > 10) {
            System.out.println("拒绝访问.");
        } else {
            count.incrementAndGet();
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("--" + System.currentTimeMillis() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                count.decrementAndGet();
            }
        }
    }
}
