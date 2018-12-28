package org.com.allen.enhance.designpattern.structure.adapter.object;

/**
 * @author allen.wu
 * @since 2018-11-11 10:33
 * 适配器角色登场
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.doSomeThing();
    }
}
