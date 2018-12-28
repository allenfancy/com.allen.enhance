package org.com.allen.enhance.basic.desginpattern.decoration.demo1;

/**
 * @author allen.wu
 * @since 2018-09-26 09:28
 */
public class Client {

    public static void main(String[] args) {
        Beverage beverage = new Mocha(new Milk(new Mocha(new HouseBlend())));
        System.out.println(beverage.getDescription() + " : cost: " + beverage.cost() );
    }
}
