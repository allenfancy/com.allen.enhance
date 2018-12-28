package org.com.allen.enhance.basic.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author allen.wu
 * @since 2018-12-20 23:32
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandler abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        ThreadFactory build = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("load-").build();
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, build, abortPolicy);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println(System.currentTimeMillis() / 1000L);
            System.out.println(Thread.currentThread().getName() + " => 111");
            System.out.println("==========================");
        }, 5, 10, TimeUnit.SECONDS);
        TimeUnit.MINUTES.sleep(10);
    }
}
