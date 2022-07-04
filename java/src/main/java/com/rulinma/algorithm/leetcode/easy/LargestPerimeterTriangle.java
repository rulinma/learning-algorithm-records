package com.rulinma.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * <p>
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,2]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1]
 * 输出：0
 * <p>
 * https://leetcode.cn/problems/largest-perimeter-triangle
 *
 * @author 马如林
 * @Data 2022/7/4 10:24
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        // 1. 穷举
        // 2. 排序后测试
        Arrays.sort(nums);
        int max = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            // 贪心，如果这个情况下不能满足，则i-3后面都不会正确
            if (nums[i] < (nums[i - 1] + nums[i - 2])) {
                return (nums[i] + nums[i - 1] + nums[i - 2]);
            }
        }

        return max;
    }
}
