package com.rulinma.algorithm.leetcode.easy;

/**
 * 1281. 整数的各位积和之差
 * <p>
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * <p>
 * https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 *
 * @author 马如林
 * @Data 2022/7/4 10:03
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int multi = 1;
        //
        while (n != 0) {
            int v = n % 10;
            sum += v;
            multi *= v;
            n = n / 10;
        }

        return multi - sum;
    }

    public static void main(String[] args) {
        SubtractTheProductAndSumOfDigitsOfAnInteger subtractTheProductAndSumOfDigitsOfAnInteger = new SubtractTheProductAndSumOfDigitsOfAnInteger();
        int result = subtractTheProductAndSumOfDigitsOfAnInteger.subtractProductAndSum(234);
        System.out.println(result);
    }

}
