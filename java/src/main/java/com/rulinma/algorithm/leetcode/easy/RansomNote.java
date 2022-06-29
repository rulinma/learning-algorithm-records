package com.rulinma.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * https://leetcode.cn/problems/ransom-note
 *
 * @author 马如林
 * @Data 2022/6/29 15:09
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            map1.put(ransomNote.charAt(i), map1.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map2.put(magazine.charAt(i), map2.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        // 重新遍历ransomNote，假如出现count1>count2则返回false
        for (int i = 0; i < ransomNote.length(); i++) {
            int r = map1.getOrDefault(ransomNote.charAt(i), 0);
            int m = map2.getOrDefault(ransomNote.charAt(i), 0);
            if (r > m) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a", "b"));
    }
}
