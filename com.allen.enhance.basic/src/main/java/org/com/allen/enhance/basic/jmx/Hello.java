package org.com.allen.enhance.basic.jmx;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author allen
 * @date 2020/4/20 12:01 下午
 **/
public class Hello implements HelloMBean {

    private final String name = "Hello-Allen";
    private int cacheSize = DEFAULT_CACHE_SIZE;
    private final static int DEFAULT_CACHE_SIZE = 200;

    @Override
    public void sayHello() {
        System.out.println("hello allen wu.");
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCacheSize() {
        return this.cacheSize;
    }

    @Override
    public void setCacheSize(int size) {
        this.cacheSize = size;
    }
}
