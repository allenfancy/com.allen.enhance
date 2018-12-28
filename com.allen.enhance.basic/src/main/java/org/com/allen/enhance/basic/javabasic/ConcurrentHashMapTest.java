package org.com.allen.enhance.basic.javabasic;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author allen.wu
 * @since 2018-09-14 22:50
 */
public class ConcurrentHashMapTest {


    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>();
        chm.put("string",1);
    }
}
