package org.com.allen.enhance.basic.algorithm.dynamic;

/**
 * @author allen.wu
 * @since 2018-08-09 21:25
 */
public class CoinDemo {

    public static void main(String[] args) {
        int arr[] = {1, 5, 10, 20, 50};
        coin1(arr, 10000);
    }

    /**
     * 单纯暴力搜索
     */
    public static void coin1(int[] arr, int aim) {
        long startTime = System.currentTimeMillis();
        if (arr == null || arr.length == 0 || aim < 0) {
        }

        long endTime = System.currentTimeMillis();
        System.out.println("暴力搜索方法所用时间：" + (endTime - startTime) + "ms");
        int[][] mem = new int[aim][aim * arr.length];

        startTime = System.currentTimeMillis();
        process2(arr, 0, aim, mem);
        endTime = System.currentTimeMillis();
        System.out.println("记忆搜索方法所用时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        process3(arr, aim);
        endTime = System.currentTimeMillis();
        System.out.println("动态规划方法所用时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        process4(arr, aim);
        endTime = System.currentTimeMillis();
        System.out.println("动态规划优化方法所用时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        process5(arr, aim);
        endTime = System.currentTimeMillis();
        System.out.println("动态规划空间优化方法所用时间：" + (endTime - startTime) + "ms");
    }

    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i < aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static int process2(int[] arr, int index, int aim, int[][] mem) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int memVal;
            for (int i = 0; arr[index] * i < aim; i++) {
                memVal = mem[index + 1][aim - arr[index] * i];
                if (memVal != 0) {
                    // 将记忆库中的方法数累加到结果中
                    res += memVal == -1 ? 0 : memVal;
                } else {
                    res += process1(arr, index + 1, aim - arr[index] * i);
                }
            }
        }
        mem[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    public static int process3(int[] arr, int aim) {
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            if (i == 0) {
                for (int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = j * arr[i] == 0 ? 1 : 0;
                }
            } else {
                for (int j = 1; j < dp[i].length; j++) {
                    int temp = 0;
                    // 枚举使用k张arr[i]货币后dp[i-1]中组成剩下钱数的方法数
                    for (int k = 0; k * arr[i] <= j; k++) {
                        temp += dp[i - 1][j - k * arr[i]];//方法数累加
                    }
                    dp[i][j] = temp;
                }
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int process4(int[] arr, int aim) {
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < dp[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = j % arr[i] == 0 ? 1 : 0;
                } else if (j >= arr[i]) {
                    dp[i][j] = dp[i][j - arr[i]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int process5(int[] arr, int aim) {
        // 创建dp向量
        int[] dp = new int[aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[0] = 1; // 凑成0元的方法必然是什么货币都不用，只有1种
            for (int j = 1; j < dp.length; j++) {
                if (i == 0) {
                    dp[j] = j % arr[i] == 0 ? 1 : 0;
                } else if (j >= arr[i]) {
                    dp[j] += dp[j - arr[i]];
                }
            }
        }
        return dp[aim];
    }
}
