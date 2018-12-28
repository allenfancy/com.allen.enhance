package org.com.allen.enhance.basic.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author allen.wu
 * @since 2018-07-09 23:26
 *
 * 输入：
 * aabbccddeedf
 * 输出:
 * abcdef
 */
public class RemoveChar {

    /**
     * 利用Stack的特性
     * @param str
     * @return
     */
    public static String removeChar(String str) {
        Stack<Character> s = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (!s.contains(str.charAt(i))) {
                s.push(str.charAt(i));
            }
        }
        char[] tmp = new char[s.size()];
        int i = s.size() - 1;
        while (!s.isEmpty()) {
            tmp[i--] = s.pop();
        }
        return Arrays.toString(tmp);
    }

    public static void main(String[] args) {
        removeChar("aabbccddeedf");
    }
}
