package org.com.allen.enhance.basic.desginpattern.proxy.froce;

public class GamePlayer implements IGamePlayer {

    private String name = "";

    private IGamePlayer proxy = null;


    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    @Override
    public void login(String username, String password) {
        if (isProxy()) {
            System.out.println(this.name + " login " + username + " => " + password);
        } else {
            System.out.println("错误");
        }

    }

    @Override
    public void killBoss() {
        if (isProxy()) {
            System.out.println(this.name + " kill bossess");
        } else {
            System.out.println("错误");
        }
    }

    @Override
    public void upgrade() {
        if (isProxy()) {
            System.out.println(this.name + " upgrage");
        } else {
            System.out.println("错误");
        }
    }

    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        }
        return true;
    }
}
