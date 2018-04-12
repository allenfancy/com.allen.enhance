package org.com.allen.enhance.basic.desginpattern.Strategy;

public class GreenLight implements Istrategy {
    @Override
    public void operator() {
        System.out.println("开绿灯");
    }
}
