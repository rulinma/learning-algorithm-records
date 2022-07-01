package com.rulinma.algorithm.leetcode.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters
 *
 * @author 马如林
 * @Data 2022/7/1 15:15
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int maxLen = 1;
        int l = 0;
        int r = 0;

        Set<Character> window = new HashSet<>();
        while (r < s.length()) {
            if (!window.contains(s.charAt(r))) {
                maxLen = Math.max(maxLen, r - l + 1);
                window.add(s.charAt(r));
                r++;
            } else {
                window.remove(s.charAt(l));
                l++;
            }
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int maxLen = 1;
        int l = 0;
        int r = 0;

        Set<Character> window = new HashSet<>();
        while (r < s.length()) {
            while (window.contains(s.charAt(r))) {
                window.remove(s.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            window.add(s.charAt(r));
            r++;
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        // 1. 当前字符串集合
        // 2. 遍历字符串，不存在，j继续； 存在，查看下标，缩减到下标位+1，j继续；
        // 3. maxLen
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length()) {
                // 字符串重复
                int index = s.substring(i, j).indexOf(s.charAt(j));
                if (index >= 0) {
                    // 可以滑动更多
                    maxLen = Math.max(maxLen, j - i);
                    break;
                } else {
                    j++;
                }
            }

            if (j == s.length()) {
                maxLen = Math.max(maxLen, j - i);
            }

            i++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
//        String s = " ";
        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
