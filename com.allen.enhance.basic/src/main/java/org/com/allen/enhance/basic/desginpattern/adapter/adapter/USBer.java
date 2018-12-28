package org.com.allen.enhance.basic.desginpattern.adapter.adapter;

/**
 * @author allen.wu
 * @since 2018-09-26 10:04
 * 存在的接口的实现
 */
public class USBer implements USB {
    @Override
    public void isUSB() {
        System.out.println("===this is usb===");
    }
}
