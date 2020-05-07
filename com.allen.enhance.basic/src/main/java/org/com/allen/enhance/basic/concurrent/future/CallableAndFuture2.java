package org.com.allen.enhance.basic.concurrent.future;

import java.util.List;
import java.util.concurrent.*;

import com.google.common.collect.Lists;

/**
 * @author allen
 */
public class CallableAndFuture2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService threadPool = Executors.newFixedThreadPool(4 * Runtime.getRuntime().availableProcessors(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Callable-Future-");
            }
        });

        List<Future<String>> lists = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            Future<String> submit = threadPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "" + Thread.currentThread().getName() + ":id => " + Thread.currentThread().getId();
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
