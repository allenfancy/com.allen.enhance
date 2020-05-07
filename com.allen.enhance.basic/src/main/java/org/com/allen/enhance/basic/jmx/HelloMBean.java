package org.com.allen.enhance.basic.jmx;

/**
 * @author allen
 * @date 2020/4/20 12:00 下午
 **/
public interface HelloMBean {

    public void sayHello();

    public int add(int x, int y);

    public String getName();

    public int getCacheSize();

    public void setCacheSize(int size);
}
