package org.com.allen.enhance.basic.rpc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        HelloService helloService = RpcFrameWork.refer(HelloService.class, "localhost", 8081);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println(helloService.sayRpc("world-" + i));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
