package com.rulinma.algorithm.leetcode.easy;

import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/6/19 22:49
 */
public class IsPalindromeTest {

    @Test
    public void testIsPalindrome() {
        String str = "A man, a plan, a canal: Panama";
        IsPalindrome isPalindrome = new IsPalindrome();

        System.out.println(isPalindrome.isPalindrome(str));
    }
}
