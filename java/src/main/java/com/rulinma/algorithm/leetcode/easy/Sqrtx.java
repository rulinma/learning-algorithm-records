package com.rulinma.algorithm.leetcode.easy;

/**
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 链接：https://leetcode.cn/problems/sqrtx
 *
 * @author 马如林
 * @Data 2022/6/23 09:22
 */
public class Sqrtx {
    /**
     * 折半查找逼近
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int ans = -1;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if ((long) middle * middle > x) {
                high = middle - 1;
            } else if ((long) middle * middle < x) {
                low = middle + 1;
                ans = middle;
            } else if ((long) middle * middle == x) {
                return middle;
            }
        }

        return ans;
    }
}
