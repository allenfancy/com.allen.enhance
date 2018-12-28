package org.com.allen.enhance.basic.algorithm.sort.count;

import java.util.Arrays;

/**
 * @author allen.wu
 * @since 2018-07-09 21:25
 * <p>
 * 计数排序:
 *  将对应的排序数组的值变为下标，在循环一次，出现的位置下标+1；
 *  最终转化.
 * </p>
 */
public class CountSort {

    public static void countSort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        int max = max(arr);
        System.out.println(max);
        int[] count = new int[max + 1];
        Arrays.fill(count, 0);

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        print(count);
        int k = 0;
        for (int i = 0; i <= max; i++) {
            if(count[i]!=0) {
                arr[k++]= i;
            }
        }
    }

    public static int max(int[] arr) {
        int MAX = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > MAX) {
                MAX = i;
            }
        }
        return MAX;
    }

    public static void print( int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {10, 1, 20, 99, 40, 100};
        countSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
