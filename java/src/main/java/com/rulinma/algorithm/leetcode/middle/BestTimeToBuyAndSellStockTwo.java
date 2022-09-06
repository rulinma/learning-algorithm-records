package com.rulinma.algorithm.leetcode.middle;

/**
 * @author 马如林
 * @Data 2022/9/6 21:14
 */
public class BestTimeToBuyAndSellStockTwo {

    public int maxProfit(int[] prices) {
        int rs = 0;
        // 获取每段区间能获得的最大值，累加就是最大值
        // 所有上涨日买入
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                rs += prices[i] - prices[i - 1];
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockTwo bestTimeToBuyAndSellStockTwo = new BestTimeToBuyAndSellStockTwo();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int rs = bestTimeToBuyAndSellStockTwo.maxProfit(prices);

        System.out.println(rs);

        int[] prices1 = new int[]{1, 2, 3, 4, 5};
        int rs1 = bestTimeToBuyAndSellStockTwo.maxProfit(prices1);

        System.out.println(rs1);


        int[] prices2 = new int[]{7, 6, 4, 3, 1};
        int rs2 = bestTimeToBuyAndSellStockTwo.maxProfit(prices2);

        System.out.println(rs2);
    }
}
