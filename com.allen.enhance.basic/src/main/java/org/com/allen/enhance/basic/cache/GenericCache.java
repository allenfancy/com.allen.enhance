package org.com.allen.enhance.basic.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;

public class GenericCache<K, V> implements Cache<K, V> {

    private final String ID;
    
    private Map<K, V> CACHE = new ConcurrentHashMap<K, V>();

    public GenericCache(String ID) {
        this.ID = ID;
    }

    @Override
    public void putObject(K k, V v) {
        this.CACHE.put(k, v);
    }

    @Override
    public V getObject(K k) {
        return this.CACHE.get(k);
    }

    @Override
    public V removeObject(K k) {
        return this.CACHE.remove(k);
    }

    @Override
    public void clear() {
        this.CACHE.clear();
    }

    @Override
    public int getSize() {
        return this.CACHE.size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public boolean equals(Object o) {
        if (getID() == null) {
            throw new RuntimeException("Cache instances require an ID.");
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cache)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Cache<K, V> otherCache = (Cache<K, V>) o;
        return getID().equals(otherCache.getID());
    }

    @Override
    public int hashCode() {
        if (getID() == null) {
            throw new RuntimeException("Cache instances require an ID.");
        }
        return getID().hashCode();
    }

}
