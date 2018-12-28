package org.com.allen.enhance.basic.algorithm.sort.merge;

/**
 * @author allen.wu
 * @since 2018-07-09 21:57
 * <p>
 * 归并排序:
 * 递归分治的思想。先递归划分子问题，然后合并结果。
 * 空间复杂度为O(n)，时间复杂度为O(nlogn)
 * </p>
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int arr[], int left, int mid, int right) {
        int[] tmp = new int[right - left + 1]; //中间数组
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }
        for (int p = 0; p < tmp.length; p++) {
            arr[left + p] = tmp[p];
        }
        print(arr);
    }

    public static void print(int[] arr) {
        System.out.println("排序中:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {10, 1, 33, 88, 55, 999, 1001, 20, 99, 40, 100};
        System.out.println("排序前:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        mergeSort(arr);
        System.out.println();
        System.out.println("排序后:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
