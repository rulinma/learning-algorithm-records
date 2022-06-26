package com.rulinma.algorithm.leetcode.easy;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * https://leetcode.cn/problems/longest-common-prefix
 *
 * @author 马如林
 * @Data 2022/6/26 22:02
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        int min = strs[0].length();
        for (String s : strs) {
            min = Math.min(s.length(), min);
        }

        for (int i = 0; i < min; i++) {
            char commonChar = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != commonChar) {
                    return sb.toString();
                }
            }
            sb.append(commonChar);
        }

        return sb.toString();
    }

}
