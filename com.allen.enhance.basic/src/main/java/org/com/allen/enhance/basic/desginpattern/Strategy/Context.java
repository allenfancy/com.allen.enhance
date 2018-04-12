package org.com.allen.enhance.basic.desginpattern.Strategy;

public class Context {

    private Istrategy strategy;


    public Context(Istrategy strategy) {
        this.strategy = strategy;
    }

    public void operator() {
        this.strategy.operator();
    }
}
