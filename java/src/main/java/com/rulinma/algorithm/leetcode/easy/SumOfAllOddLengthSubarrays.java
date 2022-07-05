package com.rulinma.algorithm.leetcode.easy;

/**
 * 1588. 所有奇数长度子数组的和
 * <p>
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * <p>
 * https://leetcode.cn/problems/sum-of-all-odd-length-subarrays
 *
 * @author 马如林
 * @Data 2022/7/5 11:22
 */
public class SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j = j + 2) {
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays sumOfAllOddLengthSubarrays = new SumOfAllOddLengthSubarrays();
        int[] arr = new int[]{1, 4, 2, 5, 3};
        int result = sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(arr);
        System.out.println(result);
    }

}
