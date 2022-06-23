package com.rulinma.algorithm.leetcode.easy;

/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 * 链接：https://leetcode.cn/problems/valid-perfect-square
 *
 * @author 马如林
 * @Data 2022/6/23 12:45
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if ((long) middle * middle == num) {
                return true;
            } else if ((long) middle * middle < num) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(2000105819));
    }
}
