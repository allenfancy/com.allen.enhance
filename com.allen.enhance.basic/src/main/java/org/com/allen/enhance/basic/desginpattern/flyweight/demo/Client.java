package org.com.allen.enhance.basic.desginpattern.flyweight.demo;

/**
 * @author allen.wu
 * @since 2018-09-14 01:11
 */
public class Client {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            String subject = "科目" + i;
            for (int j = 0; j < 30; j++) {
                String key = subject + "考试地点" + j;
                SignInfoFactory.getSign4Info(key);
            }
        }
        System.out.println(SignInfoFactory.getSign4Info("科目0考试地点0"));
    }
}
