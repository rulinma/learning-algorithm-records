package com.rulinma.algorithm.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 2384. 最大回文数字
 * <p>
 * 给你一个仅由数字（0 - 9）组成的字符串 num 。
 * <p>
 * 请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。
 * <p>
 * 注意：
 * <p>
 * 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
 * 数字可以重新排序。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "444947137"
 * 输出："7449447"
 * 解释：
 * 从 "444947137" 中选用数字 "4449477"，可以形成回文整数 "7449447" 。
 * 可以证明 "7449447" 是能够形成的最大回文整数。
 * 示例 2：
 * <p>
 * 输入：num = "00009"
 * 输出："9"
 * 解释：
 * 可以证明 "9" 能够形成的最大回文整数。
 * 注意返回的整数不应含前导零。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= num.length <= 105
 * num 由数字（0 - 9）组成
 * <p>
 * <p>
 * https://leetcode.cn/problems/largest-palindromic-number
 *
 * @author 马如林
 * @Data 2022/8/24 16:43
 */
public class LargestPalindromicNumber {

    public String largestPalindromic(String num) {
        StringBuilder sb = new StringBuilder();
        // 统计字符串每个ch的出现次数
        // 9-0 统计个数
        // 从9->0开始放字符串，偶数刚好添加一半，奇数则添加偶数部分，剩下的保存为中间值，继续添加后面的值
        // 最后处理前导0的情况
        int max = -1;
        char[] chars = num.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (char ch : chars) {
            int count = map.getOrDefault(Integer.parseInt(String.valueOf(ch)), 0);
            map.put(Integer.parseInt(String.valueOf(ch)), count + 1);
        }

        for (int i = 9; i >= 0; i--) {
            int c = map.getOrDefault(i, 0);
            if (c == 0) {
                continue;
            }

            // 偶数
            if (c % 2 == 0) {
            } else {
                // 奇数
                if (max == -1) {
                    max = i;
                }
            }
            int rc = c / 2;
            for (int j = 0; j < rc; j++) {
                sb.append(i);
            }
        }

        // 最后处理
        String t = sb.toString();
        StringBuilder rt = new StringBuilder(t).reverse();
        ;
        if (max != -1) {
            sb.append(max);
        }

        sb.append(rt);

        // 检查是否前导0的情况，如果是则去掉前面的所有0
        String result = sb.toString();
        // System.out.println(result);
        int zeros = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                zeros++;
            } else {
                break;
            }
        }

        if (zeros == result.length()) {
            return "0";
        }

        if (zeros > 0) {
            return result.substring(zeros, result.length() - zeros);
        }

        return result;
    }

}
