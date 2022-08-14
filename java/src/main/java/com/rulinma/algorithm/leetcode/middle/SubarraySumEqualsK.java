package com.rulinma.algorithm.leetcode.middle;

/**
 * 560. 和为 knapsack 的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * https://leetcode.cn/problems/subarray-sum-equals-k
 *
 * @author 马如林
 * @Data 2022/7/16 08:27
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int rs = 0;
        // 滑动窗口

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    rs++;
                }
//                else if (sum > k) {
                    // 需要下探一个值，如果>k
//                    break;
//                }
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
//        int[] nums = new int[]{1, 2, 3};
//        int k = 3;
//        int[] nums = new int[]{1, -1, 0};
//        int k = 0;
        int rs = subarraySumEqualsK.subarraySum(nums, k);
        System.out.println(rs);
    }
}
