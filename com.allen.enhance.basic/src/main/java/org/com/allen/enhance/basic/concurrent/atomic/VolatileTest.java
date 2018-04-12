package org.com.allen.enhance.basic.concurrent.atomic;

public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int HTREAD_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[HTREAD_COUNT];
        for (int i = 0; i < HTREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for(int i1 = 0 ;  i1 < 10000;i1++) {
                    increase();
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
