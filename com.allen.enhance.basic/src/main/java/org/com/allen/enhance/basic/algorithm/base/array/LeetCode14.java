package org.com.allen.enhance.basic.algorithm.base.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author allen.wu
 * @since 2020-03-11 19:04
 */
public class LeetCode14 {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        threeSum(arr);
        threeSumHash(arr);
        System.out.println();
        List<List<Integer>> res = threeSumTowPoint(arr);
        for (List<Integer> l : res) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // 暴力求解
    public static void threeSum(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        res.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }
        for (List<Integer> l : res) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void threeSumHash(int[] arr) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int target = -arr[i];
            Map<Integer, Integer> hashMap = new HashMap<>(arr.length - i);
            for (int j = i + 1; j < arr.length - 1; j++) {
                int v = target - arr[j];
                Integer exist = hashMap.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(arr[i], exist, arr[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    hashMap.put(arr[j], arr[j]);
                }
            }
        }
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * threeSumTowPoint
     *
     * @param nums arr.
     */
    public static List<List<Integer>> threeSumTowPoint(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                }
                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return result;
    }
}
