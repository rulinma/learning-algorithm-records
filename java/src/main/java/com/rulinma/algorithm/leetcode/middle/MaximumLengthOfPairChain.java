package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 * <p>
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 给出数对的个数在 [1, 1000] 范围内。
 * <p>
 * https://leetcode.cn/problems/maximum-length-of-pair-chain
 *
 * @author 马如林
 * @Data 2022/9/3 08:42
 */
public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        // 最长子序列的翻版
        // 动态规划

//        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        // 首先需要对pairs进行排序

        // 1、第i个分析：如果i个满足条件则dp[i] = dp[i-1] + 1, 否则 dp[i] = dp[i-1]，从上面2个中选择max
        // 2、初始化条件：dp[0] = 1;
        // 3、返回dp[i]中最大的
        int[] dp = new int[pairs.length];

        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            // 从前往后遍历到当前位置，检查每个和dp[i]的情况设置最大值
            int m = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    m = Math.max(m, dp[j] + 1);
                } else {
                    m = Math.max(m, dp[j]);
                }
            }
            dp[i] = m;
        }

        int max = 0;
        for (int i = 0; i < pairs.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }


}
