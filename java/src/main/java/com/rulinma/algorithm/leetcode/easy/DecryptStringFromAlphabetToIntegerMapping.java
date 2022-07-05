package com.rulinma.algorithm.leetcode.easy;

/**
 * 1309. 解码字母到整数映射
 * <p>
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * <p>
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 * <p>
 * 题目数据保证映射始终唯一。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 * <p>
 * 输入：s = "1326#"
 * 输出："acz"
 * <p>
 * https://leetcode.cn/problems/decrypt-string-from-alphabet-to-integer-mapping
 *
 * @author 马如林
 * @Data 2022/7/5 08:58
 */
public class DecryptStringFromAlphabetToIntegerMapping {

    public String freqAlphabets0(String s) {
        StringBuilder sb = new StringBuilder();
        int index = s.length() - 1;
        while (index >= 0) {
            char c = s.charAt(index);
            int num = 0;
            if (c == '#') {
                num = (s.charAt(index - 2) - '0') * 10 + s.charAt(index - 1) - '0';
                index -= 3;
            } else {
                num = c - '0';
                index--;
            }
            sb.append((char) (num - 1 + 'a'));
        }

        return sb.reverse().toString();
    }

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int num = 0;
            // # 处理
            if (i + 2 < length && s.charAt(i + 2) == '#') {
                num = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
                i += 3;
            } else {
                num = s.charAt(i) - '0';
                i++;
            }
            sb.append((char) (num - 1 + 'a'));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecryptStringFromAlphabetToIntegerMapping().freqAlphabets("10#11#12"));
    }

}
