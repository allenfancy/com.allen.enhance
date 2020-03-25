package org.com.allen.enhance.basic.algorithm.base.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author allen
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int it = map.get(nums[i]) + 1;
                map.put(nums[i], it++);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mid) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int majorityElementV2(int[] nums) {
        int res = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
                cnt++;
            } else {
                if (res == nums[i]) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        LeetCode169 lc = new LeetCode169();
        int i = lc.majorityElement(arr);
        int i1 = lc.majorityElementV2(arr);
        System.out.println(i);
        System.out.println(i1);
    }
}
