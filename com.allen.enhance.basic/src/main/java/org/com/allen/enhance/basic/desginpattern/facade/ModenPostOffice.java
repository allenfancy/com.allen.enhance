package org.com.allen.enhance.basic.desginpattern.facade;

/**
 * @author allen.wu
 * @since 2018-09-14 02:18
 */
public class ModenPostOffice {

    ILetterProcess letterProcess = new LetterProcessImpl();

    IPolice police = new LetterPolice();

    void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvlope(address);
        letterProcess.letterIntoEvelop();
        police.checkLetter();
        letterProcess.sendLetter();
    }
}
