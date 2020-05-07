package org.com.allen.enhance.basic.concurrent.aqs;

import java.util.concurrent.Semaphore;

/**
 * @author allen
 * @date 2020/3/29 11:02 上午
 **/
public class Pool {

    private static final int MAX_AVAILABLE = 100;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
        available.acquire();
        return getNextAvailableItem();
    }

    public void putItem(Object x) {
        if (markAsUnused(x)) {
            available.release();
        }
    }

    private Object[] items = new Object[]{};

    private boolean[] used = new boolean[MAX_AVAILABLE];

    private boolean markAsUnused(Object x) {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (x == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null;
    }
}
