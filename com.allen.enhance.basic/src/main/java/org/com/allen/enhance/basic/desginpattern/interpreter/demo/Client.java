package org.com.allen.enhance.basic.desginpattern.interpreter.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author allen.wu
 * @since 2018-09-14 01:41
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> value = getValue(getExpStr());
        Calculator calculator = new Calculator(getExpStr());
        System.out.println(calculator.run(value));
    }

    private static  String getExpStr() throws IOException {
        System.out.println("请输入表达式");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    private static Map<String, Integer> getValue(String expStr) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    map.put(String.valueOf(ch), Integer.valueOf(bufferedReader.readLine()));
                }
            }
        }
        return map;
    }
}
