package org.com.allen.enhance.basic.desginpattern.chain.opts;

public class HusbandHandler extends   Handler {

    public HusbandHandler(){
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("---女儿向丈夫请示---");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复：OK\n");
    }
}
