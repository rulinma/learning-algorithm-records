package com.rulinma.algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1763. 最长的美好子字符串
 * 当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
 * <p>
 * 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "YazaAay"
 * 输出："aAa"
 * 解释："aAa" 是一个美好字符串，因为这个子串中仅含一种字母，其小写形式 'a' 和大写形式 'A' 也同时出现了。
 * "aAa" 是最长的美好子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "Bb"
 * 输出："Bb"
 * 解释："Bb" 是美好字符串，因为 'B' 和 'b' 都出现了。整个字符串也是原字符串的子字符串。
 * 示例 3：
 * <p>
 * 输入：s = "c"
 * 输出：""
 * 解释：没有美好子字符串。
 * <p>
 * https://leetcode.cn/problems/longest-nice-substring
 *
 * @author 马如林
 * @Data 2022/7/1 10:03
 */
public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > ans.length() && check(s.substring(i, j + 1))) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    boolean check(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : s.toCharArray()) {
            char a = Character.toLowerCase(c);
            char b = Character.toUpperCase(c);
            if (!set.contains(a) || !set.contains(b)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestNiceSubstring longestNiceSubstring = new LongestNiceSubstring();
        String s = "YazaAay";
        String result = longestNiceSubstring.longestNiceSubstring(s);
        System.out.println(result);
    }
}
