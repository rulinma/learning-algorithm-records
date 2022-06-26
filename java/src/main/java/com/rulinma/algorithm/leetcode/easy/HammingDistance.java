package com.rulinma.algorithm.leetcode.easy;

/**
 * 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * https://leetcode.cn/problems/hamming-distance
 *
 * @author 马如林
 * @Data 2022/6/26 15:54
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int s = x ^ y;
        int result = 0;

        while (s != 0) {
            result += (s & 1);
            s >>= 1;
        }
        return result;
    }

}
