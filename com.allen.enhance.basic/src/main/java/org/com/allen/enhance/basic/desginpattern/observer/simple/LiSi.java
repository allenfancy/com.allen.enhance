package org.com.allen.enhance.basic.desginpattern.observer.simple;

/**
 * @author allen.wu
 * @since 2018-09-13 17:45
 */
public class LiSi implements ILiSi {
    @Override
    public void update(String context) {
        System.out.println("李斯：观察到行为，开始向老板汇报....");
        this.reportMsg(context);
        System.out.println("李斯：汇报完毕");
    }

    private void reportMsg(String reportContext) {
        System.out.println("李斯：报告老板，韩非子有如下活动：" + reportContext);
    }
}
