package com.rulinma.algorithm.leetcode.easy;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 * <p>
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 * <p>
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * <p>
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * <p>
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：blocks = "WBBWWBBWBW", k = 7
 * 输出：3
 * 解释：
 * 一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。
 * 得到 blocks = "BBBBBBBWBW" 。
 * 可以证明无法用少于 3 次操作得到 7 个连续的黑块。
 * 所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：blocks = "WBWBBBW", k = 2
 * 输出：0
 * 解释：
 * 不需要任何操作，因为已经有 2 个连续的黑块。
 * 所以我们返回 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] 要么是 'W' ，要么是 'B' 。
 * 1 <= k <= n
 * <p>
 * https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 *
 * @author 马如林
 * @Data 2022/8/24 16:39
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        // K区间范围的个数-B的个数就是就是需要翻转的个数，取最小值
        int min = k;

        char[] chars = blocks.toCharArray();

        int blackCount = 0;
        int left = 0;

        for (int i = 0; i < chars.length; i++) {
            // k个区间取值

            if (chars[i] == 'B') {
                blackCount++;
            }

            // K个长度了，进行判定
            if (i - left == k - 1) {
                // k - blackCount需要翻转的次数
                min = Math.min(k - blackCount, min);
                // 优化
                if (min == 0) {
                    return 0;
                }
                // 左指针移动
                if (chars[left] == 'B') {
                    blackCount--;
                }
                left++;
            }
        }

        return min;
    }
}
