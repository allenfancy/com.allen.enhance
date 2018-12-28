package org.com.allen.enhance.basic.desginpattern.state;

/**
 * @author allen.wu
 * @since 2018-09-14 00:32
 */
public class ClosingState extends LifeState {


    // 电梯门关闭了，可以再打开
    @Override
    protected void open() {
        super.getContext().setLifeState(Context.openingState);
        super.getContext().getLifeState().open();
    }

    @Override
    protected void close() {
        System.out.println("电梯门关闭了...");
    }

    @Override
    protected void run() {
        super.getContext().setLifeState(Context.runningState);
        super.getContext().getLifeState().run();
    }

    // 电梯门关闭了，没有按楼层，电梯就处于停滞状态
    @Override
    protected void stop() {
        super.getContext().setLifeState(Context.stoppingState);
        super.getContext().getLifeState().stop();
    }
}
