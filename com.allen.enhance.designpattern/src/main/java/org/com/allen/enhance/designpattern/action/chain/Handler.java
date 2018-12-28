package org.com.allen.enhance.designpattern.action.chain;

/**
 * @author allen.wu
 * @since 2018-12-19 23:56
 */
public abstract class Handler {

    public static final int FATHER_LEVEL_REQ = 1;
    public static final int HUSBAND_LEVEL_REQ = 2;
    public static final int SONE_LEVEL_REQ = 3;

    private int level = 0;
    private Handler nextHandler;

    public Handler(int level) {
        this.level = level;
    }

    public final void handlerMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.handlerMessage(women);
            } else {
                System.out.println("非法请求");
            }
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void response(IWomen women);
}
