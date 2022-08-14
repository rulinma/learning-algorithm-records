package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * https://leetcode.cn/problems/coin-change
 *
 * @author 马如林
 * @Data 2022/7/18 10:01
 */
public class CoinChange {

    public int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 状态转换，当前状态和前面状态的转换
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        // dp[n]表示n值时需要的最小硬币个数
        // max表示非法值，不可能由amount +1个组成，假设都是1组成，最多也是amount个
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 获取dp[i]的最小硬币个数

            int min = max;
            for (int coin : coins) {
                // dp[i] = dp[i-coin] + 1
                // 有效
                if (i - coin >= 0) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }

            dp[i] = min;
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;

//        int[] coins = new int[]{2};
//        int amount = 3;
        int rs = coinChange.coinChange(coins, amount);
        System.out.println(rs);
    }
}
