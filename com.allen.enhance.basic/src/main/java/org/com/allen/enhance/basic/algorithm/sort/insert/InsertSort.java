package org.com.allen.enhance.basic.algorithm.sort.insert;

/**
 * @author allen.wu
 * @since 2018-07-09 17:28
 *
 * <p>
 * 思想:
 *
 * 时间复杂度:
 * O(n^2)
 * </p>
 * 空间复杂度：
 * O(1)
 *
 * @TODO
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int i, j;
        int n = arr.length;
        int target;
        for (i = 1; i < n; i++) {
            j = i;
            target = arr[i];
            // 移动元素
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
                System.out.println(target);
                print(arr);
            }
            arr[j] = target;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {101, 10, 1, 300, 99, 40, 100};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
