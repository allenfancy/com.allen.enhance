package org.com.allen.enhance.basic.desginpattern.observer.simple;

/**
 * @author allen.wu
 * @since 2018-09-13 17:50
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {

        LiSi liSi = new LiSi();
        HanFeiZi hanFeiZi = new HanFeiZi();

        Spy watchBreakFast = new Spy(hanFeiZi,liSi,"breakfast");
        watchBreakFast.run();
        Spy watchFunc = new Spy(hanFeiZi,liSi,"fun");
        watchFunc.run();
        Thread.sleep(1000);
        hanFeiZi.haveBreakFast();
        Thread.sleep(1000);
        hanFeiZi.haveFun();
    }
}
