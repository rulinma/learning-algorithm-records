package com.rulinma.algorithm.leetcode.middle;

/**
 * 2380. 二进制字符串重新安排顺序需要的时间
 * <p>
 * 给你一个二进制字符串 s 。在一秒之中，所有 子字符串 "01" 同时 被替换成 "10" 。这个过程持续进行到没有 "01" 存在。
 * <p>
 * 请你返回完成这个过程所需要的秒数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0110101"
 * 输出：4
 * 解释：
 * 一秒后，s 变成 "1011010" 。
 * 再过 1 秒后，s 变成 "1101100" 。
 * 第三秒过后，s 变成 "1110100" 。
 * 第四秒后，s 变成 "1111000" 。
 * 此时没有 "01" 存在，整个过程花费 4 秒。
 * 所以我们返回 4 。
 * 示例 2：
 * <p>
 * 输入：s = "11100"
 * 输出：0
 * 解释：
 * s 中没有 "01" 存在，整个过程花费 0 秒。
 * 所以我们返回 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 要么是 '0' ，要么是 '1' 。
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能以 O(n) 的时间复杂度解决这个问题吗？
 * <p>
 * https://leetcode.cn/problems/time-needed-to-rearrange-a-binary-string
 *
 * @author 马如林
 * @Data 2022/8/24 16:37
 */
public class TimeNeededToRearrangeABinaryString {
    public int secondsToRemoveOccurrences(String s) {
        int count = 0;

        while (s.contains("01")) {
            s = s.replaceAll("01", "10");
            count++;
        }

        return count;
    }
}
