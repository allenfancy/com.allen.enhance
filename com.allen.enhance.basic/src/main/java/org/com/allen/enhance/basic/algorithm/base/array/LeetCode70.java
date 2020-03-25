package org.com.allen.enhance.basic.algorithm.base.array;

/**
 * @author allen.wu
 * @since 2020-03-11 11:38
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
