package com.rulinma.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 链接：https://leetcode.cn/problems/squares-of-a-sorted-array
 *
 * @author 马如林
 * @Data 2022/6/27 11:40
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[nums.length];
        int pos = nums.length - 1;
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                result[pos] = nums[j] * nums[j];
                j--;
            } else {
                result[pos] = nums[i] * nums[i];
                i++;
            }
            pos--;
        }

        return result;
    }

    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        int[] nums = new int[]{-7, -3, 2, 3, 11};
        int[] result = sortedSquares.sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
