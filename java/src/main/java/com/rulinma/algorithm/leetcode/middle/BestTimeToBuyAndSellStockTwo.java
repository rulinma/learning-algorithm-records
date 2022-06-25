package com.rulinma.algorithm.leetcode.middle;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 *
 * @author 马如林
 * @Data 2022/6/25 11:50
 */
public class BestTimeToBuyAndSellStockTwo {

    public int maxProfit(int[] prices) {
        // 1. 选择当前日期前的最小值，保存目前能获得的最大值
        int maxProfit = 0;
        int minPrice = 0;
        int i = 0;
        for(int price : prices) {

        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockTwo bestTimeToBuyAndSellStockTwo = new BestTimeToBuyAndSellStockTwo();
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int result = bestTimeToBuyAndSellStockTwo.maxProfit(nums);
        System.out.println(result);
    }
}
