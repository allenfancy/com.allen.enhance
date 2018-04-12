package org.com.allen.enhance.basic.concurrent.threadlocal;

public class Demo1 {

    private static ThreadGroup tg = new ThreadGroup("allen_thread_test_group");

    public static void main(String[] args) {
        // testThreadLocal();
        testThread();
        System.out.println(tg.activeCount());
    }


    public static void testThreadLocal() {
        Thread t = new Thread() {
            ThreadLocal<String> ms = new ThreadLocal<String>();

            @Override
            public void run() {
                ms.set("allen fancy");
                System.out.println(ms.get());
            }
        };
        t.start();
    }

    public static void testThread() {
        Thread t = new Thread(tg, "thread_1");
        t.start();
        System.out.println(Thread.currentThread().getName());
    }
}
