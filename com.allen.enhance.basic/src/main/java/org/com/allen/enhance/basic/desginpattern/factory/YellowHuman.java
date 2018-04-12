package org.com.allen.enhance.basic.desginpattern.factory;

public class YellowHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("yellow ");
    }

    @Override
    public void talk() {
        System.out.println("yellow talk");
    }
}
