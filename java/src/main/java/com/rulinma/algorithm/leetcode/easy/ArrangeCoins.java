package com.rulinma.algorithm.leetcode.easy;

/**
 * 441. 排列硬币
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * <p>
 * https://leetcode.cn/problems/arranging-coins
 *
 * @author 马如林
 * @Data 2022/6/24 11:26
 */
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        int row = 1;
        for (int i = 1; i <= n; i++) {
            long ks = kCoins(i);
            if (ks == n) {
                return i;
            } else if (ks < n) {
            } else if (ks > n) {
                return i - 1;
            }
        }
        return row;
    }

    public long kCoins(int k) {
        return (((long) k * ((long) k + 1))) / 2;
    }

    public static void main(String[] args) {
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        int result = arrangeCoins.arrangeCoins(1804289383);
        System.out.println(result);
//        System.out.println(arrangeCoins.kCoins(600070));
    }
}
