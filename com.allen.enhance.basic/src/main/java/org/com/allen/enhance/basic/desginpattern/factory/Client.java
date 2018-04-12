package org.com.allen.enhance.basic.desginpattern.factory;

/**
 * @Note : 定义一个用于创建对象的接口，让子类去决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类
 */
public class Client {
    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();
        YellowHuman human = humanFactory.createHuman(YellowHuman.class);
        human.getColor();
        human.talk();
        BlackHuman human1 = humanFactory.createHuman(BlackHuman.class);
        human1.getColor();
        human1.talk();
        WhiteHuman human2 = humanFactory.createHuman(WhiteHuman.class);
        human2.getColor();
        human2.talk();
    }
}
