package org.com.allen.enhance.basic.desginpattern.decoration.demo2;

/**
 * @author allen.wu
 * @since 2018-09-26 09:41
 */
public class NormalBread implements IBread {
    @Override
    public void prepare() {
        System.out.println("准备面粉,水以及发酵粉...");
    }

    @Override
    public void kneadFlour() {
        System.out.println("和面...");
    }

    @Override
    public void streamed() {
        System.out.println("蒸馒头...香喷喷的馒头出炉了");
    }

    @Override
    public void proccess() {
        this.prepare();
        this.kneadFlour();
        this.streamed();
    }
}
