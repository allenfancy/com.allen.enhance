package org.com.allen.enhance.basic.concurrent.locks;

import java.util.concurrent.locks.Lock;

import org.junit.Test;

import rx.Scheduler.Worker;

public class TwinsLockTest {

    @Test
    public void test() {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread());
                        Thread.sleep(1000L);

                    } catch (Exception e) {
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i <= 10; i++) {
            Worker worker = new Worker();
            worker.start();
        }
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(200L);
                    System.out.println("========");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
