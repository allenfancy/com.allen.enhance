package org.com.allen.enhance.basic.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

public class LRUCache<K, V> implements Cache<K, V> {

    private final Cache<K, V> delegate;
    private Map<K, V> keyMap;
    private K eldestKey;

    public LRUCache(Cache<K, V> delegate) {
        this.delegate = delegate;
        setSize(1024);
    }


    @Override
    public void putObject(K k, V v) {
        this.delegate.putObject(k, v);
        cycleKeyList(k, v);
    }

    @Override
    public V getObject(K k) {
        keyMap.get(k);
        return delegate.getObject(k);
    }

    @Override
    public V removeObject(K k) {
        return this.delegate.removeObject(k);
    }

    @Override
    public void clear() {
        this.delegate.clear();
    }

    @Override
    public int getSize() {
        return this.delegate.getSize();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }


    public void setSize(final int size) {
        // 设置有序访问
        keyMap = new LinkedHashMap<K, V>(size, .75f, true) {
            /**
             * 
             */
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
                boolean tooBig = size() > size;
                if (tooBig) {
                    eldestKey = eldest.getKey();
                }
                return tooBig;
            }
        };
    }

    private void cycleKeyList(K k, V v) {
        keyMap.put(k, v);
        if (eldestKey != null) {
            this.delegate.removeObject(eldestKey);
        }
        eldestKey = null;
    }


    @Override
    public String getID() {
        return this.delegate.getID();
    }
}
