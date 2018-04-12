package org.com.allen.enhance.basic.desginpattern.abstractfactory;

/**
 * 为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类
 */
public class Client {
    public static void main(String[] args) {
        HumanFactory femaleHumanFactory = new FemaleFactory();
        HumanFactory manHumanFactory = new ManFactory();

        Human blackHuman = femaleHumanFactory.createBlackHuman();
        blackHuman.getColor();
        blackHuman.getSex();
        blackHuman.talk();
        Human whiteHuman = femaleHumanFactory.createWhiteHuman();
        whiteHuman.getColor();
        whiteHuman.getSex();
        whiteHuman.talk();

        Human yellowHuman = femaleHumanFactory.createYellowHuman();
        yellowHuman.getColor();
        yellowHuman.getSex();
        yellowHuman.talk();

        Human blackHuman1 = manHumanFactory.createBlackHuman();
        blackHuman1.getColor();
        blackHuman1.getSex();
        blackHuman1.talk();

        Human whiteHuman1 = manHumanFactory.createWhiteHuman();
        whiteHuman1.getColor();
        whiteHuman1.getSex();
        whiteHuman1.talk();

        Human yellowHuman1 = manHumanFactory.createYellowHuman();
        yellowHuman1.getColor();
        yellowHuman1.getSex();
        yellowHuman1.talk();
    }
}
