package com.rulinma.algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2351. 第一个出现两次的字母
 * 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
 * <p>
 * 注意：
 * <p>
 * 如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
 * s 包含至少一个出现两次的字母。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abccbaacz"
 * 输出："c"
 * 解释：
 * 字母 'a' 在下标 0 、5 和 6 处出现。
 * 字母 'b' 在下标 1 和 4 处出现。
 * 字母 'c' 在下标 2 、3 和 7 处出现。
 * 字母 'z' 在下标 8 处出现。
 * 字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
 * <p>
 * https://leetcode.cn/problems/first-letter-to-appear-twice
 *
 * @author 马如林
 * @Data 2022/8/1 18:11
 */
public class FirstLetterToAppearTwice {

    public char repeatedCharacter(String s) {
        char[] chars = new char[26];
        char[] ss = s.toCharArray();
        for (char ch : ss) {
            if (chars[ch - 'a'] == 1) {
                return ch;
            }

            chars[ch - 'a'] = 1;
        }

        return ' ';
    }

    public char repeatedCharacter1(String s) {
        Set<Character> set = new HashSet<Character>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }

        return 'a';
    }
}
