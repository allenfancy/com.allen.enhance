package org.com.allen.enhance.basic.desginpattern.observer;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author allen.wu
 * @since 2018-09-13 18:02
 */
public class HanFeiZi implements IHanFeiZi, Observable {

    private List<Observer> observableList = Lists.newArrayList();

    @Override
    public void goToCourt() {
        System.out.println("韩飞子去上朝了");
        this.notifyObserver("韩飞子去上朝了");
    }

    @Override
    public void outToCourt() {
        System.out.println("韩飞子去下朝了");
        this.notifyObserver("韩飞子去下朝了");
    }

    @Override
    public void addObserver(Observer observable) {
        observableList.add(observable);
    }

    @Override
    public void deleteObserver(Observer observable) {
        Iterator<Observer> iterator = observableList.iterator();
        while (iterator.hasNext()) {
            Observer next = iterator.next();
            if (next.equals(iterator)) {
                iterator.remove();
            }
        }
    }

    @Override
    public void notifyObserver(String context) {
        for (Observer observable : observableList) {
            observable.update(context);
        }
    }
}
