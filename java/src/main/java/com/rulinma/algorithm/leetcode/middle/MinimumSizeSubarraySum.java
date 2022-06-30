package com.rulinma.algorithm.leetcode.middle;

/**
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * https://leetcode.cn/problems/minimum-size-subarray-sum
 *
 * @author 马如林
 * @Data 2022/6/30 12:29
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        int totalSum = 0;
        int[] totals = new int[nums.length];

        // 第一次快速遍历
        for (int i = 0; i < len; i++) {
            sum = nums[i];
            if (sum >= target) {
                // 只有一个就OK的，可以直接返回。
                return 1;
            }
        }

        for (int n : nums) {
            totalSum += n;
        }
        if (totalSum < target) {
            return 0;
        }

        // 每个total[i]后面的值
        int pre = 0;
        for (int i = 0; i < len; i++) {
            totals[i] = totalSum - pre;
            pre += nums[i];
        }

        for (int i = 0; i < len; i++) {
            // 测试长度为1，2，3... n的情况下是否满足条件，有则返回。
            // 向下寻找
            sum = nums[i];
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
                if (sum + totals[j] < target) {
                    break;
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            // 未找到
            return 0;
        }

        return minLen;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
//        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
//
//        int result = minimumSizeSubarraySum.minSubArrayLen(7, nums);
//        System.out.println(result);
//
//        nums = new int[]{1, 4, 4};
//        result = minimumSizeSubarraySum.minSubArrayLen(4, nums);
//        System.out.println(result);
//
//        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
//        result = minimumSizeSubarraySum.minSubArrayLen(11, nums);
//        System.out.println(result);

//        int[] nums = new int[]{10, 2, 3};
//        int result = minimumSizeSubarraySum.minSubArrayLen(6, nums);
//        System.out.println(result);

        int[] nums = new int[]{1, 2, 3, 4, 5};
        int result = minimumSizeSubarraySum.minSubArrayLen(11, nums);
        System.out.println(result);
    }
}
