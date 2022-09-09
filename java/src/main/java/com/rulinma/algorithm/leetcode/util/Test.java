package com.rulinma.algorithm.leetcode.util;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/9 21:25
 */
public class Test {

    /**
     * 283. 移动零
     */
    public void moveZeroes(int[] nums) {
        int notZeroPos = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[notZeroPos] = nums[i];
                notZeroPos++;
            }
            i++;
        }

        for (int j = notZeroPos; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        test.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = new int[]{0};
        test.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }

}
