package org.com.allen.enhance.basic.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author allen.wu
 * @since 2018-07-09 22:31
 * 1,2,3,4,5,6,7,8,9,10
 * 1,2,4,5,7,8,10
 * 1,4,5,8,10
 * 4,5,10
 * 4,10
 * 4
 */
public class Josephus {

    public static void josephus(int total, int count) {
        List<Integer> start = new LinkedList<>();
        for (int i = 1; i <= total; i++) {
            start.add(i);
        }
        int k = 0;
        while (start.size() > 0) {
            k = (k + count) % (start.size()) - 1;
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }

    public static void rec(List<Integer> lists, int count, int mark) {
        int size = lists.size();
        if (size <= 1) {
            System.out.println(lists.get(0));
            return;
        }
        mark = (mark + count) % size - 1;
        if (mark < 0) {
            System.out.println(lists.get(size - 1));
            lists.remove(size - 1);
            mark = 0;
        } else {
            System.out.println(lists.get(mark));
            lists.remove(mark);
        }
        rec(lists, count, mark);
    }

    public static void main(String[] args) {
        josephus(10, 3);
        System.out.println("rec");
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        rec(list, 3, 0);
    }
}
