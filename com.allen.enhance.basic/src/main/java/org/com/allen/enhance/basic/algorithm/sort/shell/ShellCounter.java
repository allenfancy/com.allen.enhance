package org.com.allen.enhance.basic.algorithm.sort.shell;

/**
 * @author allen.wu
 * @since 2018-07-09 21:48
 * <p>
 * 希尔排序：
 * 是插入排序的一种高效率的实现，也叫缩小增量排序。
 * 基本思想：
 * 先将整个待排序序列分隔成为若干个子序列分别进行直接插入跑徐，带整个序列中的记录基本有序时在对全部记录进行一次直接插入排序
 * </p>
 */
public class ShellCounter {

    public static void shellInsert(int[] arr, int d) {
        System.out.println("d :" + d);
        for (int i = d; i < arr.length; i++) {
            int j = i - d;
            int temp = arr[i];    //记录要插入的数据
            while (j >= 0 && arr[j] > temp) {  //从后向前，找到比其小的数的位置
                arr[j + d] = arr[j];    //向后挪动
                j -= d;
            }

            if (j != i - d)    //存在比其小的数
                arr[j + d] = temp;
        }
        print(arr);
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int d = arr.length / 2;
        while (d >= 1) {
            shellInsert(arr, d);
            d /= 2;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {10, 1, 33,88,55,999,1001,20, 99, 40, 100};
        System.out.println("排序前:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        shellSort(arr);
        System.out.println();
        System.out.println("排序后:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
