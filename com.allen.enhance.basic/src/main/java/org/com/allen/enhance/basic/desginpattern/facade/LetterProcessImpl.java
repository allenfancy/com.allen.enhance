package org.com.allen.enhance.basic.desginpattern.facade;

/**
 * @author allen.wu
 * @since 2018-09-14 02:16
 */
public class LetterProcessImpl implements ILetterProcess {


    @Override
    public void writeContext(String context) {
        System.out.println(context);
    }

    @Override
    public void fillEnvlope(String address) {
        System.out.println("address is :" + address);
    }

    @Override
    public void letterIntoEvelop() {
        System.out.println("把信件放入信封中。。。");
    }

    @Override
    public void sendLetter() {
        System.out.println("邮递信件。。。");
    }
}
