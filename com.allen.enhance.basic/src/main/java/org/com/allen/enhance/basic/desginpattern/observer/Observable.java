package org.com.allen.enhance.basic.desginpattern.observer;

/**
 * @author allen.wu
 * @since 2018-09-13 17:59
 * 被观察者
 */
public interface Observable {

    void addObserver(Observer observable);

    void deleteObserver(Observer observable);

    void notifyObserver(String context);
}
