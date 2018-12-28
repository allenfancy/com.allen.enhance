package org.com.allen.enhance.basic.desginpattern.state;

/**
 * @author allen.wu
 * @since 2018-09-14 00:24
 */
public abstract class LifeState {

    // 封装状态的变化引起的功能变化
    private Context context;

    void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    protected abstract void open();

    protected abstract void close();

    protected abstract void run();

    protected abstract void stop();

}
