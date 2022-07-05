package com.rulinma.algorithm.leetcode.middle;

/**
 * 1768. 交替合并字符串
 * <p>
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * <p>
 * 返回 合并后的字符串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * <p>
 * https://leetcode.cn/problems/merge-strings-alternately
 *
 * @author 马如林
 * @Data 2022/7/5 20:34
 */
public class MergeStringsAlternately {
    
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        int l1 = word1.length();
        int l2 = word2.length();

        while (i < word1.length() && i < l1 && i < l2) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }

        if (l1 > l2) {
            // 只有l1了
            sb.append(word1.substring(i, l1));
        }

        if (l1 < l2) {
            sb.append(word2.substring(i, l2));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "pq";
        MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();
        String result = mergeStringsAlternately.mergeAlternately(s1, s2);

        System.out.println(result);
    }
}
