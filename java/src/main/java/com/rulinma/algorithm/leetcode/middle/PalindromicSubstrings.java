package com.rulinma.algorithm.leetcode.middle;

/**
 * 647. 回文子串
 * <p>
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/palindromic-substrings
 *
 * @author 马如林
 * @Data 2022/9/22 21:46
 */
public class PalindromicSubstrings {
    int ans = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }

        return ans;
    }

    public void extendPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) {
            ans++;
        }
    }
}
