package org.com.allen.enhance.basic.desginpattern.abstractfactory;

public abstract class AbstractBlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("black...");
    }

    @Override
    public void talk() {
        System.out.println("black talk ..");
    }
}
