package com.rulinma.algorithm.leetcode.easy;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * https://leetcode.cn/problems/valid-palindrome/
 *
 * @author 马如林
 * @Data 2022/6/19 22:46
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        char[] ch = s.toLowerCase().toCharArray();
        for (char c : ch) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }

        s = sb.toString();

        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
