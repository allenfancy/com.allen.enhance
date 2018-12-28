package org.com.allen.enhance.basic.algorithm.sort.radix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author allen.wu
 * @since 2018-07-09 22:11
 */
public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null && arr.length == 0) {
            return;
        }

        int maxBit = getMaxBit(arr);
        for (int i = 1; i <= maxBit; i++) {
            List<List<Integer>> buf = distribute(arr, i); //分配
            collecte(arr, buf); //收集
        }

    }

    /**
     * 分配
     *
     * @param arr  待分配数组
     * @param iBit 要分配第几位
     */
    public static List<List<Integer>> distribute(int[] arr, int iBit) {
        List<List<Integer>> buf = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            buf.add(new LinkedList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            buf.get(getNBit(arr[i], iBit)).add(arr[i]);
        }
        return buf;
    }

    /**
     * 收集
     *
     * @param arr 把分配的数据收集到arr中
     */
    public static void collecte(int[] arr, List<List<Integer>> buf) {
        int k = 0;
        for (List<Integer> bucket : buf) {
            for (int ele : bucket) {
                arr[k++] = ele;
            }
        }
    }

    /**
     * 获取最大位数
     */
    public static int getMaxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            int len = (ele + "").length();
            if (len > max)
                max = len;
        }
        return max;
    }

    /**
     * 获取x的第n位，如果没有则为0.
     */
    public static int getNBit(int x, int n) {

        String sx = x + "";
        if (sx.length() < n)
            return 0;
        else
            return sx.charAt(sx.length() - n) - '0';
    }

    public static void main(String[] args) {
        int arr[] = {10, 1, 33, 88, 55, 999, 1001, 20, 99, 40, 100};
        System.out.println("排序前:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        radixSort(arr);
        System.out.println();
        System.out.println("排序后:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
