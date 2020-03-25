package org.com.allen.enhance.basic.concurrent.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author allen
 * @date 2020/3/23 11:23 上午
 **/
public class BoundedBuffer {

    private final ReentrantLock lock = new ReentrantLock();
    // 1. 当数组已满了，没有存储空间时，put方法在notFull条件上等待.直到数组不为满
    private final Condition notFull = lock.newCondition();
    // 2. 当数据已空了，take方法在notEmpty条件上等待,直到数据不为空
    private final Condition notEmpty = lock.newCondition();
    private final Object[] items = new Object[100];
    private int putptr, takeptr, count;

    public void put(Object obj) throws InterruptedException {
        lock.lock();
        try {
            if (count == items.length) {
                notFull.await();
            }
            items[putptr] = obj;
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            if (count == 0) {
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
