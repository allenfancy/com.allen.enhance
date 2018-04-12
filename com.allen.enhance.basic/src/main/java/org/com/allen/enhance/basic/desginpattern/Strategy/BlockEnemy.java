package org.com.allen.enhance.basic.desginpattern.Strategy;

public class BlockEnemy implements  Istrategy {
    @Override
    public void operator() {
        System.out.println("孙夫人断后，挡住追斌");
    }
}
