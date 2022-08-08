package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * 6138. 最长理想子序列
 * <p>
 * 给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是 理想字符串 ：
 * <p>
 * t 是字符串 s 的一个子序列。
 * t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。
 * 返回 最长 理想字符串的长度。
 * <p>
 * 字符串的子序列同样是一个字符串，并且子序列还满足：可以经由其他字符串删除某些字符（也可以不删除）但不改变剩余字符的顺序得到。
 * <p>
 * 注意：字母表顺序不会循环。例如，'a' 和 'z' 在字母表中位次的绝对差值是 25 ，而不是 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "acfgbd", k = 2
 * 输出：4
 * 解释：最长理想字符串是 "acbd" 。该字符串长度为 4 ，所以返回 4 。
 * 注意 "acfgbd" 不是理想字符串，因为 'c' 和 'f' 的字母表位次差值为 3 。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 3
 * 输出：4
 * 解释：最长理想字符串是 "abcd" ，该字符串长度为 4 ，所以返回 4 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * 0 <= k <= 25
 * s 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/longest-ideal-subsequence
 *
 * @author 马如林
 * @Data 2022/8/8 17:58
 */
public class LongestIdealSubsequence {

    public int longestIdealString(String s, int k) {
        int[] f = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            for (int j = Math.max(c - k, 0); j <= Math.min(c + k, 25); j++) {
                f[c] = Math.max(f[c], f[j]);
            }
            f[c]++;
        }

        return Arrays.stream(f).max().getAsInt();
    }

    public static void main(String[] args) {
        LongestIdealSubsequence longestIdealSubsequence = new LongestIdealSubsequence();
        String s = "acfgbd";
        int k = 2;
        System.out.println(longestIdealSubsequence.longestIdealString(s, k));

        String s1 = "abcd";
        int k1 = 3;
        System.out.println(longestIdealSubsequence.longestIdealString(s1, k1));

        String s2 = "jxhwaysa";
        int k2 = 14;
        System.out.println(longestIdealSubsequence.longestIdealString(s2, k2));

    }
}
