package org.com.allen.enhance.basic.algorithm.sort.quick;

/**
 * @author allen.wu
 * @since 2018-07-09 18:44
 * <p>
 * 快速排序 = 冒泡 + 二分 + 递归分治
 * 思想：
 *
 * </p>
 */
public class QuickSort {


    public static int partition(int[] arr, int left, int right) {
        int value = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= value) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= value) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = value;
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (left >= right) {
            return;
        }
        // 基础分区
        int partition = partition(arr, left, right);
        print(arr);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {50, 1, 20, 99, 40, 100, 33, 1001, 55, 66, 77, 999, 12, 8};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
