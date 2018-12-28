package org.com.allen.enhance.basic.desginpattern.state;

/**
 * @author allen.wu
 * @since 2018-09-14 00:28
 */
public class OpeningState extends LifeState {


    @Override
    protected void open() {
        System.out.println("开启电梯门....");
    }

    @Override
    protected void close() {
        super.getContext().setLifeState(Context.closingState);
        super.getContext().getLifeState().close();
    }

    @Override
    protected void run() {
        throw new RuntimeException("开者们就跑，直接报错");
    }

    @Override
    protected void stop() {
        // do nothing
    }
}
