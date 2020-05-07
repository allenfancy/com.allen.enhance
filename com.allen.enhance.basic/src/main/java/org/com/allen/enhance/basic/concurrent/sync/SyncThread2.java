package org.com.allen.enhance.basic.concurrent.sync;

/**
 * @author allen
 * @date 2020/3/18 12:01 上午
 * synchronized 修饰的静态方法，那么锁为:Class级别
 **/
public class SyncThread2 implements Runnable {

    // 临界资源.
    private static int count;

    public SyncThread2() {
        count = 0;
    }

    @Override
    public void run() {
        staticMethod();
    }

    // 实质上使用的类锁.
    private static synchronized void staticMethod() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testSameLock() {
        SyncThread2 syncThread = new SyncThread2();
        //线程1和线程2使用了SyncThread类的同一个对象实例
        //因此, 这两个线程中的synchronized(this), 持有的是同一把锁。因此只有等SyncThread1执行完事儿后，SyncThread2才能继续执行.
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }

    public static void testDiffLock() {
        Thread thread1 = new Thread(new SyncThread2(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread2(), "SyncThread2");
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        testSameLock();
        Thread.currentThread().join(1500);
        System.out.println(Thread.currentThread().getName() + "===============");
        testDiffLock();
    }
}
