package com.rulinma.algorithm.leetcode.match.weekly.doubleweek;

import java.math.BigDecimal;

/**
 * @author 马如林
 * @Data 2022/9/19 17:24
 */
public class Test297 {

    /**
     * 2303. 计算应缴税款总额
     */
    public double calculateTax(int[][] brackets, int income) {
        int cal = 0;
        int pre = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income >= brackets[i][0]) {
                cal += (brackets[i][0] - pre) * brackets[i][1];
            } else {
                cal += (income - pre) * brackets[i][1];
                break;
            }
            pre = brackets[i][0];
        }

        return (double) cal / 100;
    }

    public static void main(String[] args) {
        Test297 test297 = new Test297();
        int[][] brackets = new int[][]{{3, 50}, {7, 10}, {12, 25}};
        int income = 10;
        System.out.println(test297.calculateTax(brackets, income));
    }

}
