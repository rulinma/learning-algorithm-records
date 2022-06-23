package com.rulinma.algorithm.leetcode.easy;

/**
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 链接：https://leetcode.cn/problems/palindrome-number
 *
 * @author 马如林
 * @Data 2022/6/23 21:03
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int len = s.length();
        int i = 0;
        char[] chars = s.toCharArray();

        while (i <= len / 2) {
            if (chars[i] != chars[len - i - 1]) {
                return false;
            }
            i++;
        }

        return true;
    }

}
