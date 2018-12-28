package org.com.allen.enhance.basic.desginpattern.state;

/**
 * @author allen.wu
 * @since 2018-09-14 00:32
 */
public class StoppingState extends LifeState {

    @Override
    protected void open() {
        super.getContext().setLifeState(Context.openingState);
        super.getContext().getLifeState().open();
    }

    @Override
    protected void close() {

    }

    @Override
    protected void run() {
        super.getContext().setLifeState(Context.runningState);
        super.getContext().getLifeState().run();
    }

    @Override
    protected void stop() {
        System.out.println("电梯停止运行了");
    }
}
