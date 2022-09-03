package com.rulinma.algorithm.leetcode.match.weekly.doubleweek;

/**
 * @author 马如林
 * @Data 2022/9/3 22:30
 */
public class Test86 {

    /**
     * 和相等的子数组
     */
    public boolean findSubarrays(int[] nums) {
        // 1. 当前位置的子数组
        // 2. 当前位置后的子数组
        int preSum = nums[0] + nums[1];

        for (int i = 1; i <= nums.length - 1; i++) {
            preSum = nums[i - 1] + nums[i];
            for (int j = i; j < nums.length - 1; j++) {
                // 后续一个个比较
                if (nums[j] + nums[j + 1] == preSum) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Test86 test86 = new Test86();
        int[] nums = new int[]{4, 2, 4};
        System.out.println(test86.findSubarrays(nums));

        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(test86.findSubarrays(nums1));

        int[] nums2 = new int[]{0, 0, 0};
        System.out.println(test86.findSubarrays(nums2));
    }

}
