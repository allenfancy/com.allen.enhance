package org.com.allen.enhance.basic.algorithm.sort.bubble;

/**
 * @author allen.wu
 * @since 2018-07-09 11:45
 * <p>
 * 思想:
 * 通过与相邻元素的比较和交换，把小的数交换到最前面.
 * 时间复杂度:
 * O(n^2)
 * </p>
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void bubbleSort1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * <p>
     *     递归：
     *      退出的条件，
     * </p>
     * @param arr
     * @param start
     * @param end
     */
    public static void recursion(int arr[], int start, int end) {
        if (start < end) {
            int len = end - start ;
            for (int i = start; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            end--;
            recursion(arr, start, end);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {5, 3, 1, 2, 99, 60};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Bubble two");
        int arr1[] = {5, 3, 1, 2, 99, 60};
        bubbleSort1(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        System.out.println("recursion three");
        int arr2[] = {5, 3, 1, 2, 99, 60};
        recursion(arr2, 0, arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
