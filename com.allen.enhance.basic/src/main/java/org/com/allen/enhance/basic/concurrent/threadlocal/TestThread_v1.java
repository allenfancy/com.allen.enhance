package org.com.allen.enhance.basic.concurrent.threadlocal;
/**
 * sleep(): 哪个线程需要挂起就在哪个线程中直接调用
 * join(): 用线程对象调用，如果在一个线程A中调用另一个线程B的join方法，线程A将会等待线程B执行完毕后再执行。
 *
 */
public class TestThread_v1 extends Thread {

    public static void main(String[] args) {
        Thread t = new TestThread_v1();
        t.start();
        try {
            t.join(1000);// main线程只等待1000ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }

    @Override
    public void run() {
        System.out.println("subThread begin");
        try {
            System.out.println("subThread sleep begin");
            Thread.sleep(2000);// 休眠900毫秒
            System.out.println("subThread sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("subThread end");
    }
}
