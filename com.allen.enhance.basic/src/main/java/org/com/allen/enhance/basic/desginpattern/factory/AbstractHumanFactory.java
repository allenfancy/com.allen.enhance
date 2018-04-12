package org.com.allen.enhance.basic.desginpattern.factory;

public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> clazz);
}
