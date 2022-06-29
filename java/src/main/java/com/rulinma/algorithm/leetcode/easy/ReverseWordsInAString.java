package com.rulinma.algorithm.leetcode.easy;

/**
 * 151. 颠倒字符串中的单词
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：颠倒后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * <p>
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。
 * <p>
 * https://leetcode.cn/problems/reverse-words-in-a-string
 *
 * @author 马如林
 * @Data 2022/6/29 22:02
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        String[] sa = s.trim().split(" ");

        int j = sa.length - 1;

        while (j >= 0) {
            if (!sa[j].isEmpty()) {
                sb.append(sa[j].trim() + " ");
            }
            j--;
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
//        String s = "the sky is blue";
        String s = "a good   example";
        String result = reverseWordsInAString.reverseWords(s);
        System.out.println(result);
    }
}
