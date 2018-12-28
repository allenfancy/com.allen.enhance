package org.com.allen.enhance.designpattern.action.chain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author allen.wu
 * @since 2018-12-20 00:02
 */
public class Client {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        List<IWomen> lists = new ArrayList<IWomen>();
        for (int i = 0; i < 5; i++) {
            lists.add(new Women(RANDOM.nextInt(4), "我要出去玩哈"));
        }
        Handler father = new FatherHandler();
        Handler husband = new HusbandHandler();
        Handler son = new SonHandler();
        // 设置顺序
        father.setNextHandler(husband);
        husband.setNextHandler(son);
        for (IWomen women : lists) {
            father.handlerMessage(women);
        }
    }
}
