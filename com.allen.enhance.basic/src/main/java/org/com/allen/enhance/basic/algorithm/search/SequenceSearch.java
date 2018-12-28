package org.com.allen.enhance.basic.algorithm.search;

/**
 * @author allen.wu
 * @since 2018-07-09 22:20
 */
public class SequenceSearch {

    public static int sequenceSearch(int[] sz, int key) {
        for (int i = 0; i < sz.length; i++) {
            if (sz[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {5, 3, 1, 2, 99, 60};
        int i = sequenceSearch(arr, 99);
        System.out.println(i);
    }

}
