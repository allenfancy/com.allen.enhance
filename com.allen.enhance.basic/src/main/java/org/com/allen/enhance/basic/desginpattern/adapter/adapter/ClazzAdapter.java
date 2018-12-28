package org.com.allen.enhance.basic.desginpattern.adapter.adapter;

/**
 * @author allen.wu
 * @since 2018-09-26 10:05
 */
public class ClazzAdapter extends USBer implements PS2 {
    @Override
    public void isPS2() {
        super.isUSB();
    }
}
