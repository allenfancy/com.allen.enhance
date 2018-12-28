package org.com.allen.enhance.basic.desginpattern.facade;

/**
 * @author allen.wu
 * @since 2018-09-14 02:21
 */
public class LetterPolice implements IPolice {


    @Override
    public void checkLetter() {
        System.out.println("信件内容检查好了，可以邮寄了");
    }
}
