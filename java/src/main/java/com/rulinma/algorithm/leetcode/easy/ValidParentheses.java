package com.rulinma.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 链接：https://leetcode.cn/problems/valid-parentheses
 *
 * @author 马如林
 * @Data 2022/6/23 09:26
 */
public class ValidParentheses {

    /**
     * 使用Stack和Map判断
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                stack.push(')');
            } else if (c.equals('{')) {
                stack.push('}');
            } else if (c.equals('[')) {
                stack.push(']');
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character ch = stack.pop();
                if (!ch.equals(c)) {
                    return false;
                }
            }
        }

        if (stack.empty()) {
            return true;
        }

        return false;

    }

}
