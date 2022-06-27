package com.rulinma.algorithm.leetcode.easy;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例 1：
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii
 *
 * @author 马如林
 * @Data 2022/6/27 10:41
 */
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // 1. 设定当前单词的wPos=0
        // 2. 遍历s遇到空格，或者末尾(s.length-1)停止，记录当前空格的pos
        // 3. 空格时：获取到当前单词（pos-wPos）长度，pos-1开始输出到sb，再添加空格
        // 4. 末尾时：pos==s.length-1, 返回pos-wPos长度的字符串，进行逆向输出
        int wPos = 0;
        int pos = 0;
        while (pos < s.length()) {
            // 末尾
            if (pos == s.length() - 1) {
                int i = pos;
                int j = 0;
                int len = pos - wPos;
                while (j <= len) {
                    sb.append(s.charAt(i - j));
                    j++;
                }
            }

            //
            if (s.charAt(pos) == ' ') {
                int i = pos;
                int j = 0;
                int len = pos - wPos;
                while (j < len) {
                    sb.append(s.charAt(i - j - 1));
                    j++;
                }
                sb.append(" ");
                // 下一个单词
                wPos = pos + 1;
            }

            pos++;

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String org = "Let's take LeetCode contest";
        ReverseWords reverseWords = new ReverseWords();
        String result = reverseWords.reverseWords(org);
        System.out.println("result: " + result);
    }
}
