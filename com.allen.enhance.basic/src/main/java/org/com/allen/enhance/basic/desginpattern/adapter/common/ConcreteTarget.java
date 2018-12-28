package org.com.allen.enhance.basic.desginpattern.adapter.common;

/**
 * @author allen.wu
 * @since 2018-09-26 09:55
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("具体的实现");
    }
}
