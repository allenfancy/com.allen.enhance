package org.com.allen.enhance.basic.concurrent.locks;

import java.util.concurrent.ThreadLocalRandom;

public class TestLockAndCondition {

    public static void main(String[] args) {
        final BoundedBuffer bb = new BoundedBuffer();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 10000; j++) {
                            bb.put(ThreadLocalRandom.current().nextInt(1000));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println(bb.take());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
