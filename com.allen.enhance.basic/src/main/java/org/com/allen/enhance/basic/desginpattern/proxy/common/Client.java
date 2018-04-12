package org.com.allen.enhance.basic.desginpattern.proxy.common;

import org.com.allen.enhance.basic.desginpattern.proxy.IGamePlayer;

public class Client {

    public static void main(String[] args) {
        IGamePlayer proxy = new GamePlayerProxy("吴涛");
        System.out.println("start .... ");
        proxy.login("allen","123");
        proxy.killBoss();
        proxy.killBoss();
        System.out.println("end .... ");
    }
}
