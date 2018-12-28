package org.com.allen.enhance.basic.desginpattern.state;

/**
 * @author allen.wu
 * @since 2018-09-14 00:32
 */
public class RunningState extends LifeState {


    @Override
    protected void open() {
        throw new RuntimeException();
    }

    @Override
    protected void close() {
        //
    }

    @Override
    protected void run() {
        System.out.println("电梯上下运动中....");
    }

    @Override
    protected void stop() {
        super.getContext().setLifeState(Context.stoppingState);
        super.getContext().getLifeState().stop();
    }
}
