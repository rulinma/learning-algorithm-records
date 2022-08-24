package com.rulinma.algorithm.leetcode.middle;

/**
 * 2381. 字母移位 II
 * <p>
 * 给你一个小写英文字母组成的字符串 s 和一个二维整数数组 shifts ，其中 shifts[i] = [starti, endi, directioni] 。对于每个 i ，将 s 中从下标 starti 到下标 endi （两者都包含）所有字符都进行移位运算，如果 directioni = 1 将字符向后移位，如果 directioni = 0 将字符向前移位。
 * <p>
 * 将一个字符 向后 移位的意思是将这个字符用字母表中 下一个 字母替换（字母表视为环绕的，所以 'z' 变成 'a'）。类似的，将一个字符 向前 移位的意思是将这个字符用字母表中 前一个 字母替换（字母表是环绕的，所以 'a' 变成 'z' ）。
 * <p>
 * 请你返回对 s 进行所有移位操作以后得到的最终字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
 * 输出："ace"
 * 解释：首先，将下标从 0 到 1 的字母向前移位，得到 s = "zac" 。
 * 然后，将下标从 1 到 2 的字母向后移位，得到 s = "zbd" 。
 * 最后，将下标从 0 到 2 的字符向后移位，得到 s = "ace" 。
 * 示例 2:
 * <p>
 * 输入：s = "dztz", shifts = [[0,0,0],[1,1,1]]
 * 输出："catz"
 * 解释：首先，将下标从 0 到 0 的字母向前移位，得到 s = "cztz" 。
 * 最后，将下标从 1 到 1 的字符向后移位，得到 s = "catz" 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, shifts.length <= 5 * 104
 * shifts[i].length == 3
 * 0 <= starti <= endi < s.length
 * 0 <= directioni <= 1
 * s 只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/shifting-letters-ii
 *
 * @author 马如林
 * @Data 2022/8/24 16:40
 */
public class ShiftingLettersTwo {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int[] cs = new int[chars.length];
        // 原始字符串的每个字符的ascii码
        for (int i = 0; i < chars.length; i++) {
            cs[i] = chars[i] - 'a';
        }

        // 建立差分数组
        int[] difference = new int[cs.length];
        difference[0] = cs[0];
        for (int i = 1; i < cs.length; i++) {
            difference[i] = cs[i] - cs[i - 1];
        }

        // 差分数组上区间操作
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1];
            int direction = shift[2];
            direction = (direction == 1) ? 1 : -1;
            difference[start] += direction;
            if (end + 1 < difference.length) {
                difference[end + 1] -= direction;
            }
        }

        // 差分数组反推出原数组
        int[] result = new int[cs.length];
        result[0] = (difference[0]) % 26;
        for (int i = 1; i < difference.length; i++) {
            result[i] = (result[i - 1] + difference[i]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for (int j : result) {
            // 有可能是负数(范围在[-25,0] )，所以要加上26
            if (j < 0) j = 26 + j;
            j = j % 26;
            sb.append((char) (j + 'a'));
        }
        return sb.toString();
    }

}
