package org.com.allen.enhance.basic.javabasic;

import java.util.concurrent.TimeUnit;

/**
 * @author allen.wu
 * @since 2018-10-10 17:40
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t exit");
        });
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 exit");
        });
        t1.start();
        t.start();
        t1.join(3500);
        t.join(2500);

        System.out.println("main exit");
    }
}
