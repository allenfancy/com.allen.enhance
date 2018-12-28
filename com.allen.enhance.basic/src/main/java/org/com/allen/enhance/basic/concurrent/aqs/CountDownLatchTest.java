package org.com.allen.enhance.basic.concurrent.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @author allen.wu
 * @since 2018-08-07 16:18
 */
public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);


    static class BossThread extends Thread {
        @Override
        public void run() {
            System.out.println("大佬在会议室等待开会，总共有 " + countDownLatch.getCount() + " 个人开会....");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {

            }
            System.out.println("所有人都已经到齐了，开会吧...");
        }
    }

    static class EmpleoyeeThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "，到达会议室....");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        new BossThread().start();
        for (int i = 0; i < 5; i++) {
            new EmpleoyeeThread().start();
        }
    }
}
