package org.com.allen.enhance.basic.concurrent.sync;

/**
 * @author allen
 * @date 2020/3/18 12:01 上午
 **/
public class SyncThread implements Runnable {

    private static int count;

    public SyncThread() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void testSameLock() {
        SyncThread syncThread = new SyncThread();
        //线程1和线程2使用了SyncThread类的同一个对象实例
        //因此, 这两个线程中的synchronized(this), 持有的是同一把锁。因此只有等SyncThread1执行完事儿后，SyncThread2才能继续执行.
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }

    public static void testDiffLock() {
        // 使用的是不同的对象，所以同一时刻，thread1和thread2可以并行执行
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
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
