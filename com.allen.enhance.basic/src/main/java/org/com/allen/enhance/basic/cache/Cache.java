package org.com.allen.enhance.basic.cache;

import java.util.concurrent.locks.ReadWriteLock;

public interface Cache<K, V> {
    
    String getID();

    void putObject(K k, V v);

    V getObject(K k);

    V removeObject(K k);

    void clear();

    int getSize();

    ReadWriteLock getReadWriteLock();

}
