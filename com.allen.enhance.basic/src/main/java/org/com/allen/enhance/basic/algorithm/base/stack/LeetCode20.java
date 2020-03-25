package org.com.allen.enhance.basic.algorithm.base.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author allen.wu
 * @since 2020-02-29 11:57
 */
public class LeetCode20 {


    public static void main(String[] args) {
        String s = "()[{}]";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (map.containsKey(c)) {
                char c1 = stack.isEmpty() ? '#' : stack.pop();
                if (c1 != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static boolean checkValidString1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || !c.equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
