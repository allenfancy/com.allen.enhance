package org.com.allen.enhance.basic.desginpattern.decoration.demo1;

/**
 * @author allen.wu
 * @since 2018-09-26 09:23
 */
public abstract class Beverage {

    protected String description = "";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
