package org.com.allen.enhance.designpattern;

/**
 * @author allen.wu
 * @since 2018-11-10 12:11
 *
 * 设计模式分类
 * 范围               创建类型                 结构类型                   行为类型
 * 类            FactoryMethod(工厂方法)     Adapter(类)适配器          Interpreter(解释器)
 *                                                                  TemplateMethod(模板方法)
 *
 * 对象           AbstractFactory(抽象工厂)   Adapter(对象)适配器        Chain (责任链模式)
 *               Builder   建造者            Bridge(桥接)             Command(命令模式)
 *               Prototype 原型             Composite(组合)          Iterator(迭代器模式)
 *               Singleton 单例             Decorator(装饰者)         Mediator(中介模式)
 *                                         Facade(外观)             Memento(备忘录模式)
 *                                         FlyWeight(享元模式)       Observer(观察者模式)
 *                                         Proxy(代理模式)           State(状态模式)
 *                                                                 Strategy(策略)
 *                                                                 Visitor(访问者)
 */
public class App {

    public static void main(String[] args) {
        System.out.println("hello design pattern");
    }
}
