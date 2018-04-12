package org.com.allen.enhance.basic.desginpattern.chain;

public class Woman implements IWoman {

    private int type = 0;
    private String request = "";

    public Woman(int _type, String _request) {
        this.type = _type;
        this.request = _request;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getResponse() {
        return this.request;
    }
}
