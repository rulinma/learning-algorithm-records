package com.rulinma.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * https://leetcode.cn/problems/isomorphic-strings
 *
 * @author 马如林
 * @Data 2022/6/28 13:29
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        return is(s, t) && is(t, s);
    }

    private boolean is(String s, String t) {
        // 1. s->t
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < cs.length; i++) {
            if (map.get(cs[i]) == null) {
                // 第一次出现，放入
                map.put(cs[i], ts[i]);
            } else {
                // 第二次出现，同现在的值进行比较，如果不等则不正确
                if (map.get(cs[i]) != ts[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphic("foo", "bar"));
        System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
    }
}
