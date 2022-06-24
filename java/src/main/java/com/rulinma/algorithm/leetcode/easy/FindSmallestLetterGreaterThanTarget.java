package com.rulinma.algorithm.leetcode.easy;

/**
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * 示例 2:
 * <p>
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * 示例 3:
 * <p>
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 * <p>
 * https://leetcode.cn/problems/find-smallest-letter-greater-than-target
 *
 * @author 马如林
 * @Data 2022/6/24 17:35
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        char head = letters[0];

        for (char ch : letters) {
            if (ch > target) {
                // continue
                return ch;
            }
        }

        return head;
    }

}
