package org.com.allen.enhance.designpattern.structure.adapter.clazz;

/**
 * @author allen.wu
 * @since 2018-11-11 10:52
 */
public class Client {

    public static void main(String[] args) {
        // 原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();
        // 增加了适配器角色后的业务逻辑
        Target target1 = new Adapter();
        target1.request();
    }
}
