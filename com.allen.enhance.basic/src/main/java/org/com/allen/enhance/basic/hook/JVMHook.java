package org.com.allen.enhance.basic.hook;

public class JVMHook {

    public static void start() {
        System.out.println("The JVM Start ...");

    }

    public static void main(String[] args) {
        start();
        System.out.println("The Application is doing something");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("The JVM hook is execute");
            }
        });
    }
}
