package com.rulinma.algorithm.leetcode.easy;

/**
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 * <p>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * <p>
 * 链接：https://leetcode.cn/problems/max-consecutive-ones
 *
 * @author 马如林
 * @Data 2022/6/23 17:41
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        int count = 0;
        for (int x : nums) {
            if (x != 1) {
                count = 0;
            } else {
                count++;
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }

}
