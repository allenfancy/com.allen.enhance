package org.com.allen.enhance.basic.desginpattern.proxy.common;

import org.com.allen.enhance.basic.desginpattern.proxy.IGamePlayer;

public class GamePlayer implements IGamePlayer {

    private String name = "";

    public GamePlayer(IGamePlayer _gamePlayer, String _name) throws Exception {

        if (_gamePlayer == null) {
            throw new Exception("你不能创建真是角色。。。");
        } else {
            this.name = _name;
        }
    }

    @Override
    public void login(String username, String password) {
        System.out.println(this.name + " login " + username + " => " + password);
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
