package org.com.allen.enhance.basic.desginpattern.observer;

/**
 * @author allen.wu
 * @since 2018-09-13 18:07
 */
public class Client {

    public static void main(String[] args) {
        Observer lisi = new Lisi();
        Observer wangsi = new Wangsi();
        Observer zhaosi = new Zhaosi();
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(lisi);
        hanFeiZi.addObserver(wangsi);
        hanFeiZi.addObserver(zhaosi);
        hanFeiZi.goToCourt();
        System.out.println("==================");
        hanFeiZi.outToCourt();
    }
}
