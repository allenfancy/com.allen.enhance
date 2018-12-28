package org.com.allen.enhance.basic.algorithm.search;

/**
 * @author allen.wu
 * @since 2018-07-09 22:17
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (arr[middle] == key) {
                return middle;
            } else if (arr[middle] > key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {5, 3, 1, 2, 99, 60};
        int i = binarySearch(arr, 99);
        System.out.println(i);
    }
}
