package org.com.allen.enhance.basic.desginpattern.memento;

/**
 * @author allen.wu
 * @since 2018-09-14 01:54
 */
public class Memento {

    private String state = "";

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
