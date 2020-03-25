package org.com.allen.enhance.basic.algorithm.base.array;

/**
 * @author allen.wu
 * @since 2020-03-11 11:10
 */
public class LeetCode11 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea(arr);
    }

    public static void maxArea(int[] arr) {
        int maxArea = 0;
        int tmpI = 0;
        int tmpJ = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int area = arr[i] * arr[j];
                if (area > maxArea) {
                    maxArea = area;
                    tmpI = i;
                    tmpJ = j;
                }
            }
        }
        System.out.println(maxArea + " - " + tmpI + "," + tmpJ);
    }
}
