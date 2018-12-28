package org.com.allen.enhance.basic.desginpattern.flyweight.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author allen.wu
 * @since 2018-09-14 01:07
 */
public class SignInfoFactory {

    private static Map<String, SignInfo> pool = new ConcurrentHashMap<>();

    public static SignInfo getSignInfo() {
        return new SignInfo();
    }

    public static SignInfo getSign4Info(String key) {

        SignInfo signInfo;
        if (!pool.containsKey(key)) {
            signInfo = new Sign4Info(key);
            System.out.println(key + " ---- 创建对象，存放到池中");
            pool.put(key, signInfo);

        } else {
            System.out.println(key + " ---- 从池中获取对象");
            signInfo = pool.get(key);
        }
        return signInfo;
    }
}
