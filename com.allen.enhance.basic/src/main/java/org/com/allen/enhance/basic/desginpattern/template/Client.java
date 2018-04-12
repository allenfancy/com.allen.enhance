package org.com.allen.enhance.basic.desginpattern.template;

/**
 * 1.封装不变部分，扩展可变部分
 * 2.提供公共的部分代码，便于维护
 * 3.行为由父类控制，子类实现
 */
public class Client {
    public static void main(String[] args) {
        HummerModel hummerModel1 = new HummerModel1();
        hummerModel1.run();
        System.out.println();
        HummerModel hummerModel2 = new HummerModel2();
        hummerModel2.run();
    }
}
