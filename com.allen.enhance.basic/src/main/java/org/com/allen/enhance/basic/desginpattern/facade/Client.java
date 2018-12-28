package org.com.allen.enhance.basic.desginpattern.facade;

/**
 * @author allen.wu
 * @since 2018-09-14 02:19
 */
public class Client {

    public static void main(String[] args) {
        ModenPostOffice modenPostOffice = new ModenPostOffice();
        modenPostOffice.sendLetter("这就是内容呀","北京");
    }
}
