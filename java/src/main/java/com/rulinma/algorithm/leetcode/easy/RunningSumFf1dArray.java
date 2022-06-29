package com.rulinma.algorithm.leetcode.easy;

/**
 * 1480. 一维数组的动态和
 * <p>
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * <p>
 * https://leetcode.cn/problems/running-sum-of-1d-array
 *
 * @author 马如林
 * @Data 2022/6/29 09:28
 */
public class RunningSumFf1dArray {
    public int[] runningSum(int[] nums) {
        int i = 1;

        while (i < nums.length) {
            nums[i] = nums[i - 1] + nums[i];
            i++;
        }

        return nums;

    }
}
