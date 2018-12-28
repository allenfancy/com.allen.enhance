package org.com.allen.enhance.basic.desginpattern.adapter.common;

/**
 * @author allen.wu
 * @since 2018-09-26 09:56
 */
public class Client {

    public static void main(String[] args) {
        // 原有的业务
        Target target = new ConcreteTarget();
        target.request();
        System.out.println("新增业务线");
        // 新增的业务
        Target target1 = new Adapter();
        target1.request();

    }
}
