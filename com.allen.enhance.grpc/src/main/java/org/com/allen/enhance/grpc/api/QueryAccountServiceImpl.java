package org.com.allen.enhance.grpc.api;

import org.com.allen.enhance.grpc.proto.QueryAccountProto;
import org.com.allen.enhance.grpc.proto.QueryAccountServiceGrpc;

import io.grpc.stub.StreamObserver;


/**
 * @author allen.wu
 * @since 2018-09-09 12:15
 */
public class QueryAccountServiceImpl implements QueryAccountServiceGrpc.QueryAccountService {
    @Override
    public void query(QueryAccountProto.AccountQueryRequest request, StreamObserver<QueryAccountProto.AccountQueryResponse> responseObserver) {
        System.out.println("query id is :  " + request.getUserId());
        QueryAccountProto.AccountQueryResponse response = QueryAccountProto.AccountQueryResponse.newBuilder().setRc(1).setAmount(666).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
