package org.com.allen.enhance.basic.desginpattern.decoration.demo1;

/**
 * @author allen.wu
 * @since 2018-09-26 09:25
 */
public class Milk extends CondimentDecorator {

    protected Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 2.4 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "，with milk ";
    }
}
