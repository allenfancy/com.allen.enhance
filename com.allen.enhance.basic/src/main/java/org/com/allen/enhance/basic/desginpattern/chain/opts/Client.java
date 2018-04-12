package org.com.allen.enhance.basic.desginpattern.chain.opts;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;


/**
 * 使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系。将这些对象连接一条链，并沿着这条链传递该请求
 * 直到有对象处理它为止。
 * 优点：请求和处理分开。请求者可以不用直到是谁在处理，处理者可以不用直到请求的全貌。
 * 缺点：1、性能问题。2、调试不方便
 */
public class Client {

    public static void main(String[] args) {
        Random random = new Random();
        List<IWomen> lists = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            lists.add(new Women(random.nextInt(4), "我要出去逛街了"));
        }
        Handler fatherHandler = new FatherHandler();
        Handler husbandHandler = new HusbandHandler();
        Handler sonHandler = new SonHandler();
        fatherHandler.setNext(husbandHandler);
        husbandHandler.setNext(sonHandler);
        for (IWomen wowen : lists) {
            fatherHandler.handlerMessage(wowen);
        }

    }
}
