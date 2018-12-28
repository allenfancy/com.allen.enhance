package org.com.allen.enhance.basic.desginpattern.memento;

/**
 * @author allen.wu
 * @since 2018-09-14 01:55
 */
public class Body {

    private String state = "";

    public void changeState() {
        this.state = "心情可能很不好";
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
