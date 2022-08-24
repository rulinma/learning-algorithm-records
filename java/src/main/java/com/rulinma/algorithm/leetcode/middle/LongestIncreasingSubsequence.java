package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * <p>
 * https://leetcode.cn/problems/longest-increasing-subsequence
 *
 * @author 马如林
 * @Data 2022/8/24 15:58
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        // 动态规划
        int[] dp = new int[nums.length];
        // dp[i] = 前面每个值的最大长度比较
        // 初始为1
        Arrays.fill(dp, 1);

        // 从第2个开始
        for (int i = 1; i < nums.length; i++) {
            // 从0开始比较到i-1
            int v = dp[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 有可能需要+1
                    if (dp[j] + 1 > v) {
                        v = dp[j] + 1;
                    }
                }
            }
            dp[i] = v;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));

        int[] nums1 = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums1));

        int[] nums2 = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums2));
    }
}
