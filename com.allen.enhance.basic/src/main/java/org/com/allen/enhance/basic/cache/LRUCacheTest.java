package org.com.allen.enhance.basic.cache;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void testRemove() {
        LRUCache<String, String> cache = new LRUCache<>(new GenericCache<>("generic"));
        cache.setSize(5);
        for(int i = 0 ;i < 5;i++) {
            cache.putObject(String.valueOf(i), String.valueOf(i));
        }
        System.out.println(cache.getObject(String.valueOf(0)));
        cache.putObject(String.valueOf(5), String.valueOf(5));
        System.out.println(cache.getObject(String.valueOf(1)));
        System.out.println(cache.getObject(String.valueOf(2)));
        System.out.println(cache.getObject(String.valueOf(3)));
        System.out.println(cache.getObject(String.valueOf(4)));
        System.out.println(cache.getSize());
    }
}
