package com.rulinma.algorithm.leetcode.easy;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 * <p>
 * 输入:s = "a"
 * 输入:1
 * 示例 3:
 * <p>
 * 输入:s = "bb"
 * 输入: 2
 * <p>
 * https://leetcode.cn/problems/longest-palindrome
 *
 * @author 马如林
 * @Data 2022/7/2 08:56
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        // 偶数个同时出现 + 1个奇数（如果有）
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            // 第一次出现奇数时
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }

//    public int longestPalindrome(String s) {
//        int max = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j < s.length(); j++) {
//                if (isPalindrome(s.substring(i, j))) {
//                    max = Math.max(max, j - i);
//                }
//            }
//        }
//
//        return max;
//    }
//
//    public boolean isPalindrome(String x) {
//        int len = x.length();
//        int i = 0;
//
//        while (i < len / 2) {
//            if (x.charAt(i) != x.charAt(len - i - 1)) {
//                return false;
//            }
//            i++;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        int len = longestPalindrome.longestPalindrome("abccccdd");
        System.out.println(len);
    }
}
