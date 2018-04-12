package org.com.allen.enhance.basic.desginpattern.chain.opts;


public class FatherHandler extends Handler {

    public FatherHandler() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("---女儿向父亲请示---");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复：OK\n");
    }
}
