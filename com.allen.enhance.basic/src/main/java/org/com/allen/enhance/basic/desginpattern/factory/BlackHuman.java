package org.com.allen.enhance.basic.desginpattern.factory;

public class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("black ");
    }

    @Override
    public void talk() {
        System.out.println("black talk");
    }
}
