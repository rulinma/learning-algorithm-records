package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * 189. 轮转数组
 *
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * @author 马如林
 * @Data 2022/6/24 12:45
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k > nums.length) {
            return;
        }
        int len = nums.length;
        int index = len - k;

        int[] result = new int[nums.length];
        // k个
        int i = 0;
        while (index < len) {
            result[i++] = nums[index++];
        }

        // 从0开始到k-1个
        int j = 0;
        while (j < len - k) {
            result[i++] = nums[j++];
        }

        nums = result;
        System.out.println(Arrays.toString(nums));

        System.arraycopy(result, 0, nums, 0, len);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);
    }
}
