package org.com.allen.enhance.basic.rpc;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayRpc(String name) {
        return "Hello Rpc " + name;
    }

}
