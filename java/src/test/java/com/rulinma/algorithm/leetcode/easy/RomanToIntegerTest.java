package com.rulinma.algorithm.leetcode.easy;

import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/6/23 12:35
 */
public class RomanToIntegerTest {

    @Test
    public void testRomanToInteger() {
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt("IV");
        System.out.println(result);
    }
}
