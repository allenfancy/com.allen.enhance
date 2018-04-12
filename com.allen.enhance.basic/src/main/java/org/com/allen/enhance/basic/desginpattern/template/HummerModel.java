package org.com.allen.enhance.basic.desginpattern.template;

public abstract class HummerModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    protected final void run() {
        this.start();
        this.stop();
        this.alarm();
        this.engineBoom();
    }
}
