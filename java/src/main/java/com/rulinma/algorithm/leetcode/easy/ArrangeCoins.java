package com.rulinma.algorithm.leetcode.easy;

/**
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
        return ( ((long)k * ((long)k + 1))) / 2;
    }

    public static void main(String[] args) {
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        int result = arrangeCoins.arrangeCoins(1804289383);
        System.out.println(result);
//        System.out.println(arrangeCoins.kCoins(600070));
    }
}
