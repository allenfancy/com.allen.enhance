package org.com.allen.enhance.basic.desginpattern.observer.simple;

/**
 * @author allen.wu
 * @since 2018-09-13 17:47
 */
public class Spy extends Thread {

    private HanFeiZi hanFeiZi;
    private LiSi liSi;
    private String type;

    public Spy(HanFeiZi hanFeiZi, LiSi liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            if ("breakfast".equals(this.type)) {
                if (this.hanFeiZi.isHavingBreakFast()) {
                    this.liSi.update("韩非子在吃饭");
                    this.hanFeiZi.setHavingBreakFast(false);
                } else {
                    this.liSi.update("韩非子在娱乐");
                    this.hanFeiZi.setHavingFun(false);
                }
            }
        }
    }
}
