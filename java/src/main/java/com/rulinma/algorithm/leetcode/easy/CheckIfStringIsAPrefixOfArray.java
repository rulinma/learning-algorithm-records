package com.rulinma.algorithm.leetcode.easy;

/**
 * 1961. 检查字符串是否为数组前缀
 * <p>
 * 给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
 * <p>
 * 字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
 * <p>
 * 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
 * 输出：true
 * 解释：
 * s 可以由 "i"、"love" 和 "leetcode" 相连得到。
 * 示例 2：
 * <p>
 * 输入：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
 * 输出：false
 * 解释：
 * 数组的前缀相连无法得到 s 。
 * <p>
 * https://leetcode.cn/problems/check-if-string-is-a-prefix-of-array
 *
 * @author 马如林
 * @Data 2022/7/5 16:08
 */
public class CheckIfStringIsAPrefixOfArray {

    public boolean isPrefixString(String s, String[] words) {
        // 每个单词和s进行比较
        int count = 0;
        for (String w : words) {
            int pre = count;
            count += w.length();
            if (count > s.length()) {
                return false;
            }
            if (count <= s.length() && !s.substring(pre, count).equals(w)) {
                return false;
            }
            if (count == s.length() && s.substring(pre, count).equals(w)) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfStringIsAPrefixOfArray checkIfStringIsAPrefixOfArray = new CheckIfStringIsAPrefixOfArray();
//        String s = "ilovelexetcode";
//        String[] words = {"i", "love", "leetcode", "apples"};

        String s = "a";
        String[] words = {"aa", "aaaa", "leetcode"};
        System.out.println(checkIfStringIsAPrefixOfArray.isPrefixString(s, words));
    }
}
