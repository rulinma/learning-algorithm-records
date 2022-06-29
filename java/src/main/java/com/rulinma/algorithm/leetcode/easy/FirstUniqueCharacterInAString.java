package com.rulinma.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 * <p>
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: s = "aabb"
 * 输出: -1
 * <p>
 *
 * https://leetcode.cn/problems/first-unique-character-in-a-string
 *
 * @author 马如林
 * @Data 2022/6/29 15:03
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;

    }

}
