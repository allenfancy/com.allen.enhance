package org.com.allen.enhance.basic.desginpattern.adapter.adapter;


/**
 * @author allen.wu
 * @since 2018-09-26 10:06
 */
public class ObjectAdapater implements PS2 {

    private USB usb;

    public ObjectAdapater(USB usb) {
        this.usb = usb;
    }

    @Override
    public void isPS2() {
        usb.isUSB();
    }
}
