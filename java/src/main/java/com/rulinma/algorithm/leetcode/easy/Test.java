package com.rulinma.algorithm.leetcode.easy;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/8/4 12:26
 */
public class Test {

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        // 去重
        Set<Long> set = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        set.add(1L);
        heap.offer(1L);

        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }

        return ugly;
    }

    public int maxSubArray(int[] nums) {
        // 1 算出dp[i]的最大值
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 前面子串的子数组最大和的值>0，累加才有可能变大
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        for (int x : dp) {
            if (x > max) {
                max = x;
            }
        }

        return max;
    }

    public int singleNumber(int[] nums) {
        int rs = -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int s = map.getOrDefault(n, 0);
            if (s > 0) {
                map.put(n, s + 1);
            } else {
                map.put(n, 1);
            }
        }

        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return rs;
    }

}
