package org.com.allen.enhance.basic.desginpattern.decoration;

public class SortDecorator extends Decorator {

    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportSort() {
        System.out.println("我的排名是第38");
    }

    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}
