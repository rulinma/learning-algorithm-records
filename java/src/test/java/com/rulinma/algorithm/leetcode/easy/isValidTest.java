package com.rulinma.algorithm.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/6/23 09:38
 */
@Slf4j
public class isValidTest {

    @Test
    public void testIsValid() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid("()");
        System.out.println(result);
    }
}
