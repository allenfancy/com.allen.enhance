package org.com.allen.enhance.grpc.server;

import java.io.IOException;

import org.com.allen.enhance.grpc.api.QueryAccountServiceImpl;
import org.com.allen.enhance.grpc.proto.QueryAccountServiceGrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author allen.wu
 * @since 2018-09-09 12:33
 */
public class GrpcServer {

    private static final int port = 8888;
    private static Server server;

    public void run () throws IOException, InterruptedException {
        QueryAccountServiceGrpc.QueryAccountService accountService = new QueryAccountServiceImpl();
        server = ServerBuilder.forPort(port).addService(QueryAccountServiceGrpc.bindService(accountService)).build();
        server.start();
        System.out.println("grpc server start success on port: " + port);
        server.awaitTermination();
    }

    public static void main(String[] args) {
        try {
            new GrpcServer().run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
