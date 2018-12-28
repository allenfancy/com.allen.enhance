package org.com.allen.enhance.basic.leetcode;

/**
 * @author allen.wu
 * @since 2018-07-09 23:18
 * 给定一个字符串，求第一个不重复的字符
 * abbcad -> c
 */
public class CharStatics {

    /**
     * 计数排序的思想.
     */
    public static void search(String str) {
        char[] tmp = new char[256];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 0;
        }
        for (int i = 0; i < str.length(); i++) {
            tmp[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (tmp[str.charAt(i)] == 1) {
                System.out.println(str.charAt(i));
                break;
            }
        }
    }

    public static void main(String[] args) {
        search("abbcad");
    }
}
