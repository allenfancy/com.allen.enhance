package org.com.allen.enhance.basic.concurrent.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author allen.wu
 * @since 2018-07-30 23:40
 */
public class CyclicBarrierDemo {

    private static CyclicBarrier cyclicBarrier;

    static class CyclicBarrierThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 到了");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(10, () -> System.out.println("人到齐了，开会吧...."));
        for(int i = 0 ; i < 10 ; i++){
            new CyclicBarrierThread().start();
        }
    }
}
