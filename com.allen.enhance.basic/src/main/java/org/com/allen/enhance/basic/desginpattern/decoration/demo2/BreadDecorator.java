package org.com.allen.enhance.basic.desginpattern.decoration.demo2;

/**
 * @author allen.wu
 * @since 2018-09-26 09:42
 */
public abstract class BreadDecorator implements IBread {

    protected IBread bread;

    public BreadDecorator(IBread bread) {
        this.bread = bread;
    }

    @Override
    public void prepare() {
        this.bread.prepare();
    }

    @Override
    public void kneadFlour() {
        this.bread.kneadFlour();
    }

    @Override
    public void streamed() {
        this.bread.streamed();
    }

    @Override
    public void proccess() {
       prepare();
       kneadFlour();
       streamed();
    }
}
