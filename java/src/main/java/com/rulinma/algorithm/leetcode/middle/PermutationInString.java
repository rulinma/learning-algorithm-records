package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * <p>
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * https://leetcode.cn/problems/permutation-in-string
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * @author 马如林
 * @Data 2022/7/1 11:46
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        // 1 s1的所有字符串在s2中出现
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        if (s1.length() > s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        int len = s1.length();
        for (int j = len; j < s2.length(); j++) {
            cnt2[s2.charAt(j - len) - 'a']--;
            cnt2[s2.charAt(j) - 'a']++;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        String s1 = "ab";
        String s2 = "a";

        System.out.println(permutationInString.checkInclusion(s1, s2));
    }
}
