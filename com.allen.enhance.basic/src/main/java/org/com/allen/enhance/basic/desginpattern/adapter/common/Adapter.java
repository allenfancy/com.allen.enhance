package org.com.allen.enhance.basic.desginpattern.adapter.common;

/**
 * @author allen.wu
 * @since 2018-09-26 09:56
 * 适配器角色对象
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.doSomething();
    }
}
