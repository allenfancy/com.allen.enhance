package org.com.allen.enhance.basic.desginpattern.decoration.demo2;

/**
 * @author allen.wu
 * @since 2018-09-26 09:44
 */
public class CronDecorator extends BreadDecorator {


    public CronDecorator(IBread bread) {
        super(bread);
    }

    public void paint() {
        System.out.println("添加柠檬黄的着色剂");
    }

    @Override
    public void kneadFlour() {
        //添加着色剂后和面
        this.paint();
        super.kneadFlour();
    }
}
