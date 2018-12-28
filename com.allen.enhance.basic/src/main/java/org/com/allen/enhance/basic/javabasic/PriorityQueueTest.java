package org.com.allen.enhance.basic.javabasic;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 可以是用PriorityQueue 实现堆排序
 *
 * @author allen.wu
 * @since 2018-10-07 11:23
 */
public class PriorityQueueTest {

    private static Queue<Integer> queue;

    public static void main(String[] args) {
        int[] arr = {2, 1, 39, 22, 11, 19, 29};
        queue = new PriorityQueue<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        int size = queue.size();
        do {
            System.out.print(queue.poll() + " ");
            size--;
        } while (size > 0);
    }
}
