package org.com.allen.enhance.basic.desginpattern.proxy;

/**
 * 网络代理服务器：
 * 1.透明代理
 * 2.普通代理
 *
 * 普通代理，它的奥球就是客户端只能访问代理角色，而不能访问真是角色.
 */
public class Client {
    public static void main(String[] args) {

        IGamePlayer gamePlayer = new GamePlayer("wutao");
        IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
        proxy.login("allen", "1");
        proxy.killBoss();
        proxy.upgrade();
    }
}
