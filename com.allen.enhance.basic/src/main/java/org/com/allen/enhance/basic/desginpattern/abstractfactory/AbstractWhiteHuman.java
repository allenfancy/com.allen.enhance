package org.com.allen.enhance.basic.desginpattern.abstractfactory;

public abstract class AbstractWhiteHuman implements Human {
    
    @Override
    public void getColor() {
        System.out.println("white...");
    }

    @Override
    public void talk() {
        System.out.println("white talk ..");
    }
}
