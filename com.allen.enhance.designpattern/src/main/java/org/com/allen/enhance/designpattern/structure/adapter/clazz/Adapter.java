package org.com.allen.enhance.designpattern.structure.adapter.clazz;

/**
 * @author allen.wu
 * @since 2018-11-11 10:33
 * 适配器角色登场
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.doSomeThing();
    }
}
