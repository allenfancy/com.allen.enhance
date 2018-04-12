package org.com.allen.enhance.basic.concurrent.future;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

public class CallableAndFuture2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        
        List<Future<String>> lists = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            Future<String> submit = threadPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return ""+Thread.currentThread().getName() + ":id => " + Thread.currentThread().getId();
                }
            });
            lists.add(submit);
        }
        TimeUnit.SECONDS.sleep(1);
        for (Future<String> f : lists) {
            System.out.println(f.get());
        }
    }
}
