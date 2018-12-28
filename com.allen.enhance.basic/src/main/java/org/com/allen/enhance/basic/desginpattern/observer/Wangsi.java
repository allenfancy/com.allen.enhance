package org.com.allen.enhance.basic.desginpattern.observer;

/**
 * @author allen.wu
 * @since 2018-09-13 18:05
 */
public class Wangsi implements Observer {

    @Override
    public void update(String context) {
        System.out.println("WangSi : " + context);
    }
}
