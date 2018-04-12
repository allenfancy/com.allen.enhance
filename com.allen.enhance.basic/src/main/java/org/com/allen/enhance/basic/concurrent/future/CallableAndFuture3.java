package org.com.allen.enhance.basic.concurrent.future;

import java.net.URI;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CallableAndFuture3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
       /* ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorCompletionService<Integer> executorCompletionService =
                new ExecutorCompletionService<Integer>(threadPool);
        for (int i = 0; i < 100; i++) {
            final int taskID = i;
            threadPool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return taskID;
                }
            });
        }
        TimeUnit.SECONDS.sleep(5);
        for(int i =0 ;i <100;i++) {
            System.out.println(executorCompletionService.take().get());
        }*/
        URI uri = URI.create("http://bangumi.bilibili.com/anime/5795/play?aid=7945951#98639#reply278194949&mobi_app=android&platform=android&sign=a6bafb38f99dad074c77643d13b16192");
        System.out.println(uri.getHost());
    }
}
