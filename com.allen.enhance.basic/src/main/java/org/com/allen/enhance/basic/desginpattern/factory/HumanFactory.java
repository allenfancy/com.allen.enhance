package org.com.allen.enhance.basic.desginpattern.factory;

public class HumanFactory extends AbstractHumanFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Human> T createHuman(Class<T> clazz) {
        T t = null;
        try {
            t = (T) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
}
