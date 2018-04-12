package org.com.allen.enhance.basic.desginpattern.template;

public  class HummerModel1  extends  HummerModel{


    @Override
    protected void start() {
        System.out.println("h1 start .. ");
    }

    @Override
    protected void stop() {
        System.out.println("h1 stop .. ");
    }

    @Override
    protected void alarm() {
        System.out.println("h1 alarm .. ");
    }

    @Override
    protected void engineBoom() {
        System.out.println("h1 engineBoom .. ");
    }
}
