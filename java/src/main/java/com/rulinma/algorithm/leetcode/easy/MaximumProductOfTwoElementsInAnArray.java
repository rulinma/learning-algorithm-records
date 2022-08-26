package com.rulinma.algorithm.leetcode.easy;

/**
 * 1464. 数组中两元素的最大乘积
 * <p>
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * <p>
 * 请你计算并返回该式的最大值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,7]
 * 输出：12
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 * <p>
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array
 *
 * @author 马如林
 * @Data 2022/8/26 09:30
 */
public class MaximumProductOfTwoElementsInAnArray {
    public int maxProduct(int[] nums) {
        int max = nums[0] > nums[1] ? nums[0] : nums[1];
        int second = nums[0] < nums[1] ? nums[0] : nums[1];
        // 一次遍历获取最大的2个值，计算结果即可

        for (int i = 2; i < nums.length; i++) {
            // max second nums[i] 比较设置max和second
            if (nums[i] >= max) {
                second = max;
                max = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            } else {
                // 不变化
            }
        }

        return (max - 1) * (second - 1);
    }
}
