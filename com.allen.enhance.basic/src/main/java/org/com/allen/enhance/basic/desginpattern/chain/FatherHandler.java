package org.com.allen.enhance.basic.desginpattern.chain;

public class FatherHandler implements  IHandler {
    @Override
    public void HandlerMessage(IWoman woman) {
        System.out.println("女儿的请求："+woman.getResponse());
        System.out.println("父亲：同意");
    }
}
