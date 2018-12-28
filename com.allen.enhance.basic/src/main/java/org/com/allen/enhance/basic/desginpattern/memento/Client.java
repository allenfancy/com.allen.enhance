package org.com.allen.enhance.basic.desginpattern.memento;

/**
 * @author allen.wu
 * @since 2018-09-14 01:57
 * 迪米特法则：
 */
public class Client {
    public static void main(String[] args) {
        Body body = new Body();

        CareTaker careTaker = new CareTaker();

        body.setState("心情很好");
        System.out.println(body.getState());

        careTaker.setMemento(body.createMemento());
        body.changeState();
        System.out.println("追妹子后心情");
        System.out.println(body.getState());
        body.restoreMemento(careTaker.getMemento());
        System.out.println(body.getState());
    }
}
