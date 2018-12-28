package org.com.allen.enhance.basic.limit;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author allen.wu
 * @since 2018-06-21 22:55
 *
 * 优点：
 *  如果是瞬时的高并发，可以使请求在阻塞队列中排队，而不是马上拒绝请求，从而达到一个流量削峰的目的。
 */
public class CountUserSemphoreLimiter {

    private static Semaphore semphore = new Semaphore(50);

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                exec();
            }).start();
        }
    }

    public static void exec() {
        if (semphore.getQueueLength() > 100) {
            System.out.println("当前等待排队的任务数大于100，请稍候再试...");
        }
        try {
            semphore.acquire();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("--" + System.currentTimeMillis() / 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semphore.release();
        }
    }
}
