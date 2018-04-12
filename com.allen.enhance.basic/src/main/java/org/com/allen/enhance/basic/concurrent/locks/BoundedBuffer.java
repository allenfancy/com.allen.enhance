package org.com.allen.enhance.basic.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {

    final Lock lock = new ReentrantLock();
    final Condition full = lock.newCondition();
    final Condition empty = lock.newCondition();
    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                System.out.println("添加 。。 队列满了，我要等着 ... ");
                full.await();
            }
            items[putptr] = x;
            if (++putptr == items.length)
                putptr = 0;
            ++count;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println("拿出来 。。 队列满了，我要等着 ... ");
                empty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length)
                takeptr = 0;
            --count;
            full.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

}
