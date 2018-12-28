package org.com.allen.enhance.basic.algorithm.sort.heap;

/**
 * @author allen.wu
 * @since 2018-07-09 21:10
 * <p>
 * 堆排序：
 * 选择排序的改进版本，堆排序客户以把每一趟元素的比较结果都保存下来，以便在选择最小/最大元素时对已经比较过的元素做出相应的调整.
 * 堆排序是一种树形选择排序,在排序过程中可以把元素看成一颗完全二叉树，每个节点都大(小)于他的俩个子节点，当每个节点都大于等于它的俩个自己子节点时，称为大顶堆，即堆有序。当每个节点都小于等于它的俩个子节点时，就称为小顶堆.
 * 思想:
 * 1.将常熟为n的待排序的数组进行堆有序结构化成一个大顶堆。
 * 2.将根节点与尾节点交换并输出尾节点
 * 3.将剩余的n-1个节点会从新进行堆有序化
 * 4.重复2，3步骤直到构造成一个有序序列
 * </p>
 */
public class HeapSort {

    /**
     * 堆筛选，除了start之外，start~end均满足大顶堆的定义。
     * 调整之后start~end称为一个大顶堆。
     *
     * @param arr   待调整数组
     * @param start 起始指针
     * @param end   结束指针
     */
    public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        //左右孩子的节点分别为2*i+1,2*i+2
        for (int i = 2 * start + 1; i <= end; i *= 2) {
            System.out.print("i = " + i);
            //选择出左右孩子较小的下标
            if (i < end && arr[i] < arr[i + 1]) {
                i++;
            }
            if (temp >= arr[i]) {
                break; //已经为大顶堆，=保持稳定性。
            }
            arr[start] = arr[i]; //将子节点上移
            start = i; //下一轮筛选
            System.out.println();
        }
        arr[start] = temp; //插入正确的位置
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        //建立大顶堆
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
        }
        System.out.println("最大堆构建完：");
        print(arr);
        System.out.println();
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            System.out.println("swap");
            print(arr);

            heapAdjust(arr, 0, i - 1);
            print(arr);
            System.out.println();
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
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
        heapSort(arr);
        System.out.println();
        System.out.println("排序后:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
