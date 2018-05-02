package org.com.allen.enhance.basic.rpc;

import java.io.IOException;

public class Server {

    public static void main(String[] args) throws IOException {
        HelloService helloService = new HelloServiceImpl();
        RpcFrameWork.export(helloService, 8081);
    }
}
