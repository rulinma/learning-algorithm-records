package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/18 10:30
 */
public class Test311 {

    /**
     * 最长的字母序连续子字符串的长度
     */
    public int longestContinuousSubstring(String s) {
        // 动态规划
        // dp[i] 表示以i为结尾的字字符串长度
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        int ans = 1;

        for (int i = 1; i < s.length(); i++) {
            // 如果i 是 i-1 的递增，则dp[i] = dp[i-1] + 1
            if (chars[i] - chars[i - 1] == 1) {
                dp[i] = dp[i - 1] + 1;
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }

    /**
     * 6180. 最小偶倍数
     */
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }

        return 2 * n;
    }

    public static void main(String[] args) {
        Test311 test311 = new  Test311();
        String s = "abacaba";
        int rs = test311.longestContinuousSubstring(s);
        System.out.println(rs);
    }
}
