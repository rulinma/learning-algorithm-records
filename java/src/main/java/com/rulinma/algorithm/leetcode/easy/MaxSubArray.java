package com.rulinma.algorithm.leetcode.easy;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>
 * https://leetcode.cn/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
 *
 * @author 马如林
 * @Data 2022/6/23 17:02
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            // 前面子串的子数组最大和的值>0，累加才有可能变大
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray0(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray1(int[] nums) {
        // 固定左侧
        int ansMax = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            // 移动右侧
            int curSum = 0;
            for (int j = i; j < nums.length; ++j) {
                // 得到当前最大值
                curSum += nums[j];
                ansMax = curSum > ansMax ? curSum : ansMax;
            }
        }

        return ansMax;
    }

    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;

    }
}
