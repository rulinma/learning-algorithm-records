package com.rulinma.algorithm.leetcode.other;

/**
 * @author 马如林
 * @Data 2022/8/14 20:12
 */
public class knapsack {

    public static void main(String[] args) {
        int[] weight = {0, 1, 3, 4};
        int[] value = {0, 15, 20, 30};
        int bagSize = 4;
        testweightbagproblem(weight, value, bagSize);
    }

    //    再回顾一下dp[i][j]的含义：从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
//
//    那么可以有两个方向推出来dp[i][j]，
//
//    不放物品i：由dp[i - 1][j]推出，即背包容量为j，里面不放物品i的最大价值，此时dp[i][j]就是dp[i - 1][j]。(其实就是当物品i的重量大于背包j的重量时，物品i无法放进背包中，所以被背包内的价值依然和前面相同。)
//    放物品i：由dp[i - 1][j - weight[i]]推出，dp[i - 1][j - weight[i]] 为背包容量为j - weight[i]的时候不放物品i的最大价值，那么dp[i - 1][j - weight[i]] + value[i] （物品i的价值），就是背包放物品i得到的最大价值
//    所以递归公式： dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
//
    public static void testweightbagproblem(int[] weight, int[] value, int bagSize) {
        int wlen = weight.length;
        // 定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen][bagSize + 1];

        // 初始化：背包容量为0时，能获得的价值都为0
//        for (int i = 0; i <= wlen; i++) {
//            dp[i][0] = 0;
//        }

        // 初始化：选择物品0时，
//        for (int j = weight[0]; j <= bagSize; j++) {
//            dp[0][j] = value[0];
//        }

        // 遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i < wlen; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    // 背包容量小于物品i的重量
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i < wlen; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
