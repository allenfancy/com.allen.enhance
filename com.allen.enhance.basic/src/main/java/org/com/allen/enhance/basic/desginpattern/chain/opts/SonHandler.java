package org.com.allen.enhance.basic.desginpattern.chain.opts;


public class SonHandler extends Handler {

    public SonHandler() {
        super(Handler.SON_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("---女儿向儿子请示---");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复：OK\n");
    }
}
