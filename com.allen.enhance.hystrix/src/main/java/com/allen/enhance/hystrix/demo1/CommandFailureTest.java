package com.allen.enhance.hystrix.demo1;

import org.junit.jupiter.api.Test;

public class CommandFailureTest {

    @Test
    public void testCommandFallback() {
        CommandHelloFailure commandHelloFailure = new CommandHelloFailure("allen wu fallback");
        String execute = commandHelloFailure.execute();
        System.out.println(execute);
    }
}
