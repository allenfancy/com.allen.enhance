package org.com.allen.enhance.basic.desginpattern.chain;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

public class Client {

    public static void main(String[] args) {
        Random rand = new Random();
        List<IWoman> lists = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            lists.add(new Woman(rand.nextInt(4), "我要出去逛街了"));
        }
        IHandler father = new FatherHandler();
        IHandler husband = new HusbandHandler();
        IHandler son = new SonHandler();
        for (IWoman women : lists) {
            if (women.getType() == 1) {
                System.out.println("\n-----女儿向父亲请示----");
                father.HandlerMessage(women);
            } else if (women.getType() == 2) {
                System.out.println("\n-----女儿向丈夫请示----");
                husband.HandlerMessage(women);
            } else if (women.getType() == 3) {
                System.out.println("\n-----女儿向儿子请示----");
                son.HandlerMessage(women);
            } else {
                System.out.println("没有请求的人。。。");
            }
        }
    }
}
