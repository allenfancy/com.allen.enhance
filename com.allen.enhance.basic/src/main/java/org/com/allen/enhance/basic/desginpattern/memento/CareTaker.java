package org.com.allen.enhance.basic.desginpattern.memento;

/**
 * @author allen.wu
 * @since 2018-09-14 02:01
 */
public class CareTaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
