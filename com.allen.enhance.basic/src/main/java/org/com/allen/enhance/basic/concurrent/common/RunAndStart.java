package org.com.allen.enhance.basic.concurrent.common;

/**
 * @author allen.wu
 * @since 2018-07-18 22:41
 */
public class RunAndStart {

    public static void main(String[] args) {
        MyThread m = new MyThread("allen");
        m.run();
        m.start();
    }

    static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
