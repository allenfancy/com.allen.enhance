package org.com.allen.enhance.basic.desginpattern.Strategy;

public class Client2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int exec = Calculator.ADD.exec(a, b);
        System.out.println(exec);
        int exec1 = Calculator.SUB.exec(a, b);
        System.out.println(exec1);
    }
}
