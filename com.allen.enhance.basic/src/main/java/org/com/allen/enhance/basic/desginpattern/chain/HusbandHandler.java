package org.com.allen.enhance.basic.desginpattern.chain;

public class HusbandHandler implements  IHandler {
    @Override
    public void HandlerMessage(IWoman woman) {
        System.out.println("女儿的请求："+woman.getResponse());
        System.out.println("丈夫：同意");
    }
}
