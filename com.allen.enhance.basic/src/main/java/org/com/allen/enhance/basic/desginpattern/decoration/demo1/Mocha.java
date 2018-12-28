package org.com.allen.enhance.basic.desginpattern.decoration.demo1;

/**
 * @author allen.wu
 * @since 2018-09-26 09:27
 */
public class Mocha extends CondimentDecorator {

    protected Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "，with mocha";
    }

    @Override
    public double cost() {
        return 3.0 + beverage.cost();
    }
}
