package com.rulinma.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 * <p>
 * https://leetcode.cn/problems/maximum-product-of-three-numbers
 *
 * @author 马如林
 * @Data 2022/6/23 17:45
 */
public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    public int maximumProduct0(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int v = nums[i] * nums[j] * nums[k];
                    if (v > max) {
                        max = v;
                    }
                }
            }
        }

        return max;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, 1, 2, 3};
//        System.out.println(maximumProduct(nums));
    }

}
