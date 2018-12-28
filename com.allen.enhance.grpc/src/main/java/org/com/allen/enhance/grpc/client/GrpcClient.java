package org.com.allen.enhance.grpc.client;

import org.com.allen.enhance.grpc.proto.QueryAccountProto;
import org.com.allen.enhance.grpc.proto.QueryAccountServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author allen.wu
 * @since 2018-09-09 12:36
 */
public class GrpcClient {

    public static void main(String[] args) {
        QueryAccountProto.AccountQueryRequest request = QueryAccountProto.AccountQueryRequest.newBuilder().setUserId("20012").setRequestId("123").build();
        ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 8888)
            .usePlaintext(true)
            .build();
        QueryAccountServiceGrpc.QueryAccountServiceBlockingStub queryAccountServiceBlockingStub = QueryAccountServiceGrpc.newBlockingStub(channel);
        for (int j = 0; j < 20; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                QueryAccountProto.AccountQueryResponse rsp = queryAccountServiceBlockingStub.query(request);
                System.out.println(rsp);
            }
            System.out.println(System.currentTimeMillis() - start + " MS");
        }
    }
}
