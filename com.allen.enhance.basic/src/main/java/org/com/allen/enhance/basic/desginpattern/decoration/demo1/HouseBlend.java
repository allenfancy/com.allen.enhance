package org.com.allen.enhance.basic.desginpattern.decoration.demo1;

/**
 * @author allen.wu
 * @since 2018-09-26 09:24
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.description = "house land coffie";
    }

    @Override
    public double cost() {
        return 2.4;
    }
}
