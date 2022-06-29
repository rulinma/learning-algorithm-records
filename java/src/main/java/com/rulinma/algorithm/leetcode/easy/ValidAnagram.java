package com.rulinma.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * https://leetcode.cn/problems/valid-anagram
 *
 * @author 马如林
 * @Data 2022/6/29 15:21
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        // 重新遍历ransomNote，假如出现count1>count2则返回false
        for (int i = 0; i < s.length(); i++) {
            int r = map1.getOrDefault(s.charAt(i), 0);
            int m = map2.getOrDefault(s.charAt(i), 0);
            if (r != m) {
                return false;
            }
        }

        return true;
    }
}
