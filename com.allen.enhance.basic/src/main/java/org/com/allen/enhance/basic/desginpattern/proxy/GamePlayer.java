package org.com.allen.enhance.basic.desginpattern.proxy;

public class GamePlayer implements IGamePlayer {
    private String name = "";

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String username, String password) {
        System.out.println(this.name + " login " + username +" => "+ password);
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + " kill bossess");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + " upgrage");
    }
}
