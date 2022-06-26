package com.rulinma.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/6/26 12:54
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
