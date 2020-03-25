package org.com.allen.enhance.basic.algorithm.base.array;

/**
 * @author allen.wu
 * @since 2020-03-11 10:39
 */
public class LeetCode283 {

    public static void main(String[] args) {
        int[] arr = {1, 13, 2, 0, 4, 0, 9, 11};
        //int[] arr ={1, 2, 4, 9, 11, 13, 0, 0};
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                if (i != j) {
                    arr[i] = 0;
                }
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
