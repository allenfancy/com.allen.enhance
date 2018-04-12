package org.com.allen.enhance.basic.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Callable 一个产生结果 Future 一个拿到结果
 * 
 * @author allen
 *
 */
public class CallableAndFuture {

    public static <V> void main(String[] args) {
        // 1.1 Callable
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return ThreadLocalRandom.current().nextInt(100);
            }
        };
        
        // 1.2 FutureTask
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        // 1.3 开启线程
        new Thread(future).start();
        try {
            // 1.4 获取值
            System.out.println(future.get(1, TimeUnit.MICROSECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
