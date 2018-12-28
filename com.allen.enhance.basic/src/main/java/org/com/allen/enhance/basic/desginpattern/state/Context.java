package org.com.allen.enhance.basic.desginpattern.state;

/**
 * @author allen.wu
 * @since 2018-09-14 00:25
 */
public class Context {


    public final static OpeningState openingState = new OpeningState();
    public final static ClosingState closingState = new ClosingState();
    public final static RunningState runningState = new RunningState();
    public final static StoppingState stoppingState = new StoppingState();

    private LifeState lifeState;

    public LifeState getLifeState() {
        return lifeState;
    }

    public void setLifeState(LifeState lifeState) {
        this.lifeState = lifeState;
        this.lifeState.setContext(this);
    }

    public void open() {
        this.lifeState.open();
    }

    public void close() {
        this.lifeState.close();
    }

    public void run() {
        this.lifeState.run();
    }

    public void stop() {
        this.lifeState.stop();
    }
}
