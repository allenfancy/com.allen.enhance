package org.com.allen.enhance.basic.desginpattern.decoration;

public abstract class Decorator extends SchoolReport {

    // 指向Component
    private SchoolReport sr;

    public Decorator(SchoolReport sr) {
        this.sr = sr;
    }

    @Override
    public void report() {
        this.sr.report();
    }

    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }
}
