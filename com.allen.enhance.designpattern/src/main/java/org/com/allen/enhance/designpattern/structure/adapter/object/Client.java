package org.com.allen.enhance.designpattern.structure.adapter.object;

/**
 * @author allen.wu
 * @since 2018-11-11 10:52
 */
public class Client {

    public static void main(String[] args) {
        // 原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();
        System.out.println("==========");
        // 增加了适配器角色后的业务逻辑
        Adaptee adaptee = new Adaptee();
        Target target1 = new Adapter(adaptee);
        target1.request();
    }
}
