package com.rulinma.algorithm.leetcode.easy;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * <p>
 * https://leetcode.cn/problems/length-of-last-word
 *
 * @author 马如林
 * @Data 2022/6/26 12:03
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int len = s.length();
        int index = len - 1;

        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        // != ' '
        int j = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
            j++;
        }

        return j;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int result = lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(result);
    }
}
