package com.rulinma.algorithm.leetcode.easy;

/**
 * 392. 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * https://leetcode.cn/problems/is-subsequence
 *
 * @author 马如林
 * @Data 2022/6/29 08:48
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public boolean isSubsequence0(String s, String t) {
        // s[] i
        // t[] j
        if (s.length() > t.length()) {
            return false;
        }
        if (s.equals("")) {
            return false;
        }
        char[] ts = t.toCharArray();
        int match = 0;
        int j = 0;
        for (char ch : s.toCharArray()) {
            if (j >= ts.length) {
                return false;
            }

            while (j < ts.length && (ch != ts[j])) {
                j++;
            }

            if (j < ts.length && ch == ts[j]) {
                match++;
                j++;
                if (match == s.length()) {
                    return true;
                }
            }

        }

        return false;

    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence.isSubsequence("axc", "ahbgdc"));
    }
}
