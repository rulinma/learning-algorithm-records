package com.rulinma.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 1979. 找出数组的最大公约数
 * <p>
 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
 * <p>
 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,9,10]
 * 输出：2
 * 解释：
 * nums 中最小的数是 2
 * nums 中最大的数是 10
 * 2 和 10 的最大公约数是 2
 * <p>
 * https://leetcode.cn/problems/find-greatest-common-divisor-of-array
 *
 * @author 马如林
 * @Data 2022/7/5 16:37
 */
public class FindGreatestCommonDivisorOfArray {

    public int findGCD(int[] nums) {
        // 先对数组进行排序
        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[nums.length - 1];
        int ans = 1;

        // 使用min作为最大公约数，依次递减
        for (int i = min; i >= 1; i--) {
            if (min % i == 0 && max % i == 0) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}
