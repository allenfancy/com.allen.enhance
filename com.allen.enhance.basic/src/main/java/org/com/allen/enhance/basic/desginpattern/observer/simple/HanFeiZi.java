package org.com.allen.enhance.basic.desginpattern.observer.simple;

/**
 * @author allen.wu
 * @since 2018-09-13 17:42
 */
public class HanFeiZi implements IHanFeiZi {

    private boolean isHavingBreakFast = false;

    private boolean isHavingFun = false;


    @Override
    public void haveBreakFast() {

        System.out.println("韩非子：开始吃饭");
        this.isHavingBreakFast = true;
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子：开始娱乐");
        this.isHavingFun = true;
    }

    public boolean isHavingBreakFast() {
        return isHavingBreakFast;
    }

    public void setHavingBreakFast(boolean havingBreakFast) {
        isHavingBreakFast = havingBreakFast;
    }

    public void setHavingFun(boolean havingFun) {
        isHavingFun = havingFun;
    }

    public boolean isHavingFun() {
        return isHavingFun;
    }
}
