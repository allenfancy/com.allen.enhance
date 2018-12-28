package org.com.allen.enhance.basic.desginpattern.decoration.demo2;

/**
 * @author allen.wu
 * @since 2018-09-26 09:46
 */
public class Client {

    public static void main(String[] args) {
        IBread bread = new NormalBread();
        bread.proccess();
        System.out.println("=======我想吃玉米馒头==========");
        bread = new CronDecorator(bread);
        bread.proccess();
        System.out.println("========我想吃甜甜的馒头================");
        bread = new SweetDecorator(bread);
        bread.proccess();
    }
}
