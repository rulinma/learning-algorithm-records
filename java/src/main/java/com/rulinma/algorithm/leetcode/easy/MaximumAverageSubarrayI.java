package com.rulinma.algorithm.leetcode.easy;

/**
 * 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * https://leetcode.cn/problems/maximum-average-subarray-i
 *
 * @author 马如林
 * @Data 2022/7/1 12:03
 */
public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        double result = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result = sum;

        for (int j = k; j < nums.length; j++) {
            sum += nums[j];
            sum -= nums[j - k];
            if (sum > result) {
                result = sum;
            }
        }

        return result / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        int[] num = new int[]{1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(maximumAverageSubarrayI.findMaxAverage(num, k));
    }
}
