package com.rulinma.algorithm.leetcode.easy;

/**
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * https://leetcode.cn/problems/climbing-stairs/
 *
 * @author 马如林
 * @Data 2022/6/19 21:56
 */
public class ClimbStaris {

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairsDynamic(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int t1 = 1;
        int t2 = 2;
        int t = t1 + t2;
        for (int i = 3; i <= n; i++) {
            t = t1 + t2;
            t1 = t2;
            t2 = t;
        }

        return t;
    }

}
