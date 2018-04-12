package org.com.allen.enhance.basic.desginpattern.abstractfactory;

public class ManFactory implements HumanFactory {

    @Override
    public Human createYellowHuman() {
        return new ManYellowHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new ManBlackHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new ManWhiteHuman();
    }
}
