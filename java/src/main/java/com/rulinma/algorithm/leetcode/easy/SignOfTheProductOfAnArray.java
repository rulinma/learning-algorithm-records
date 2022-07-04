package com.rulinma.algorithm.leetcode.easy;

/**
 * 1822. 数组元素积的符号
 * <p>
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 * <p>
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * <p>
 * 返回 signFunc(product) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * <p>
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array
 *
 * @author 马如林
 * @Data 2022/7/4 22:37
 */
public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int oddCount = 0;
        for (int i : nums) {
            if (i == 0) {
                return 0;
            }

            if (i < 0) {
                oddCount++;
            }
        }

        if (oddCount % 2 == 1) {
            return -1;
        }

        return 1;
    }
}
