package com.rulinma.algorithm.leetcode.easy;

/**
 * @author 马如林
 * @Data 2022/8/9 09:16
 */
public class MinimumValueToGetPositiveStepByStepSum {

    public int minStartValue(int[] nums) {
        int accSum = 0;
        int j = 0;
        for (int n : nums) {
            accSum += n;
            nums[j++] = accSum;
        }

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        if (min >= 1) {
            return 1;
        }

        return 1 - min;
    }

    public static void main(String[] args) {
        MinimumValueToGetPositiveStepByStepSum minimumValueToGetPositiveStepByStepSum = new MinimumValueToGetPositiveStepByStepSum();
//        int[] nums = new int[]{-3, 2, -3, 4, 2};
        int[] nums = new int[]{2, 3, 5, -5, -1};
        int rs = minimumValueToGetPositiveStepByStepSum.minStartValue(nums);
        System.out.println(rs);
    }
}
