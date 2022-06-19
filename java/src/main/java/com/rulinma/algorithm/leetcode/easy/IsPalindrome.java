package com.rulinma.algorithm.leetcode.easy;

/**
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
