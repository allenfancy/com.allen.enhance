package com.allen.enhance.hystrix.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


import org.junit.jupiter.api.Test;
import rx.Observable;
import rx.functions.Action1;


public class CommandTest {

    @Test
    public void testCommand() throws Exception {
        CommandHelloWorld chw = new CommandHelloWorld("allen-test");
        String run = chw.execute();
        System.out.println(run);
    }

    @Test
    public void testCommandAysn() throws InterruptedException, ExecutionException {
        Future<String> queue = new CommandHelloWorld("aysnc").queue();
        System.out.println(queue.get());
    }

    @Test
    public void testObservable() {
        CommandHelloWorldObservable chwo =
                new CommandHelloWorldObservable("allen observable world");
        Observable<String> observe = chwo.observe();
        observe.subscribe(new Action1<String>() {
            @Override
            public void call(String arg0) {
                System.out.println(arg0);
            }
        });
    }
    
    @Test
    public void testObservable2() {
        Observable<String> observe = new CommandHelloWorldObservable("allen observable world").observe();
        observe.subscribe((v)->{
            System.out.println("onNext:" +v);
        },(exception)-> {
              exception.printStackTrace();
        });
    }
    
    @Test
    public void testObservableBlocking() {
        Observable<String> observe = new CommandHelloWorldObservable("allen observable world blocking").toObservable();
        String single = observe.toBlocking().single();
        System.out.println("blocking ... " + single);
    }
}
