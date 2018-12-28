package org.com.allen.enhance.basic.algorithm.sort.selector;

/**
 * @author allen.wu
 * @since 2018-07-09 17:04
 * <p>
 *     思想:
 *       选定一个基准和整体进行比较，比基准小的和基准交换位置.
 *     时间复杂度:
 *          O(n^2)
 * </p>
 */
public class SelectorSort {


    public static void selector(int arr[]) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            tmp = i;
            System.out.println("外层循环:" + i);
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("交换前:");
                print(j, arr);
                if (arr[j] < arr[tmp]) {
                    tmp = j;
                    if (tmp != i) {
                        swap(arr, tmp, i);
                        System.out.print("交换后:");
                        print(j, arr);
                    }
                }
            }
        }
    }

    public static void print(int j, int[] arr) {
        System.out.print("内存循环:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {10, 1, 20, 99, 40, 100};
        selector(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
