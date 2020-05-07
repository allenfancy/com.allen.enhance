package org.com.allen.enhance.basic.algorithm.base.stack;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author allen
 * @date 2020/3/27 3:12 下午
 **/
public class LeetCode316 {


    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        TreeSet<Character> set = new TreeSet<>();
        for (Character c : chars) {
            set.add(c);
        }
        Iterator<Character> iterator = set.iterator();
        StringBuffer buffer = new StringBuffer();
        while (iterator.hasNext()) {
            buffer.append(iterator.next());
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        LeetCode316 lc = new LeetCode316();
        lc.removeDuplicateLetters("bcabc");
    }
}
