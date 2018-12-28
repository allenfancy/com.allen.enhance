package org.com.allen.enhance.basic.desginpattern.decoration.demo2;

/**
 * @author allen.wu
 * @since 2018-09-26 09:45
 */
public class SweetDecorator extends BreadDecorator {

    public SweetDecorator(IBread bread) {
        super(bread);
    }

    public void paint() {
        System.out.println("添加甜蜜素...");
    }

    @Override
    public void kneadFlour() {
        this.paint();
        super.kneadFlour();
    }
}
