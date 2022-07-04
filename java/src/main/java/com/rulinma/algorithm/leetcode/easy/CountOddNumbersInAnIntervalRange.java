package com.rulinma.algorithm.leetcode.easy;

/**
 * 1523. 在区间范围内统计奇数数目
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * 示例 2：
 * <p>
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * <p>
 * https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range
 *
 * @author 马如林
 * @Data 2022/7/4 08:50
 */
public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        int result = 0;
        // 奇数开头，奇数结尾
        // 偶数开头，偶数结尾
        // 有一个
        if (low % 2 == 0 && high % 2 == 0) {
            result = (high - low) / 2;
        } else if (low % 2 == 0 || high % 2 == 0) {
            result = (high - low) / 2 + 1;
        } else if (low % 2 != 0 && high % 2 != 0) {
            result = (high - low) / 2 + 1;
        }

        return result;
    }
}
