package org.com.allen.enhance.basic.desginpattern.facade;

/**
 * @author allen.wu
 * @since 2018-09-14 02:15
 */
public interface ILetterProcess {

    void writeContext(String context);

    void fillEnvlope(String address);

    void letterIntoEvelop();

    void sendLetter();
}
