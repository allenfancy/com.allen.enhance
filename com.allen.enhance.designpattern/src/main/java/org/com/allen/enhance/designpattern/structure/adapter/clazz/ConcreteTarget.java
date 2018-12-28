package org.com.allen.enhance.designpattern.structure.adapter.clazz;

/**
 * @author allen.wu
 * @since 2018-11-11 10:31
 */
public class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("request.");
    }
}
