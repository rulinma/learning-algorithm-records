package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/20 08:21
 */
public class PartitionToKEqualSumSubsets {

    private int[] nums;
    private int[] cur;
    private int average;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 1.
        Arrays.sort(nums);
        this.nums = nums;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        // 不能均分
        if (sum % k != 0) {
            return false;
        }

        average = sum / k;

        cur = new int[k];

        return dfs(nums.length - 1);
    }

    private boolean dfs(int i) {
        if (i < 0) {
            return true;
        }
        for (int j = 0; j < cur.length; ++j) {
            if (j > 0 && cur[j] == cur[j - 1]) {
                continue;
            }
            cur[j] += nums[i];
            if (cur[j] <= average && dfs(i - 1)) {
                return true;
            }
            cur[j] -= nums[i];
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
